/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author conve
 */
public class ProductDAO extends SuperDAO<Product> {
    
 
    public ProductDAO(){
        super(Product.class);
    }
    
    public List<Product> list(/*Criar filtro por type */){
    
            EntityManager em =JPAUtil.getEntityManager();
            List<Product> products;

    try {
        TypedQuery<Product> query =
        em.createQuery("SELECT p FROM Product p", Product.class);
        products = query.getResultList();
        }catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            products = new ArrayList<>();
        }finally {
            em.close();
    }

        return products;
            
            
    
    }
    
    
    
    }
        
        
        
        
    
    
    



