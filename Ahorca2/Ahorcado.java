
import java.util.Scanner;
import java.util.InputMismatchException;

public class Ahorcado{
    // atributos
    private static Jugador jugador1;
    private static Jugador jugador2;
    static Scanner scanner = new Scanner(System.in);

    //constructor
    public Ahorcado(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

    }

    //variables auxiliares
     static int cantidad = 0;
     static int cantidad2 = 0;
     static char [] palabra1;
     static char [] palabra2;
     static boolean[] palabra1Aux;
     static boolean[] palabra2Aux;

    // métodos

    public void iniciarJuego(Jugador jugador1, Jugador jugador2){
        System.out.println("El"+" "+"juego"+ " "+ "ha"+" "+ "comenzado");

        while(true){
            if(jugador1.getIntentos() > 0 && jugador2.getIntentos() > 0){
                try{
                    System.out.println(jugador1.getNombre()+ " "+"elija"+" "+"una"+" "+ "letra"+" "+"para"+" "+ "adivinar");
                     String letrap= scanner.nextLine();
                    scanner.nextLine();
                    if (letrap.matches("[A-Z]")){
                        for(int j = 0; j< palabra2.length;j++){
                            if(palabra2[j]== letrap.charAt(0)){
                                palabra2Aux[j] = true;
                                if(palabra2Aux[j]){
                                    System.out.print(palabra2[j]);
                                }
                                else{
                                    System.out.print("_");
                                }
                                
        break;                        
                            }

                            else{
                                palabra2Aux[j]= false;
                                System.out.println("Ha"+" "+"perdido"+" "+"un"+" "+"intento");
                                jugador2.setIntentos(jugador1.getIntentos() - 1);
                                System.out.println();
                                System.out.println("Le"+" "+"quedan"+" "+ jugador1.getIntentos() +" "+"intentos");
                            }
                                
                        
                        }
                        if(jugador1.getIntentos() ==0){
                            System.out.println( jugador1.getNombre() +" "+"ha"+" "+"perdido");
                            System.out.println();
                            System.out.println( jugador2.getNombre() +" "+"GANA");
                        }
                    }// if para controlar las letras recibidas
                    else{
                        throw new IllegalArgumentException("letra invalida");
                    }

                    

                    System.out.println(jugador2.getNombre()+" "+"elija"+" "+"una"+" "+ "letra"+" "+"para"+" "+ "adivinar");
                     String letrah= scanner.nextLine();
                    scanner.nextLine();
                    if (letrah.matches("[A-Z]")){
                        for(int i = 0; i < palabra1.length;i++){
                            if(palabra1[i]== letrah.charAt(0)){
                                palabra2Aux[i] = true;
                                if(palabra2Aux[i]){
                                    System.out.print(palabra1[i]);
                                }
                                else{
                                    System.out.print("_");
                                }
        break;                        
                            }

                            else{
                                palabra2Aux[i]= false;
                                System.out.println("Ha"+" "+"perdido"+" "+"un"+" "+"intento");
                                jugador1.setIntentos(jugador2.getIntentos() - 1);
                                System.out.println();
                                System.out.println("Le"+" "+"quedan"+" "+ jugador2.getIntentos() +" "+"intentos");
                            }
                                
                        
                        }
                        if(jugador2.getIntentos() ==0){
                            System.out.println( jugador2.getNombre() +" "+"ha"+" "+"perdido");
                            System.out.println();
                            System.out.println( jugador1.getNombre() +" "+"GANA");
                        }
                    }// if para controlar las letras recibidas
                    else{
                        throw new IllegalArgumentException("letra invalida");
                    }
                    

                }//try
                catch(IllegalArgumentException e){
                    System.out.println("letra"+" "+ "invalida,"+" "+"elija" +" "+ "otra");
                    scanner.nextLine();
                }
                
            } //if   
                              
        }//while
    }
     

    // main
    public static void main(String[] args){
        
        


        // intanciar jugador 1

        while(true){ 
             try{    
                System.out.println("Jugador 1" +" "+ "indique"+ " "+ "la"+" "+ "cantidad"+" "+ "de"+" "+ "letras" +" "+ "de" +" "+ "su" +" "+ "palabra");
                cantidad = scanner.nextInt();
                scanner.nextLine();
                
                if (cantidad >= 2){
                    System.out.println("correcto");
                    char [] palabra1 = new char[cantidad];

                    System.out.println("Jugador1" +" "+ "1"+ " "+ "indique"+" "+ "su" +" "+ "nombre");
                    String nombret = scanner.nextLine();

                    for(int i= 0; i < palabra1.length; i++){
                        while(true){
                            try{
                                System.out.println("indique" +" "+ "la"+" "+ "letra " +" "+ "en" +" "+ "la" +" "+ "posicion"+" "+ (i+1) +" " + "(unicamente"+ " "+ "MAYUSCULAS)"+ " "+":");
                                String letrat = scanner.nextLine();
                                if (letrat.matches("[A-Z]")){
                                    palabra1[i] = letrat.charAt(0);
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

                    Jugador jugador1 = new Jugador (nombret, 6, palabra1);
                    System.out.println();
                    for (int i = 0; i < palabra1.length; i++) {
                        
                        System.out.print( palabra1[i]);
                    }
            break;        
                }
                else{
                     System.out.println("eleccion" +" "+ "invalida");
                }

            }// try para cantidad de letras

            catch (InputMismatchException e){
                System.out.println("eleccion" +" "+ "invalida");
                scanner.nextLine();
            }
        }

            //instaciado de jugador 2
        System.out.println();
        while(true){    
            try{    
                System.out.println("Jugador 2" +" "+ "indique"+ " "+ "la"+" "+ "cantidad"+" "+ "de"+" "+ "letras" +" "+ "de" +" "+ "su" +" "+ "palabra");
                cantidad2 = scanner.nextInt();
                scanner.nextLine();
                
                if (cantidad2 >= 2){
                    System.out.println("correcto");
                    char [] palabra2 = new char[cantidad2];

                    System.out.println("Jugador" +" "+ "2"+ " "+ "indique"+" "+ "su" +" "+ "nombre");
                    String nombrek = scanner.nextLine();

                    for(int j= 0; j < palabra2.length; j++){
                        while(true){
                            try{
                                System.out.println("indique" +" "+ "la"+" "+ "letra " +" "+ "en" +" "+ "la" +" "+ "posicion"+" "+ (j+1) +" " + "(unicamente"+ " "+ "MAYUSCULAS)"+ " "+":");
                                String letrak = scanner.nextLine();
                                if (letrak.matches("[A-Z]")){
                                    palabra2[j] = letrak.charAt(0);
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

                    Jugador jugador2 = new Jugador (nombrek, 6, palabra2);
                    System.out.println();
                    for (int j = 0; j < palabra2.length; j++) {
                        
                        System.out.print( palabra2[j]);
                    }
            break;        
                }
                else{
                     System.out.println("eleccion" +" "+ "invalida");
                }

            }// try para cantidad de letras

            catch (InputMismatchException e){
                System.out.println("eleccion" +" "+ "invalida");
                scanner.nextLine();
            }


        } //2° while
                    //Arreglos auxiliares
        palabra1Aux = new boolean [cantidad];
            for(int h= 0; h < palabra1Aux.length; h++){
                palabra1Aux[h] = false; 
            }
        palabra2Aux = new boolean [cantidad2];
            for(int p= 0; p < palabra2Aux.length; p++){
                palabra2Aux[p] = false; 
            }

        Ahorcado juego = new Ahorcado (jugador1, jugador2);
        juego.iniciarJuego(jugador1, jugador2);

    } //main

} //clase