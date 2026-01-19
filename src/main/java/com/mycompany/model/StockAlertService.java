/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.persistence.Product;
import com.mycompany.persistence.ProductStockAlert;
import com.mycompany.persistence.ProductStockAlertDAO;
import jakarta.persistence.EntityManager;


/**
 *
 * @author conve
 */
public class StockAlertService {
    


    public void checkAlert(Product product, EntityManager em) {

        ProductStockAlert alert = em.createQuery(
            "SELECT a FROM ProductStockAlert a WHERE a.product.id = :id",
            ProductStockAlert.class
        )
        .setParameter("id", product.getId())
        .getResultStream()
        .findFirst()
        .orElse(null);

        if (alert == null || alert.getMinimumQuantity() == null) {
            return;
        }

        boolean below =
            product.getQuantityInStock() < alert.getMinimumQuantity();

        alert.setBelowMinimum(below);

        em.merge(alert);
    }
}

    

