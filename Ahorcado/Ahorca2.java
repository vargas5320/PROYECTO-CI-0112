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
        while(true){
            try{
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
                                if (letrat.equals("A") || letrat.equals("B") || letrat.equals("C") || letrat.equals("D") || letrat.equals("E") || letrat.equals("F") || letrat.equals("G") || letrat.equals("H") || letrat.equals("I") || letrat.equals("J") || letrat.equals("K") || letrat.equals("L") || letrat.equals("M") || letrat.equals("N") || letrat.equals("O") || letrat.equals("P") || letrat.equals("Q") || letrat.equals("R") || letrat.equals("S") || letrat.equals("T") || letrat.equals("U") || letrat.equals("V") || letrat.equals("W") || letrat.equals("X") || letrat.equals("Y") || letrat.equals("Z")){
                                    palabra1[i] = letrat;
                            break;
                                }
                                else{
                                    throw new IllegalArgumentException("letra invalida");
                                }
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
                                if (letrat.equals("A") || letrat.equals("B") || letrat.equals("C") || letrat.equals("D") || letrat.equals("E") || letrat.equals("F") || letrat.equals("G") || letrat.equals("H") || letrat.equals("I") || letrat.equals("J") || letrat.equals("K") || letrat.equals("L") || letrat.equals("M") || letrat.equals("N") || letrat.equals("O") || letrat.equals("P") || letrat.equals("Q") || letrat.equals("R") || letrat.equals("S") || letrat.equals("T") || letrat.equals("U") || letrat.equals("V") || letrat.equals("W") || letrat.equals("X") || letrat.equals("Y") || letrat.equals("Z")){
                                    palabra2[j] = letrat;
                            break;
                                }
                                else{
                                    throw new IllegalArgumentException("letra invalida");
                                }
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
            }
            catch (InputMismatchException e){
                System.out.println("eleccion" +" "+ "invalida");
                scanner.nextLine();
            }

            for (int j = 0; j < palabra2.length; j++) {
                System.out.println( palabra2[j].toString());                           
            }
        

       
            // AQUI SE EMPIEZA IR TODO A LA VERGA JAJAJA -SAMU

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
                try{
                    System.out.println("Jugador1"+"elija"+"una"+ "letra"+"para adivinar");
                    String letrak= scanner.nextLine();
                    if(letrak.equals("A") || letrak.equals("B") || letrak.equals("C") || letrak.equals("D") || letrak.equals("E") || letrak.equals("F") || letrak.equals("G") || letrak.equals("H") || letrak.equals("I") || letrak.equals("J") || letrak.equals("K") || letrak.equals("L") || letrak.equals("M") || letrak.equals("N") || letrak.equals("O") || letrak.equals("P") || letrak.equals("Q") || letrak.equals("R") || letrak.equals("S") || letrak.equals("T") || letrak.equals("U") || letrak.equals("V") || letrak.equals("W") || letrak.equals("X") || letrak.equals("Y") || letrak.equals("Z")){
                        for (int j = 0; j < palabra2.length; j++){
                            if(letrak.equals(palabra2[j])){
                                System.out.println("Ha" +" "+ "acertado");
                                palabra2Aux[j]= letrak;
                                for (int p = 0; p < palabra2Aux.length; p++) {
                                    System.out.println( palabra2Aux[p].toString());                           
                                }
                            }
                        }
                    }

                    else{
                        System.out.println("Ha" + " "+"Fallado");
                        intentos1 --;
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
}


//or (int i = 0; i < robots.length; i++) {
        //if (robots[i] != null) {
            //System.out.println("Robot en posición " + i + ": " + robots[i].toString());





