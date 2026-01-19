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
public class ComboItemDAO extends SuperDAO<ComboItem>{
    
    public ComboItemDAO(){
        super(ComboItem.class);
    }
    
    //Para ver os itens presentes no Combo
    public List<ComboItem> ListItems(int comboId){
    
        EntityManager em = JPAUtil.getEntityManager();
        List<ComboItem> items;
        
        try{
            TypedQuery<ComboItem> query = em.createQuery("SELECT ci FROM ComboItem ci WHERE ci.combo.id =:id", ComboItem.class);
            
            query.setParameter("id", comboId);
            items = query.getResultList();
        }catch(Exception ex){
            System.out.println("Erro: "+ex.getMessage());
            items = new ArrayList<>();
        }finally{
            em.close();
        }
        return items;
    
    }
    
    
    
}
