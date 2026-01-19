/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.persistence.Combo;
import com.mycompany.persistence.ComboItem;
import com.mycompany.persistence.ItemSale;
import com.mycompany.persistence.JPAUtil;
import com.mycompany.persistence.Product;
import com.mycompany.persistence.Sale;
import com.mycompany.persistence.Screening;
import com.mycompany.persistence.ScreeningDAO;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * SuperDAo só funciona para operações simples.
 * Ora, aqui haverá alteração no Estoque em Produto, inserção em Sale e ItemSale.
 * Assim sendo, será usado essa classe para finalizar venda.
 */
public class SaleService {
    
    public void finalizeSale(SaleTemp temp) {
    EntityManager em = JPAUtil.getEntityManager();

    try {
        em.getTransaction().begin();

        List<Screening> screenings = em.createQuery(
            "SELECT s FROM Screening s WHERE s.start >= :now ORDER BY s.start ASC",
            Screening.class
        )
        .setParameter("now", LocalDateTime.now())
        .setMaxResults(1)
        .getResultList();

        if (screenings.isEmpty()) {
            throw new RuntimeException("Não há sessões futuras cadastradas.");
        }

        Screening screening = screenings.get(0);

        Sale sale = new Sale();
        sale.setSaleDatetime(LocalDateTime.now());
        sale.setScreening(screening);
        sale.setTotalAmount(temp.getTotalAmount());

        em.persist(sale);
        
        StockAlertService alertService = new StockAlertService();
        //Tratamento de Combo e Produto
        for (ItemSaleTemp item : temp.getItems()) {

            if(item.isProduct()){
                processProductItem(em, sale, item, alertService);
            }
            if(item.isCombo()){
                processComboItem(em, sale, item, alertService);
            }

            
        }

        em.getTransaction().commit();

    } catch (Exception ex) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        System.out.println("Erro: "+ex.getMessage());
        throw ex;
    } finally {
        em.close();
    }
}

    
    private void processProductItem(EntityManager em, Sale sale, ItemSaleTemp item, StockAlertService alertService) {

    Product p = em.find(Product.class, item.getProduct().getId());

    p.setQuantityInStock(p.getQuantityInStock() - item.getQuantity());
    
    //alerta
    alertService.checkAlert(p, em);

    ItemSale saleItem = new ItemSale();
    saleItem.setSale(sale);
    saleItem.setProduct(p);
    saleItem.setQuantity(item.getQuantity());
    saleItem.setUnitPrice(p.getUnitPrice());
    saleItem.setUnitCost(p.getUnitCost());

    em.persist(saleItem);
    
}

    private void processComboItem(EntityManager em, Sale sale, ItemSaleTemp comboItem, StockAlertService alertService) {

    Combo combo = em.find(Combo.class, comboItem.getCombo().getId());

    for (ComboItem ci : combo.getItems()) {

        Product p = ci.getProduct();

        int totalQuantity =
            ci.getQuantity() * comboItem.getQuantity();

        p.setQuantityInStock(p.getQuantityInStock() - totalQuantity);
        
        alertService.checkAlert(p, em);

        ItemSale saleItem = new ItemSale();
        saleItem.setSale(sale);
        saleItem.setProduct(p);
        saleItem.setQuantity(totalQuantity);
        saleItem.setCombo(combo);
        saleItem.setUnitPrice(p.getUnitPrice());
        saleItem.setUnitCost(p.getUnitCost());

        em.persist(saleItem);
    }
}


    
    


    
}
