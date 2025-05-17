import java.util.Scanner;

public class JugadorBN {
    //Atributos
    private String nombre;
    private int vidas;
    private Tablero tablero;
    private char hit;
    private char fallo;

    // Constructor
    public JugadorBN(String nombre, int vidas, char agua, char hit, char fallo) {
        this.nombre = nombre;
        this.vidas = vidas;
        this.tablero = new Tablero(agua);
        this.hit = hit;
        this.fallo = fallo;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public int getVidas() {
        return vidas;
    }
    public char getHit() {
        return hit;
    }
    public char getFallo() {
        return fallo;
    }
    public Tablero getTablero() {
        return tablero;
    }

    // Método perder vidas
    public void perderVida() {
        vidas--;
    }

    public void colocarBarcos(Scanner scan) {
        int colocados = 0;
        // Uso de try-catch
        while (colocados < 3) {
            System.out.println("\n" +nombre +", coloque su barco #" + (colocados + 1) + " (3 en total de una casilla c/u):");
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