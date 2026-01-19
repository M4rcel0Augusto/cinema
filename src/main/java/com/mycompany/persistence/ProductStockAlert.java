/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="product_stock_alert")
public class ProductStockAlert {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private int id;
    
    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;
    
    @Column(name="minimum_quantity")
    private Integer minimumQuantity;
            //Integer, para poder usar o if == null no StockAlertService
    
    @Column(name="below_minimum")
    private boolean belowMinimum = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public boolean isBelowMinimum() {
        return belowMinimum;
    }

    public void setBelowMinimum(boolean belowMinimum) {
        this.belowMinimum = belowMinimum;
    }

    

    
    
    

    
    
    
    
    
    
}
