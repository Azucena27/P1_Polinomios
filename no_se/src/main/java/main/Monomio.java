/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Martha Jazmín
 */
public class Monomio {
     int coeficiente;
     String variable;
     Monomio siguiente;
     String soloVariable;
     int exponente;
     
     public Monomio (){
         this.coeficiente = 0;
         this.variable = null;
         this.siguiente = null;
         this.soloVariable = null;
         this.exponente = 0;       
     }
     
     public Monomio(int coeficiente, String variable){
         this.coeficiente = coeficiente;
         this.variable = variable;
     }
     public Monomio(int coeficiente, String soloVariable, int exponente){
        this.coeficiente = coeficiente;
        this.soloVariable = soloVariable;
        this.exponente = exponente;
                
     }
     public String getSoloVariable(){
         return this.soloVariable;
     }
     public void setSoloVariable(String soloVariable){
         this.soloVariable = soloVariable;
     }
     public int getExponente(){
         return this.exponente;
     }
     public void setExponente(int exponente){
         this.exponente = exponente;
     }
     
     public int getCoeficiente(){
         return this.coeficiente;
     }
    
     public void setCoeficiente(int coeficiente){
         this.coeficiente = coeficiente;
     }
     
     public String getVariable(){
         return this.variable;
     }
     
     public void setVariable(String variable){
         this.variable = variable;
     }
     
     public Monomio getSiguiente(){
         return this.siguiente;
     }
     
     public void setSiguiente(Monomio siguiente){
         this.siguiente = siguiente;
     }
}
