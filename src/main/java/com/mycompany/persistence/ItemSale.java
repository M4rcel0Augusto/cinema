/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="item_sale")
public class ItemSale {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name="sale_id")
    private Sale sale;
    
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name ="combo_id")
    private Combo combo;
    
    private int quantity;
    
    @Column(name = "refund_quantity")
    private int refundQuantity = 0;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "unit_cost", nullable = false)
    private double unitCost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRefundQuantity() {
        return refundQuantity;
    }

    public void setRefundQuantity(int refundQuantity) {
        this.refundQuantity = refundQuantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    
    
    
    
    

    
    }

   
    
