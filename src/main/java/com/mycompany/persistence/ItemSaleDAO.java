/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author conve
 */
public class ItemSaleDAO extends SuperDAO<ItemSale> {
  
    public ItemSaleDAO(){
        super(ItemSale.class);
    }
    //Para o histórico de vendas
    public List<ItemSale> list(){
    
    EntityManager em = JPAUtil.getEntityManager();
    List<ItemSale> items;
    
    try{
        TypedQuery<ItemSale> query =
                em.createQuery("SELECT i from ItemSale i", ItemSale.class);
        items=query.getResultList();
    }catch(Exception ex){
        System.out.println("Erro: "+ex.getMessage());
        items = new ArrayList<>();
    }finally{em.close();}
    return items;
    }
    
    
    
    
}
