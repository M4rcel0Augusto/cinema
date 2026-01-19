/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sale")
public class Sale { 
//como uma lista. é o id da pessoa que faz 5 pedidos de uma vez, por exemplo.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="sale_datetime")
    private LocalDateTime saleDatetime;

    @ManyToOne
    @JoinColumn(name="screening_id")
    private Screening screening;
    
    @Column(name = "total_amount")
    private double totalAmount;
    
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<ItemSale> items = new ArrayList<>();
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getSaleDatetime() {
        return saleDatetime;
    }

    public void setSaleDatetime(LocalDateTime saleDatetime) {
        this.saleDatetime = saleDatetime;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ItemSale> getItems() {
        return items;
    }

    public void setItems(List<ItemSale> items) {
        this.items = items;
    }

    

    

    
    
    
    
    
}
