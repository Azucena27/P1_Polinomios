/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Azucena Reyes Santiago
 */
public class Polinomio {
    Monomio inicio; 
    Monomio fin; 
    Monomio inicioPoli_1;
    static Monomio inicioPoli_2;
    static Monomio inicioPoli_3; //resultado de la multiplicación de polinomios.
    Monomio finPoli_1;
    static Monomio finPoli_2;
    static Monomio finPoli_3; //resultado de la multiplicación de polinomios
    
    
   public static void main(String[] args){
   Polinomio principal_1 = new Polinomio();
   principal_1.agregarMonomio(-5, "x^2");
   principal_1.agregarMonomio(-1, "x^2");
   principal_1.agregarMonomio(2, "x");
   principal_1.agregarMonomio(-5, "x");
   principal_1.agregarMonomio(-12, "x^2");
   
   principal_1.imprimir(0);
   principal_1.simplificacion();
   principal_1.limpiarVariables();
   
   Polinomio polinomio1 = new Polinomio();
   polinomio1.agregarMonomio(4,"x", 2, 1);
   polinomio1.agregarMonomio(-2,"x",2,1);
   polinomio1.agregarMonomio(6,"x",1,1);
   
   Polinomio polinomio2 = new Polinomio();
   polinomio2.agregarMonomio(3,"x",3,2);
   polinomio2.agregarMonomio(1,"x",1,2);
   polinomio2.agregarMonomio(-5,"x",2,2);
   System.out.println("inicioPoli_2: "+ inicioPoli_2.getCoeficiente() +"fin poli 2: "+finPoli_2.getCoeficiente()); 
   //polinomio1.imprimir(1);
  //polinomio2.imprimir(2);
   polinomio1.multiplicacion(polinomio1, polinomio2);
    } 
    
    public void agregarMonomio (int coeficiente, String variable) {
        Monomio nuevoMonomio = new Monomio(coeficiente,variable);
        nuevoMonomio.setSiguiente(null);
        
        
        if(inicio==null && fin==null ){
         inicio = nuevoMonomio;
         fin = nuevoMonomio;
        }
        fin.setSiguiente(nuevoMonomio);
        fin = fin.getSiguiente();
          
        
    }
    public void agregarMonomio(int coeficiente, String soloVariable, int exponente, int numeroPoli){
        
        if(numeroPoli==1){
          Monomio nuevoMonomio = new Monomio(coeficiente,soloVariable,exponente);
          nuevoMonomio.setSiguiente(null);
          
        if(inicioPoli_1==null && finPoli_1==null ){
          inicioPoli_1 = nuevoMonomio;
          finPoli_1 = nuevoMonomio;
        }
        finPoli_1.setSiguiente(nuevoMonomio);
        finPoli_1 = finPoli_1.getSiguiente();
      }  
        else if(numeroPoli==2){  
         Monomio nuevoMonomio2 = new Monomio(coeficiente,soloVariable,exponente);
         nuevoMonomio2.setSiguiente(null);
         System.out.println("entró en numPoli_2");
         
         if(inicioPoli_2 == null && finPoli_2 == null ){
         inicioPoli_2 = nuevoMonomio2;
         finPoli_2 = nuevoMonomio2;
        }
        finPoli_2.setSiguiente(nuevoMonomio2);
        finPoli_2 = finPoli_2.getSiguiente(); 
        System.out.println("inicioPoli_2: "+ inicioPoli_2.getCoeficiente() + inicioPoli_2.getSoloVariable()+ inicioPoli_2.getExponente());
        System.out.println("finPoli_2: "+ finPoli_2.getCoeficiente()+ finPoli_2.getSoloVariable()+ finPoli_2.getExponente());
      }
       else if(numeroPoli==3){
         Monomio nuevoMonomio3 = new Monomio(coeficiente,soloVariable,exponente);
         nuevoMonomio3.setSiguiente(null);
        // System.out.println("entró en numPoli_3");
       if(inicioPoli_3==null && finPoli_3==null ){
         inicioPoli_3 = nuevoMonomio3;
         finPoli_3 = nuevoMonomio3;
        }
        finPoli_3.setSiguiente(nuevoMonomio3);
        finPoli_3 = finPoli_3.getSiguiente();  
       // System.out.println("inicioPoli_3: "+ inicioPoli_3.getCoeficiente() + inicioPoli_3.getSoloVariable()+ inicioPoli_3.getExponente());
       // System.out.println("finPoli_3: "+ finPoli_3.getCoeficiente()+ finPoli_3.getSoloVariable()+ finPoli_3.getExponente());
      } 
    }
    
    public void simplificacion(){
       int contador= 0;
       Monomio a = this.inicio;
       Monomio b = new Monomio();
       Polinomio polinomioSimplificado = new Polinomio();
       int sumaCoeficiente = 0;
       String primeraVariable = null;
       a = inicio;
       b = a.getSiguiente();
       sumaCoeficiente = a.getCoeficiente();
       
       while(a.getSiguiente() != null){
          b = a.getSiguiente();
          sumaCoeficiente = a.getCoeficiente(); 
          
        while (b != null && a.getVariable() != null){
           if(a.getVariable().equals(b.getVariable()) && (primeraVariable == null || a.getVariable().equals(a.getVariable()))){
              sumaCoeficiente = sumaCoeficiente + b.getCoeficiente();
              primeraVariable = a.getVariable();
              b.setVariable(null); 
              b.setCoeficiente(0);
           }   
           b = b.getSiguiente();
           
          }
          
          if (a.getVariable() != null){
             polinomioSimplificado.agregarMonomio(sumaCoeficiente, primeraVariable); 
          }
          a = a.getSiguiente();
       }
       polinomioSimplificado.imprimir(0);
       
    }
    
    public void imprimir(int numeroPoli){
        if(numeroPoli == 0){
            Monomio actual = inicio;
            System.out.println("El polinomio simplificado es: ");
            while(actual != null){
                System.out.print(actual.getCoeficiente()+actual.getVariable()+" ");
                actual = actual.siguiente;
            } 
            System.out.println(" ");
        }  else if(numeroPoli ==1){
            Monomio actual = inicioPoli_1;
            System.out.println("El primer polinomio a multiplicar es: ");
            while(actual != null){
                System.out.print(actual.getCoeficiente()+actual.getSoloVariable()+"^"+actual.getExponente()+ " ");
                actual = actual.siguiente;
            } 
            System.out.println(" ");
        }else if(numeroPoli ==2){
            Monomio actual = inicioPoli_2;
            System.out.println("El segundo polinomio a multiplicar es: ");
            while(actual != null){
                System.out.print(actual.getCoeficiente()+actual.getSoloVariable()+"^"+actual.getExponente()+ " ");
                actual = actual.siguiente;
            }
        System.out.println(" ");
        
        } else if(numeroPoli ==3){
            Monomio actual = inicioPoli_3;
            
            System.out.println("El resultado de la multiplicacion es: ");
            while(actual != null){
                System.out.print(actual.getCoeficiente()+actual.getSoloVariable()+"^"+actual.getExponente()+ " ");
                actual = actual.siguiente;
            }
            System.out.println(" ");
        }
    }
    
    public Polinomio(){
        inicio = null;
        fin = null;
        inicioPoli_1 = null;
        inicioPoli_2 = null;
        finPoli_1 = null;
        finPoli_2 = null;
    }
    
     public void multiplicacion(Polinomio polinomio1, Polinomio polinomio2){
       Monomio primerPoli = inicioPoli_1;
       Monomio segundoPoli = inicioPoli_2;
       Polinomio primeraMultiplicacion = new Polinomio();
       inicioPoli_3 = null;
       finPoli_3 = null;
      
        Monomio segundoPoliFijo = new Monomio();
        while(primerPoli != null){
           
            if (segundoPoli != null)
            segundoPoliFijo.setCoeficiente(segundoPoli.getCoeficiente());
            segundoPoli = segundoPoliFijo;
            
            
            
            System.out.println("Coeficiente de polinomio : "+ segundoPoli.getCoeficiente());
            System.out.println("coeficiente de segundo poli fijo: " +segundoPoliFijo.getCoeficiente() );

           while(segundoPoli != null){
               System.out.println("coeficiente de polinomio 2: "+segundoPoli.getCoeficiente());
                primeraMultiplicacion.agregarMonomio(primerPoli.getCoeficiente() * segundoPoli.getCoeficiente(), primerPoli.getSoloVariable(), primerPoli.getExponente() + segundoPoli.getExponente(), 3 );
           
               segundoPoli = segundoPoli.getSiguiente(); 
           }
           primerPoli = primerPoli.getSiguiente();
        }
       primeraMultiplicacion.imprimir(3);  
     }
        
     public void limpiarVariables(){
         inicio=null;
         fin=null;
         inicioPoli_1 =null;
         //inicioPoli_2 = null;
         finPoli_1 = null;
         //finPoli_2 = null;
         inicioPoli_3 = null;
         finPoli_3 = null;
     }
}



