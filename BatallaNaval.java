import java.util.Scanner;

public class BatallaNaval {
    // Atributos privados
    private char agua;
    private char hit;
    private char fallo;
    private int vidasJugador1;
    private int vidasJugador2;
    private char[][] tableroJugador1 = new char[5][5];
    private char[][] tablerojugador2 = new char[5][5];
    private boolean[][] barcosJugador1 = new boolean[5][5];
    private boolean[][] barcosjugador2 = new boolean[5][5];

    Scanner scan = new Scanner(System.in);

    // Constructor
    public BatallaNaval(char agua, char hit, char fallo, int vidas) {
        this.agua = agua;
        this.hit = hit;
        this.fallo = fallo;
        this.vidasJugador1= vidas;
        this.vidasJugador2 = vidas;

        iniciarTableros();
    }

    // Getters
    public char getAgua() {
        return agua;
    }
    public char getHit() {
        return hit;
    }
    public char getFallo() {
        return fallo;
    }
    public int getVidasJugador1() {
        return vidasJugador1;
    }
    public int getVidasJugador2() {
        return vidasJugador2;
    }

    // Setters
    public void setAgua(char agua) {
        this.agua = agua;
    }
    public void setHit(char hit) {
        this.hit = hit;
    }
    public void setFallo(char fallo) {
        this.fallo = fallo;
    }
    public void setVidasJugador1(int vidas) {
        this.vidasJugador1 = vidas;
    }
    public void setVidasJugador2(int vidas) {
        this.vidasJugador2 = vidas;
    }

    // Iniciar los tableros del juego
    public void iniciarTableros() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tableroJugador1[i][j] = agua;
                tablerojugador2[i][j] = agua;
                barcosJugador1[i][j] = false;
                barcosjugador2[i][j] = false;
            }
        }
    }

    // Colocar los barcos de los jugadores
    public void colocarBarcos(boolean[][] barcos) {
        int colocados = 0;
        System.out.println("Coloque sus tres barcos (una casilla cada uno)");

        // Uso de try-catch
        while (colocados < 3) {
            System.out.println("Coloque su barco # " + (colocados + 1) );
            try {
                System.out.println("Fila (1-5): ");
                int fila = scan.nextInt() - 1;
                System.out.println("Columna (1-5): ");
                int columna = scan.nextInt() - 1;

                if (fila < 0 || fila > 5 || columna < 0 || columna > 5) {
                    System.out.println("Coordenadas fuera del rango de juego.");
                }
                else if (barcos[fila][columna]) {
                    System.out.println("Ya hay un barco ahí, elija otro sitio.");
                } else {
                    barcos[fila][columna] = true;
                    colocados++;
                }
            }
            catch (Exception e) {
                System.out.println("Coordenadas inválidas.");
                scan.nextLine();
            }
        }
    }

    // Imprimir tablero del jugador
    public void imprimirTablero(char[][] tablero) {
        String encabezadoSuperior = "    1 2 3 4 5";
        System.out.println(encabezadoSuperior);

        for (int i = 0; i < 5; i++) {
            String fila = (i + 1) + " |";
            for (int j = 0; j < 5; j++) fila += " " + tablero[i][j];
            System.out.println(fila);
        }
    }

    // Imprimir tablero del oponente (Oculto para jugador actual)
    public void imprimirTableroOponente(char[][] tablero) {
        String encabezado = "    1 2 3 4 5";
        System.out.println(encabezado);

        for (int i = 0; i < 5; i++) {
            String fila = (i + 1) + " |";
            for (int j = 0; j < 5; j++) {
                char c = tablero[i][j];
                if (c == hit || c == fallo) {
                    fila += " " + c;
                } else {
                    fila += " " + agua;
                }
            }
            System.out.println(fila);
        }
    }

    // Método principal del juego
    public void jugar() {
        boolean turnoJugador1 = true;

        while (vidasJugador1 > 0 && vidasJugador2 > 0) {
            System.out.println("Turno del " + (turnoJugador1 ? "Jugador 1" : "Jugador 2"));
            System.out.println("Tu tablero: ");
            imprimirTablero(turnoJugador1 ? tableroJugador1 : tablerojugador2);
            System.out.println("Tablero del enemigo: ");
            imprimirTableroOponente(turnoJugador1 ? tablerojugador2 : tableroJugador1);

            try {
                System.out.print("Fila a disparar (1-5): ");
                int fila = scan.nextInt() - 1;
                System.out.print("Columna a disparar (1-5): ");
                int columna = scan.nextInt() - 1;

                if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {
                }

                boolean[][] barcos = turnoJugador1 ? barcosjugador2 : barcosJugador1;
                char[][] tablero = turnoJugador1 ? tablerojugador2 : tableroJugador1;

                if (tablero[fila][columna] == hit || tablero[fila][columna] == fallo) {
                    System.out.println("Ya disparaste ahí.");
                    continue;
                }

                if (barcos[fila][columna]) {
                    tablero[fila][columna] = hit;
                    System.out.println("Hit");
                    if (turnoJugador1) vidasJugador2--; else vidasJugador1--;

                    if (vidasJugador1 == 0 || vidasJugador2 == 0) {
                        break;
                    }
                    System.out.println("Vuelve a disparar");
                } else {
                    tablero[fila][columna] = fallo;
                    System.out.println("Fallaste");
                    turnoJugador1 = !turnoJugador1;
                }

            } catch (Exception e) {
                System.out.println("Coordenadas inválidas.");
                scan.nextLine();
            }
        }
        System.out.println("Juego terminado.");
        System.out.println("Ganador: " + (vidasJugador1 > 0 ? "Jugador 1" : "Jugador 2"));
    }

    // Método principal del programa
    public static void main(String[] args) {
        BatallaNaval juego = new BatallaNaval('~', 'X', 'O', 3);
        juego.iniciarTableros();
        System.out.println("Jugador 1, coloque sus barcos: ");
        juego.colocarBarcos(juego.barcosJugador1);
        System.out.println("Jugador 2, coloque sus barcos: ");
        juego.colocarBarcos(juego.barcosjugador2);
        juego.jugar();
    }
}