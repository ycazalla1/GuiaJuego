/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echoofshadows.exceptions;

/**
 *
 * @author ycaza
 */
public class ExceptionMenu extends Exception {

    private String error;
    
    public ExceptionMenu(String err) {
        
        this.error = err;
        
    }
    
    public String toString(){
        return "ExceptionMenu: " + this.error;
    }
    
}
