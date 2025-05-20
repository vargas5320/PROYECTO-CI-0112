import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @file Juegos.java
 * @brief Clase principal que contiene el menú para seleccionar y ejecutar los juegos Batalla Naval o Ahorcado.
 */
public class Juegos {

    /**
     * Método principal que ejecuta el menú de juegos.
     * Permite al usuario elegir entre jugar Batalla Naval, Ahorcado o salir del programa.
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Menu de Juegos ===");
            System.out.println("1. Jugar Batalla Naval");
            System.out.println("2. Jugar Ahorcado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    BatallaNaval juego = new BatallaNaval();
                    juego.iniciaJuego();
                    break;

                case 2:
                    /** 
                     * Sección de configuración inicial para el juego Ahorcado.
                     * Recolección de palabra secreta y nombre para el Jugador 1.
                     */
                    Jugador jugador1 = null;
                    Jugador jugador2 = null;
                    Ahorcado juego2 = new Ahorcado ();
    
                    juego2.instanciarJugadores();
                    juego2.iniciarJuego();
                    break;
                    
                    
                    

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}