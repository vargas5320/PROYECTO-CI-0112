import java.util.Scanner;

public class BatallaNaval {
    private char agua = '~';
    private char hit = 'X';
    private char fallo = 'O';
    private int vidas = 3;
    private JugadorBN jugador1;
    private JugadorBN jugador2;
    private Scanner scan = new Scanner(System.in);

    public void iniciaJuego() {
        System.out.println("Nombre del jugador 1: ");
        String nombre1 = scan.nextLine();
        jugador1 = new JugadorBN(nombre1, vidas, agua, hit, fallo);

        System.out.println("Nombre del jugador 2: ");
        String nombre2 = scan.nextLine();
        jugador2 = new JugadorBN(nombre2, vidas, agua, hit, fallo);

        jugador1.colocarBarcos(scan);
        jugador2.colocarBarcos(scan);

        jugar();
    }

    public void jugar() {
        boolean turnoJugador1 = true;

        while (jugador1.getVidas() > 0 && jugador2.getVidas() > 0) {
            JugadorBN actual = turnoJugador1 ? jugador1 : jugador2;
            JugadorBN oponente = turnoJugador1 ? jugador2 : jugador1;

            System.out.println("\n=== Turno del " + actual.getNombre() + " ===");
            System.out.println("Tu tablero: ");
            actual.getTablero().tableroPropio();
            System.out.println("\nTablero del oponente: ");
            oponente.getTablero().tableroOponente(hit, fallo);

            try {
                System.out.print("Fila a disparar (1-5): ");
                int fila = scan.nextInt() - 1;
                System.out.print("Columna a disparar (1-5): ");
                int columna = scan.nextInt() - 1;

                if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {
                    System.out.println("Coordenadas fuera de rango.");
                    continue;
                }
                Tablero tableroOponente = oponente.getTablero();
                char casillaActual = tableroOponente.getTablero(fila, columna);
                if (casillaActual == hit || casillaActual == fallo) {
                    System.out.println("Ya disparaste ahí, elige otro sitio.");
                }
                if (tableroOponente.hayBarco(fila, columna)) {
                    tableroOponente.huboHit(fila, columna, hit);
                    System.out.println("=== Hit ===");
                    oponente.perderVida();
                    if (oponente.getVidas() == 0) break;
                    System.out.println("Vuelve a disparar.");
                } else {
                    tableroOponente.hubofallo(fila, columna, fallo);
                    System.out.println("=== Fallaste ===");
                    turnoJugador1 = !turnoJugador1;
                }

            } catch (Exception e) {
                System.out.println("Coordenadas inválidas.");
                scan.nextLine();
            }
        }
        System.out.println("\n=== Juego terminado. ===");
        System.out.println("Ganador: " + (jugador1.getVidas() > 0 ? jugador1.getNombre() : jugador2.getNombre()) + "\n");
    }
}


