/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author conve
 */
public class ProductStockAlertDAO extends SuperDAO<ProductStockAlert> {
    
     public ProductStockAlertDAO(){
        super(ProductStockAlert.class);
        
        
    }
    public List<ProductStockAlert> listBelowMinimum(){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT a FROM ProductStockAlert a WHERE a.belowMinimum = true",
                ProductStockAlert.class
            ).getResultList();
        } finally {
            em.close();
        }
        /*
        
        try{
            TypedQuery<Combo> query = em.createQuery("SELECT c FROM Combo c", Combo.class);
            combos= query.getResultList();
        }catch(Exception ex){
            System.out.println("Erro: "+ex.getMessage());
            combos = new ArrayList<>();
        }finally{
            em.close();
        }
        return combos;
        */
    }
    
    public ProductStockAlert findByProductId(int productId) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            return em.createQuery(
                "SELECT a FROM ProductStockAlert a WHERE a.product.id = :id",
                ProductStockAlert.class
            )
            .setParameter("id", productId)
            .getSingleResult();
            
        } catch (Exception ex) {
            System.out.println("Erro: "+ex.getMessage());
            return null;
            
        } finally {
            em.close();
        }
    }
    
}
