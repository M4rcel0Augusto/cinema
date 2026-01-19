/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

/**
 *
 * O processo de criptografar vai ficar no model
 */
public class UserDAO {
    
    public User validateLogin(String hashPassword){
        EntityManager em = JPAUtil.getEntityManager();
        
        try{
            TypedQuery<User> query = em.createQuery("SELECT u from User u WHERE u.password = :password", User.class);
            
            query.setParameter("password", hashPassword);
            
            return query.getSingleResult();
        
        }catch(NoResultException ex){
            return null;
        }finally{
            em.close();
        }
    
    }
    
    
    
}
