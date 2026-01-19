 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.persistence.Product;

/**
 *
 * @author conve
 */
public class ComboItemTemp {
    
    private Product product;
    private int quantity;
    
    //Construtor
    public ComboItemTemp(Product product){
    
        this.product = product;
        this.quantity = 1;
    }
    //Se for adicionado um item repetido, só aumentará a quantidade
    public void increment(){
        
        quantity++;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
}
