/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import jakarta.persistence.EntityManager;

/**
 Uma classe mãe para reduzir a criação do mesmo método várias vezes.
 * Aqui terá: register, delete, update, select.
 * Não terá List, por conta dos filtros.
 */
public abstract class SuperDAO<T> {
    
    private Class<T> entityClass; //T means type
    
    protected SuperDAO(Class<T> entityClass){
        this.entityClass = entityClass;
    
    }
    
    public void register(T entity){
        EntityManager em = JPAUtil.getEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }catch(Exception ex){
            em.getTransaction().rollback();
            System.out.println("Erro: "+ex.getMessage());
            
        }finally{
            em.close();
        }

    
    }
    
    public void delete(T entity) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        em.getTransaction().begin();
        entity = em.merge(entity); // MUITO IMPORTANTE
        em.remove(entity);
        em.getTransaction().commit();
    } catch (Exception ex) {
        em.getTransaction().rollback();
        throw ex;
    } finally {
        em.close();
    }
}

    
    public T select(int id){
        EntityManager em = JPAUtil.getEntityManager();
        
        try{
            return em.find(entityClass, id);
        }finally{
            em.close();
        }
    
    }
    
    public void update(T entity){
        EntityManager em = JPAUtil.getEntityManager();
        
        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }catch(Exception ex){
            em.getTransaction().rollback();
            System.out.println("Erro:"+ex.getMessage());
        }finally{
            em.close();
        }
    }
    
}
