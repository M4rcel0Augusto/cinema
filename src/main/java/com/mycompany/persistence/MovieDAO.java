/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author conve
 */
public class MovieDAO extends SuperDAO<Movie> {
    
    public MovieDAO(){
        super(Movie.class);
    }

public List<Movie> listMovie(){
    
    EntityManager em = JPAUtil.getEntityManager();
    
    List<Movie> movies =new ArrayList<Movie>();
    
    try{
        Query screening = em.createQuery("Select m from Movie m order by m.id desc");
        movies = screening.getResultList();
    }catch(Exception ex){
        em.getTransaction().rollback();
        System.out.println("Erro: "+ ex.getMessage());
    }finally{
        em.close();
    
    }
    return movies;

}    
        
    
  
    
}
