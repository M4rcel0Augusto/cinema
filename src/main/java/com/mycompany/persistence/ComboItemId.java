/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * Será necessário para poder usar as duas primary keys
 */
public class ComboItemId implements Serializable {
    
    private int comboId;
    private int productId;
    
    public ComboItemId() {} //Construtor vazio
    
    public ComboItemId(int comboId, int productId){
        this.comboId = comboId;
        this.productId = productId;
    
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o){return true;}
        if(!(o instanceof ComboItemId)){return false;} //O obj é da mesma classe? se não: false
        ComboItemId that =(ComboItemId) o;             // if o ==String => false.
        return comboId == that.comboId &&
               productId == that.productId;
        
    
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(comboId, productId);
    }
    
}
