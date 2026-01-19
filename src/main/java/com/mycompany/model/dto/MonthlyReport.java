/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.dto;

/**
 *
 * @author conve
 */
public class MonthlyReport{
    private int month;
    private double revenue;
    private double cost;
    
    
    public MonthlyReport(int month, double revenue, double cost){
        this.month= month;
        this.revenue= revenue;
        this.cost= cost;
    
    }

    
    public double getProfit(){
        return revenue - cost;
    
    }
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
    
}
