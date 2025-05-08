import java.util.Scanner;
import java.util.InputMismatchException;
 





// main
public class Ahorcado{

    // Atributos

    public static String[] palabra1;

    public static String[] palabra2;

    //constructor

    
    

    //variables necesarias

    static int intentos = 6;
    static Scanner scanner = new Scanner(System.in);

    //metodos


    //main

    public static void main(String[] args){

        //instanciar los arreglos con las palabras

        String[] palabra1 = null;

        String[] palabra2 = null;

        //variables auxiliares

        int cantidad = 0;

        // ciclo para ingresar las palabras en los arreglos
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
                                    System.out.println("indique" +" "+ "la"+" "+ "letra " +" "+ "en" +" "+ "la" + "posicion"+" "+ (i+1) + ":");
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
        
    }
}


//or (int i = 0; i < robots.length; i++) {
        //if (robots[i] != null) {
            //System.out.println("Robot en posición " + i + ": " + robots[i].toString());





