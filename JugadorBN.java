import java.util.Scanner;

/**
 * @file JugadorBN.java
 * @brief Clase que representa un jugador en el juego de Batalla Naval.
 */
public class JugadorBN {

    /**
     * Nombre del jugador.
     */
    private String nombre;

    /**
     * Cantidad de vidas del jugador (número de barcos).
     */
    private int vidas;

    /**
     * Tablero asociado al jugador.
     */
    private Tablero tablero;

    /**
     * Símbolo que representa un acierto (hit).
     */
    private char hit;

    /**
     * Símbolo que representa un fallo.
     */
    private char fallo;

    /**
     * Constructor de la clase JugadorBN.
     * @param nombre Nombre del jugador.
     * @param vidas Cantidad de vidas o barcos.
     * @param agua Símbolo que representa el agua en el tablero.
     * @param hit Símbolo que representa un acierto.
     * @param fallo Símbolo que representa un fallo.
     */
    public JugadorBN(String nombre, int vidas, char agua, char hit, char fallo) {
        this.nombre = nombre;
        this.vidas = vidas;
        this.tablero = new Tablero(agua);
        this.hit = hit;
        this.fallo = fallo;
    }

    /**
     * Obtiene el nombre del jugador.
     * @return Nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la cantidad de vidas restantes.
     * @return Número de vidas.
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * Obtiene el símbolo usado para representar un acierto.
     * @return Carácter que representa un hit.
     */
    public char getHit() {
        return hit;
    }

    /**
     * Obtiene el símbolo usado para representar un fallo.
     * @return Carácter que representa un fallo.
     */
    public char getFallo() {
        return fallo;
    }

    /**
     * Obtiene el tablero del jugador.
     * @return Objeto de tipo Tablero.
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Disminuye en uno la cantidad de vidas del jugador.
     */
    public void perderVida() {
        vidas--;
    }

    /**
     * Permite al jugador colocar sus barcos en el tablero.
     * Cada jugador coloca 3 barcos de una sola casilla.
     * @param scan Objeto Scanner para recibir la entrada del usuario.
     */
    public void colocarBarcos(Scanner scan) {
        int colocados = 0;
        // Uso de try-catch
        while (colocados < 3) {
            System.out.println("\n" + nombre + ", coloque su barco #" + (colocados + 1) + " (3 en total de una casilla c/u):");
            try {
                System.out.println("Fila (1-5): ");
                int fila = scan.nextInt() - 1;
                System.out.println("Columna (1-5): ");
                int columna = scan.nextInt() - 1;

                if (fila < 0 || fila > 5 || columna < 0 || columna > 5) {
                    System.out.println("Coordenadas fuera del rango de juego.");
                } else if (tablero.hayBarco(fila, columna)) {
                    System.out.println("Ya hay un barco ahí, elige otro sitio.");
                } else {
                    tablero.colocarBarcos(fila, columna);
                    colocados++;
                    System.out.println("Su tablero actualmente se ve así: ");
                    tablero.tableroPropio();
                }
            } catch (Exception e) {
                System.out.println("Coordenadas inválidas.");
                scan.nextLine();
            }
        }
    }
}
