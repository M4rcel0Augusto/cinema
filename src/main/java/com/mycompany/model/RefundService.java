/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.persistence.ItemSale;
import com.mycompany.persistence.JPAUtil;
import com.mycompany.persistence.Sale;
import jakarta.persistence.EntityManager;

/**
 *
 * Em caso de reembolso, não será adicionado item algum ao estoque.
 */
public class RefundService {
   


    
    public void refundItem(long itemSaleId, int quantityToRefund) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            //Excpetions
            ItemSale item = em.find(ItemSale.class, itemSaleId);
            if (item == null) {
                throw new RuntimeException("ItemSale não encontrado");
            }
            int availableToRefund =
                    item.getQuantity() - item.getRefundQuantity();
            if (quantityToRefund <= 0) {
                throw new RuntimeException("Quantidade inválida para reembolso");
            }
            if (quantityToRefund > availableToRefund) {
                throw new RuntimeException(
                    "Quantidade excede o disponível para reembolso"
                );
            }

            // Atualiza refund do item
            item.setRefundQuantity(
                item.getRefundQuantity() + quantityToRefund
            );

            // Atualiza total da venda
            Sale sale = item.getSale();
            double refundValue = quantityToRefund * item.getUnitPrice();
            sale.setTotalAmount(
                sale.getTotalAmount() - refundValue
            );

            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;

        } finally {
            em.close();
        }
    }
}

    

