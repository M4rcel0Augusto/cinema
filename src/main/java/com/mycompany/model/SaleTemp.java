/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.persistence.Combo;
import com.mycompany.persistence.Product;
import com.mycompany.persistence.Screening;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author conve
 */
public class SaleTemp {
    
    private List<ItemSaleTemp> items = new ArrayList<>();
    private Screening screening;
    
    public void addProduct(Product product) {
        for (ItemSaleTemp item : items) {
            if (item.isProduct() && item.getProduct().getId() == product.getId()) {
                item.increment();
                return;
            }
    }
    items.add(new ItemSaleTemp(product));
}

    
    
    public void addCombo(Combo combo) {
        for (ItemSaleTemp item : items) {
            if (item.isCombo() && item.getCombo().getId() == combo.getId()) {
                item.increment();
                return;
            }
    }
    items.add(new ItemSaleTemp(combo));
}
    //Remover produtos do carrinho
    public void removeProduct(Product product){
        Iterator<ItemSaleTemp> it = items.iterator();
        while (it.hasNext()) {
            ItemSaleTemp item = it.next();
            if (item.getProduct().getId() == product.getId()) {
                item.decrease();
                if (item.getQuantity() <= 0) {
                    it.remove();
                }
            return;
        }
    }
}
    
    //Remover combos do carrinho
    public void removeCombo(Combo combo) {
    Iterator<ItemSaleTemp> it = items.iterator();

    while (it.hasNext()) {
        ItemSaleTemp item = it.next();

        if (item.isCombo() && item.getCombo().getId() == combo.getId()) {
            item.decrease();

            if (item.getQuantity() <= 0) {
                it.remove();
            }
            return;
        }
    }
}


    
    public double getTotalAmount(){
    return items.stream().mapToDouble(ItemSaleTemp::getSubtotal).sum();
}


    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }
    
    
    public List<ItemSaleTemp> getItems(){
        return items;
    }
    
    
}
