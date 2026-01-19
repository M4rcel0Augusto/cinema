/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

//Cinema-Application
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author conve
 */
public class JPAUtil {
    private static final String PERSISTENCE_UNIT = "Cinema-Application";
    
    
    private static EntityManagerFactory factory;
    static {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT); }
    public static EntityManager getEntityManager(){
        
        return factory.createEntityManager();
            
        }
        
    }
    
   
    
    
    
    

