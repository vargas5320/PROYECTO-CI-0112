import java.util.Scanner;
import java.util.InputMismatchException;
 






public class Ahorca2{

    // Atributos

    public static String[] palabra1;

    public static String[] palabra2;

    //constructor

    
    

    //variables necesarias

    static int intentos1 = 6;
    static int intentos2 = 6;
    static Scanner scanner = new Scanner(System.in);

    //metodos


    //main

    public static void main(String[] args){

        //instanciar los arreglos con las palabras

        String[] palabra1 = null;

        String[] palabra1Aux = null;

        String[] palabra2 = null;

        String[] palabra2Aux = null;

        //variables auxiliares

        int cantidad = 0;
        int cantidad2 = 0;
        String letra1 = null;
        String letra2 = null;

        // ciclo para ingresar las palabras en los arreglos
        // palabra de jugador 1
        try{
            //while(true){
                System.out.println("Jugador 1" +" "+ "indique"+ " "+ "la"+" "+ "cantidad"+" "+ "de"+" "+ "letras" +" "+ "de" +" "+ "su" +" "+ "palabra");
                cantidad = scanner.nextInt();
                scanner.nextLine();

                
                
                    if (cantidad > 0){

                        //instanciado del arreglo
                        palabra1 = new String[cantidad];

                        for(int i= 0; i < palabra1.length; i++){
                            while(true){
                                try{
                                    System.out.println("indique" +" "+ "la"+" "+ "letra " +" "+ "en" +" "+ "la" + "posicion"+" "+ (i+1) +" " + "(unicamente"+ " "+ "MAYUSCULAS)"+ " "+":");
                                    String letrat = scanner.nextLine();
                                    if (letrat.equals("A") || letrat.equals("B") || letrat.equals("C")){
                                        palabra1[i] = letrat;
                                break;
                                    }
                                    throw new IllegalArgumentException("letra invalida");
                                        
                                    

                                    
                                }
                                catch(IllegalArgumentException e){
                                    System.out.println("elija" +" "+ "otra"+" "+"letra");
                                    scanner.nextLine();
                                }
                            }
                        }
                    }

                    else{
                        System.out.println("eleccion" +" "+ "invalida");
                    }       
                            
            //}
        }

        catch (InputMismatchException e){
            System.out.println("eleccion" +" "+ "invalida");
            scanner.nextLine();
        }

        for (int i = 0; i < palabra1.length; i++) {
            System.out.println( palabra1[i].toString());                           
        }


        // palabra de jugador 2

        try{
            //while(true){
                System.out.println("Jugador 2" +" "+ "indique"+ " "+ "la"+" "+ "cantidad"+" "+ "de"+" "+ "letras" +" "+ "de" +" "+ "su" +" "+ "palabra");
                cantidad2 = scanner.nextInt();
                scanner.nextLine();

                
                
                    if (cantidad2 > 0){

                        //instanciado del arreglo
                        palabra2 = new String[cantidad2];

                        for(int j= 0; j < palabra2.length; j++){
                            while(true){
                                try{
                                    System.out.println("indique" +" "+ "la"+" "+ "letra " +" "+ "en" +" "+ "la" + "posicion"+" "+ (j+1) +" " + "(unicamente"+ " "+ "MAYUSCULAS)"+ " "+":");
                                    String letrat = scanner.nextLine();
                                    if (letrat.equals("A") || letrat.equals("B") || letrat.equals("C")){
                                        palabra2[j] = letrat;
                                break;
                                    }
                                    throw new IllegalArgumentException("letra invalida");
                                        
                                    

                                    
                                }
                                catch(IllegalArgumentException e){
                                    System.out.println("elija" +" "+ "otra"+" "+"letra");
                                    scanner.nextLine();
                                }
                            }
                        }
                    }

                    else{
                        System.out.println("eleccion" +" "+ "invalida");
                    }       
                            
            //}
        }

        catch (InputMismatchException e){
            System.out.println("eleccion" +" "+ "invalida");
            scanner.nextLine();
        }

        for (int j = 0; j < palabra2.length; j++) {
            System.out.println( palabra2[j].toString());                           
        }

       
        // AQUÍ SE EMPIEZA IR TODO A LA VERGA JAJAJA -SAMU
        // arreglos auxiliares

        palabra1Aux = new String[cantidad];
        for(int k= 0; k < palabra1Aux.length; k++){
            palabra1Aux[k] = "_"; 
        }
        
        palabra2Aux = new String[cantidad2];
        for(int p= 0; p < palabra2Aux.length; p++){
            palabra1Aux[p] = "_"; 
        }
        
        //turnos

        while(intentos1 > 0 || intentos2 > 0){
            System.out.println("Jugador1"+"elija"+"una"+ "letra"+"para adivinar");
            letra1 = scanner.nextLine();
            scanner.nextLine();
            for (int j = 0; j < palabra2.length; j++){
                if(letra1.equals(palabra2[j])){
                    System.out.println("Ha" +" "+ "acertado");
                    palabra2Aux[j]= palabra2[j];
                    
                }
                else{
                    System.out.println("Ha"+" "+"fallado");
                    intentos1 --;
                }
                for (int p = 0; p < palabra2Aux.length; p++) {
                    System.out.println( palabra2Aux[p].toString());                           
                }
            }
            System.out.println("Jugador2"+"elija"+"una"+ "letra"+"para adivinar");
            letra2 = scanner.nextLine();
            scanner.nextLine();
            for (int i = 0; i < palabra1.length; i++){
                if(letra2.equals(palabra1[i])){
                    System.out.println("Ha" +" "+ "acertado");
                    palabra1Aux[i]= palabra1[i];
                    for (int k = 0; k < palabra1Aux.length; k++) {
                        System.out.println( palabra1Aux[k].toString());                           
                    }
                }
                else{
                    System.out.println("Ha"+" "+"fallado");
                    intentos2 --;
                }

            }

        }
        
    }
}


//or (int i = 0; i < robots.length; i++) {
        //if (robots[i] != null) {
            //System.out.println("Robot en posición " + i + ": " + robots[i].toString());





