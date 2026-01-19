/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import com.mycompany.model.dto.MonthlyReport;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Erro: O valor dos items reembolsados não está sendo descontado do total.
 */
public class ReportDAO {
    
    public Double getMonthlyRevenue(int year, int month) {
    EntityManager em = JPAUtil.getEntityManager();
    
    try {
        LocalDateTime start = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime end = start.plusMonths(1);

        return em.createQuery( //Usar """""" para evitar bug
            """
            SELECT COALESCE(SUM(i.unitPrice * i.quantity), 0)
            FROM ItemSale i
            WHERE YEAR(i.sale.saleDatetime) = :year
              AND MONTH(i.sale.saleDatetime) = :month
            """,
            Double.class
        )
        .setParameter("year", year)
        .setParameter("month", month)
        .getSingleResult();

    } finally {
        em.close();
    }
}

    
    public Double getMonthlyCost(int year, int month) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        
        LocalDateTime start = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime end = start.plusMonths(1);

        return em.createQuery(
            """
            SELECT COALESCE(SUM(i.unitCost * i.quantity), 0)
            FROM ItemSale i
            WHERE YEAR(i.sale.saleDatetime) = :year
              AND MONTH(i.sale.saleDatetime) = :month
            """,
            Double.class
        )
        .setParameter("year", year)
        .setParameter("month", month)
        .getSingleResult();

    } finally {
        em.close();
    }
}

    
    
    public List<MonthlyReport> getYearReport(int year) {
    List<MonthlyReport> listMonths = new ArrayList<>();

    for (int month = 1; month <= 12; month++) {
        Double revenue = getMonthlyRevenue(year, month);
        Double cost = getMonthlyCost(year, month);

        listMonths.add(new MonthlyReport(month, revenue, cost));
    }

    return listMonths;
}

    
}
