import java.util.Scanner;
import java.util.InputMismatchException;

public class Ahorcado {
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
    static char[] palabra1;
    static char[] palabra2;
    static boolean[] palabra1Aux;
    static boolean[] palabra2Aux;

    // métodos
    public void iniciarJuego(Jugador jugador1, Jugador jugador2){
        System.out.println();
        System.out.println("El juego ha comenzado");

        while(true){
            if(jugador1.getIntentos() > 0 && jugador2.getIntentos() > 0){
                try{
                    System.out.println();
                    System.out.println();
                    System.out.println(jugador1.getNombre()+ " elija una letra para adivinar");
                    String letrap= scanner.nextLine();

                    if (letrap.matches("[A-Z]")){
                        boolean acierto = false;
                        for(int j = 0; j< palabra2.length;j++){
                            if(palabra2[j]== letrap.charAt(0)){
                                palabra2Aux[j] = true;
                                acierto = true;
                            }
                        }
                        if (acierto){
                            System.out.println ("HA ACERTADO!");
                        } else {
                            System.out.println();
                            System.out.println("Ha perdido un intento");
                            jugador1.setIntentos(jugador1.getIntentos() - 1);
                            if(jugador1.getIntentos() ==0){
                                System.out.println();
                                System.out.println( jugador1.getNombre() + " ha perdido");
                                System.out.println();
                                System.out.println( jugador2.getNombre() + " GANA");
                                break;
                            } else {
                                System.out.println();
                                System.out.println("Le quedan "+   jugador1.getIntentos() + " intentos");
                            }
                        }

                        for(int j = 0; j< palabra2.length ; j++){
                            if(palabra2Aux[j]){
                                System.out.print(palabra2[j]);
                            } else {
                                System.out.print("_");
                            }
                        }
                        boolean palabraAcertada = true;
                        for(int j = 0; j< palabra2.length ; j++){
                            if(!palabra2Aux[j]){
                                palabraAcertada = false;
                                break;
                            }
                        }
                        if(palabraAcertada){
                            System.out.println();
                            System.out.println(jugador1.getNombre()+ " HA GANADO");
                            break;
                        }
                    } else {
                        throw new IllegalArgumentException("Letra invalida");
                    }

                    System.out.println();
                    System.out.println();
                    System.out.println(jugador2.getNombre() + " elija una letra para adivinar");
                    String letrah= scanner.nextLine();

                    if (letrap.matches("[A-Z]")){
                        boolean acierto = false;
                        for(int i = 0; i< palabra1.length;i++){
                            if(palabra1[i]== letrah.charAt(0)){
                                palabra1Aux[i] = true;
                                acierto = true;                                                      
                            }
                        }
                        if (acierto){
                            System.out.println("HA ACERTADO!");
                        } else {
                            System.out.println();       
                            System.out.println("Ha perdido un intento");
                            jugador2.setIntentos(jugador2.getIntentos() - 1);
                            if(jugador2.getIntentos() ==0){
                                System.out.println();
                                System.out.println( jugador2.getNombre() + " ha perdido");
                                System.out.println();
                                System.out.println( jugador1.getNombre() + " GANA");
                                break;
                            } else {
                                System.out.println();
                                System.out.println("Le quedan "+ jugador2.getIntentos() + " intentos");
                            }
                        }

                        for(int i = 0; i< palabra1.length ; i++){
                            if(palabra1Aux[i]){
                                System.out.print(palabra1[i]);
                            } else {
                                System.out.print("_");
                            }
                        }
                        boolean palabraAcertada = true;
                        for(int i = 0; i< palabra1.length ; i++){
                            if(!palabra1Aux[i]){
                                palabraAcertada = false;
                                break;
                            }
                        }
                        if(palabraAcertada){
                            System.out.println();
                            System.out.println(jugador2.getNombre() + " HA GANADO");
                            break;
                        }
                    } else {
                        throw new IllegalArgumentException("Letra invalida");
                    }

                } catch(IllegalArgumentException e){
                    System.out.println("Letra invalida, elija otra");
                    scanner.nextLine();
                }
            }                        
        }
    }
}
