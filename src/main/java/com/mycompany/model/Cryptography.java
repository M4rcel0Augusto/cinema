/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 *
 * @author conve
 */
public class Cryptography {
    
                                //SHA256
    public static String hash(String text){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash =md.digest(text.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder hexString = new StringBuilder();
            
            for(byte b : hash){
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() ==1){
                    hexString.append('0');
                
                }
                hexString.append(hex);
            
            }
            return String.valueOf(hexString);
        
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    
    }
    
    
}
