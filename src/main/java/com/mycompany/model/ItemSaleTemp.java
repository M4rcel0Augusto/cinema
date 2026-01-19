/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.persistence.Combo;
import com.mycompany.persistence.Product;

/**
 *
 * @author conve
 */
public class ItemSaleTemp {
    
    private Product product;
    private Combo combo;
    private int quantity;
    
    public ItemSaleTemp(Product product){
        this.product= product;
        this.quantity =1;
    }
    
    public ItemSaleTemp(Combo combo){
        this.combo=combo;
        this.quantity = 1;
    }
    
    //Para diferenciar combo de produto individual.
    
    public boolean isProduct(){
        return product !=null;
    }
    
    public boolean isCombo(){
        return combo != null;
    }
    
    
    
    //Falicitar na hora de programar ItemCart
    public Product getProduct(){
        return product;
    }
    public void increment(){
        quantity++;
    
    }
    public void decrease(){
        if(quantity>0){
        quantity--;}
    
    }
    
    public double getSubtotal(){
        if (isProduct()) {
        return product.getUnitPrice() * quantity;
    }
    if (isCombo()) {
        return combo.getPrice() * quantity; 
    }
    return 0;

    
    }

    public int getQuantity() {
        return quantity;
    }

    public Combo getCombo() {
        return combo;
    }


    
    
    
}
