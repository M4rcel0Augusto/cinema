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
public class ComboDAO extends SuperDAO<Combo>{   
   
    public ComboDAO(){
        super(Combo.class);
    }
    
    public List<Combo> list(){
    
        EntityManager em = JPAUtil.getEntityManager();
        List<Combo> combos;
        
        try{
            TypedQuery<Combo> query = em.createQuery("SELECT c FROM Combo c", Combo.class);
            combos= query.getResultList();
        }catch(Exception ex){
            System.out.println("Erro: "+ex.getMessage());
            combos = new ArrayList<>();
        }finally{
            em.close();
        }
        return combos;
    }
    
    
    
    
    
    
}
