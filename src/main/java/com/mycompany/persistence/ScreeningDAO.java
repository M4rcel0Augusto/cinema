/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author conve
 */
public class ScreeningDAO extends SuperDAO<Screening> {
   
    
    public ScreeningDAO(){
        super(Screening.class);
    }
   
    /*
    if filter == true: Serão exibidas as sessões a exibir.
    if filter == false: Serão exibidas todas as sessões.
    */                            
    public List<Screening> list(Boolean filter){
        
        EntityManager em = JPAUtil.getEntityManager();
        List<Screening> screenings = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        
        try{
            Query query;
            String queryText = "SELECT s FROM Screening s";
            
            if(filter == true){
                queryText = queryText +" where s.start> :now";
                query = em.createQuery(queryText);
                query.setParameter("now", now);
            
            }else{
            
            query = em.createQuery(queryText);
            
            }
            screenings =query.getResultList();
        }catch(Exception ex){
           
            System.out.println("Erro: "+ ex.getMessage());
        }finally{
            em.close();
        
        }
        return screenings;
    }
    
/*
    Para o ItemSale. Deve ser registrado qual a sessão mais próxima
    da venda realizada.
    De preferência, sessão futura. Todavai, se não houver: sessão passada mais próxima.
    */
public Screening findClosestScreening(LocalDateTime now){
    EntityManager em = JPAUtil.getEntityManager();
    //Futura
    try{
    TypedQuery<Screening> qFuture = em.createQuery(
            "SELECT s FROM Screening s " +
            "WHERE s.start >= :now " +
            "ORDER BY s.start ASC",
            Screening.class
        );
        qFuture.setParameter("now", now);
        qFuture.setMaxResults(1);

        List<Screening> future = qFuture.getResultList();
        if (!future.isEmpty()) {
            return future.get(0);
        }

        // 2️⃣ se não houver futura, pega a última passada
        TypedQuery<Screening> qPast = em.createQuery(
            "SELECT s FROM Screening s " +
            "WHERE s.start < :now " +
            "ORDER BY s.start DESC",
            Screening.class
        );
        qPast.setParameter("now", now);
        qPast.setMaxResults(1);

        List<Screening> past = qPast.getResultList();
        return past.isEmpty() ? null : past.get(0);

    }finally {
        //JPAUtil.closeEntityManager();
        em.close();
    }
}    
        
        
    
        
        
        
        
}
