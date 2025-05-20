import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @class Ahorcado
 * @brief Clase que gestiona el flujo del juego Ahorcado entre dos jugadores.
 */
public class Ahorcado {

    /** Jugador 1 del juego */
    private static Jugador jugador1;

    /** Jugador 2 del juego */
    private static Jugador jugador2;

    /** Objeto Scanner para leer entrada desde consola */
    static Scanner scanner = new Scanner(System.in);

    /**
     * @brief Constructor vacío de la clase Ahorcado.
     */
    public Ahorcado(){
    }

    /**
     * @brief Inicia la lógica del juego, alternando turnos entre los jugadores.
     * El juego continúa hasta que un jugador adivina la palabra o se queda sin intentos.
     */
    public void iniciarJuego(){
        System.out.println();
        System.out.println("El juego ha comenzado");
        boolean endGame = false;

        while(!endGame){

            // turno de jugador 1
            jugador1.adivinarLetra(jugador1, jugador2);
            if (jugador1.getIntentos() == 0){
                endGame = true;
                break;
            }

            if(jugador1.revisarPalabra(jugador1, jugador2)){
                endGame = true;
                break;
            }

            // turno de jugador 2
            jugador2.adivinarLetra(jugador2, jugador1);
            if (jugador2.getIntentos() == 0){ 
                endGame = true;
                break;
            }

            if(jugador2.revisarPalabra(jugador2, jugador1)){ 
                endGame = true;
                break;
            }
        }
    }

    /**
     * @brief Instancia los jugadores solicitando su nombre y palabra secreta.
     * Se realizan validaciones para asegurar que la palabra tenga al menos dos letras mayúsculas.
     */
    public void instanciarJugadores(){

        // intanciar jugador 1
        while(true){ 
            try{    
                System.out.println("Jugador 1 indique la cantidad de letras de su palabra (al menos 2)");
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                
                if (cantidad >= 2){
                    char [] palabra = new char[cantidad]; 

                    System.out.println("Jugador 1 indique su nombre");
                    String nombre = scanner.nextLine();

                    for(int i= 0; i < palabra.length; i++){
                        while(true){
                            try{
                                System.out.println("Indique la letra en la posicion" +" "+ (i+1) +" " + "(unicamente MAYUSCULAS y el juego solo leera la primera letra escrita):");
                                char letra = scanner.nextLine().charAt(0);
                                if (letra== 'A' || letra == 'B' || letra == 'C' || letra == 'D' || letra == 'E' || letra == 'F' || letra == 'G' || letra == 'H' || letra == 'I' || letra == 'J' || letra == 'K' || letra == 'L' || letra == 'M' || letra == 'N' || letra == 'O' || letra == 'P' || letra == 'Q' || letra == 'R' || letra == 'S' || letra == 'T' || letra == 'U' || letra == 'V' || letra == 'W' || letra == 'X' || letra == 'Y' || letra == 'Z'){
                                    palabra[i] = letra;
                                    break;
                                }
                                else{
                                    throw new IllegalArgumentException("letra invalida");
                                }
                            }
                            catch(IllegalArgumentException e){
                                System.out.println("Eleccion INVALIDA, elija otra letra");
                            }
                        }
                    }

                    boolean [] palabraAux= new boolean [cantidad];
                    for(int h= 0; h < palabraAux.length; h++){
                        palabraAux[h] = false; 
                    }

                    jugador1 = new Jugador (nombre, 6, palabra, palabraAux);
                    System.out.println();
                    break;        
                }
                else{
                    System.out.println("eleccion invalida");
                }

            } catch (InputMismatchException e){
                System.out.println("eleccion invalida");
                scanner.nextLine();
            }
        }

        // instanciar jugador 2
        System.out.println();
        while(true){    
            try{    
                System.out.println("Jugador 2 indique la cantidad de letras de su palabra (al menos 2)");
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                
                if (cantidad >= 2){
                    char [] palabra = new char[cantidad];

                    System.out.println("Jugador 2, indique su nombre");
                    String nombre = scanner.nextLine();

                    for(int j= 0; j < palabra.length; j++){
                        while(true){
                            try{
                                System.out.println("Indique la letra en la posicion" +" "+ (j+1) +" " + "(unicamente MAYUSCULAS y el juego solo leera la primera letra escrita):");
                                char letra = scanner.nextLine().charAt(0);
                                if (letra== 'A' || letra == 'B' || letra == 'C' || letra == 'D' || letra == 'E' || letra == 'F' || letra == 'G' || letra == 'H' || letra == 'I' || letra == 'J' || letra == 'K' || letra == 'L' || letra == 'M' || letra == 'N' || letra == 'O' || letra == 'P' || letra == 'Q' || letra == 'R' || letra == 'S' || letra == 'T' || letra == 'U' || letra == 'V' || letra == 'W' || letra == 'X' || letra == 'Y' || letra == 'Z'){
                                    palabra[j] = letra;
                                    break;
                                }
                                else{
                                    throw new IllegalArgumentException("letra invalida");
                                }
                            }
                            catch(IllegalArgumentException e){
                                System.out.println("Eleccion INVALIDA, elija otra letra");
                            }
                        }
                    }

                    boolean [] palabraAux = new boolean [cantidad];
                    for(int p= 0; p < palabraAux.length; p++){
                        palabraAux[p] = false; 
                    }

                    jugador2 = new Jugador (nombre, 6, palabra, palabraAux);
                    System.out.println();
                    break;        
                }
                else{
                    System.out.println("eleccion invalida");
                }

            } catch (InputMismatchException e){
                System.out.println("eleccion invalida");
                scanner.nextLine();
            }
        } //2° while
    } //método
} //clase
