/**
 * @file Tablero.java
 * @brief Clase que representa el tablero del juego Batalla Naval.
 */
public class Tablero {

    /**
     * Símbolo que representa el agua en el tablero.
     */
    private char agua;

    /**
     * Matriz que representa visualmente el tablero con símbolos.
     */
    private char[][] tablero;

    /**
     * Matriz que indica la ubicación de los barcos (true si hay barco).
     */
    private boolean[][] barcos;

    /**
     * Obtiene el símbolo que representa el agua.
     * @return Carácter para agua.
     */
    public char getAgua() {
        return agua;
    }

    /**
     * Obtiene la matriz del tablero visual.
     * @return Matriz de caracteres del tablero.
     */
    public char[][] getTablero() {
        return tablero;
    }

    /**
     * Obtiene la matriz de barcos.
     * @return Matriz booleana que indica la posición de los barcos.
     */
    public boolean[][] getBarcos() {
        return barcos;
    }

    /**
     * Constructor del tablero. Inicializa la matriz del tablero y la de barcos.
     * @param agua Carácter que representa el agua en el tablero.
     */
    public Tablero(char agua) {
        this.agua = agua;
        tablero = new char[5][5];
        barcos = new boolean[5][5];
        iniciarTablero();
    }

    /**
     * Inicializa el tablero con agua y sin barcos.
     */
    public void iniciarTablero() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = agua;
                barcos[i][j] = false;
            }
        }
    }

    /**
     * Coloca un barco en una posición específica.
     * @param fila Fila donde se colocará el barco.
     * @param col Columna donde se colocará el barco.
     */
    public void colocarBarcos(int fila, int col) {
        barcos[fila][col] = true;
        tablero[fila][col] = 'B';
    }

    /**
     * Verifica si hay un barco en la posición indicada.
     * @param fila Fila a verificar.
     * @param col Columna a verificar.
     * @return true si hay un barco, false si no.
     */
    public boolean hayBarco(int fila, int col) {
        return barcos[fila][col];
    }

    /**
     * Marca una posición como acierto (hit).
     * @param fila Fila del disparo.
     * @param col Columna del disparo.
     * @param hit Símbolo que representa el hit.
     */
    public void huboHit(int fila, int col, char hit) {
        tablero[fila][col] = hit;
    }

    /**
     * Marca una posición como fallo (miss).
     * @param fila Fila del disparo.
     * @param col Columna del disparo.
     * @param fallo Símbolo que representa el fallo.
     */
    public void hubofallo(int fila, int col, char fallo) {
        tablero[fila][col] = fallo;
    }

    /**
     * Obtiene el símbolo de una posición del tablero.
     * @param fila Fila deseada.
     * @param col Columna deseada.
     * @return Carácter en la posición indicada del tablero.
     */
    public char getTablero(int fila, int col) {
        return tablero[fila][col];
    }

    /**
     * Imprime el tablero del jugador, mostrando todas las posiciones, incluidos los barcos.
     */
    public void tableroPropio() {
        String encabezadoSuperior = "    1 2 3 4 5";
        System.out.println(encabezadoSuperior);

        for (int i = 0; i < 5; i++) {
            String fila = (i + 1) + " |";
            for (int j = 0; j < 5; j++) fila += " " + tablero[i][j];
            System.out.println(fila);
        }
    }

    /**
     * Imprime el tablero del oponente, ocultando los barcos no revelados.
     * Solo muestra impactos y fallos.
     * @param hit Símbolo de acierto.
     * @param fallo Símbolo de fallo.
     */
    public void tableroOponente(char hit, char fallo) {
        String encabezado = "    1 2 3 4 5";
        System.out.println(encabezado);

        for (int i = 0; i < 5; i++) {
            String fila = (i + 1) + " |";
            for (int j = 0; j < 5; j++) {
                char casillaActual = tablero[i][j];
                if (casillaActual == hit || casillaActual == fallo) fila += " " + casillaActual;
                else fila += " " + agua;
            }
            System.out.println(fila);
        }
    }
}
