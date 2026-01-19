/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="combo_item")
public class ComboItem {
    @EmbeddedId // Utiliza o método Serializable
    private ComboItemId id;
    
    
    @ManyToOne
    @MapsId("comboId")
    private Combo combo;
    @ManyToOne
    @MapsId("productId")
    private Product product;
    
    private int quantity;
    

    public ComboItemId getId() {
        return id;
    }

    public void setId(ComboItemId id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
}
