public class Tablero {
    private char agua;
    private char[][] tablero;
    private boolean[][] barcos;

    //Getters
    public char getAgua() {
        return agua;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public boolean[][] getBarcos() {
        return barcos;
    }

    // Constructor
    public Tablero(char agua) {
        this.agua = agua;
        tablero = new char[5][5];
        barcos = new boolean[5][5];
        iniciarTablero();
    }
    // Metodo iniciar tableros
    public void iniciarTablero() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = agua;
                barcos[i][j] = false;
            }
        }
    }

    public void colocarBarcos(int fila, int col) {
        barcos[fila][col] = true;
        tablero[fila][col] = 'B';
    }
    public boolean hayBarco(int fila, int col) {
        return barcos[fila][col];
    }
    public void huboHit(int fila, int col, char hit) {
        tablero[fila][col] = hit;
    }
    public void hubofallo(int fila, int col, char fallo) {
        tablero[fila][col] = fallo;
    }
    public char getTablero(int fila, int col) {
        return tablero[fila][col];
    }

    // Imprimir tablero del jugador
    public void tableroPropio() {
        String encabezadoSuperior = "    1 2 3 4 5";
        System.out.println(encabezadoSuperior);

        for (int i = 0; i < 5; i++) {
            String fila = (i + 1) + " |";
            for (int j = 0; j < 5; j++) fila += " " + tablero[i][j];
            System.out.println(fila);
        }
    }

    // Tablero del oponente (Oculto para jugador actual)
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