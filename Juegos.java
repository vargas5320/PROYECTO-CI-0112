import java.util.Scanner;

public class Juegos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Menú de Juegos ===");
            System.out.println("1. Jugar Batalla Naval");
            System.out.println("2. Jugar Ahorcado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    BatallaNaval juego = new BatallaNaval('~', 'X', 'O', 3);
                    juego.iniciarTableros();
                    System.out.println("Jugador 1, coloque sus barcos: ");
                    juego.colocarBarcos(juego.getBarcosJugador1(), juego.getTableroJugador1());
                    System.out.println("Jugador 2, coloque sus barcos: ");
                    juego.colocarBarcos(juego.getBarcosJugador2(), juego.getTableroJugador2());
                    juego.jugar();
                    break;
                case 2:
                    //Insertar codigo del ahorcado
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
