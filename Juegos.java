import java.util.Scanner;
import java.util.InputMismatchException;

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
            scanner.nextLine(); // Limpiar buffer

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
                    // == INICIO del main de Ahorcado ==
                    while(true){ 
                        try{    
                            System.out.println("Jugador 1, indique la cantidad de letras de su palabra (minimo 2)");
                            Ahorcado.cantidad = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (Ahorcado.cantidad >= 2){
                                Ahorcado.palabra1 = new char[Ahorcado.cantidad];

                                System.out.println("Jugador1, indique su nombre");
                                String nombret = scanner.nextLine();

                                for(int i= 0; i < Ahorcado.palabra1.length; i++){
                                    while(true){
                                        try{
                                            System.out.println("Indique la letra en la posicion "+ (i+1) + " (unicamente MAYUSCULAS):");
                                            String letrat = scanner.nextLine();
                                            if (letrat.matches("[A-Z]")){
                                                Ahorcado.palabra1[i] = letrat.charAt(0);
                                                break;
                                            } else {
                                                throw new IllegalArgumentException("Letra invalida");
                                            }
                                        } catch(IllegalArgumentException e){
                                            System.out.println("Eleccion invalida, elija otra letra");
                                            scanner.nextLine();
                                        }
                                    }
                                }

                                Ahorcado.jugador1 = new Jugador(nombret, 6, Ahorcado.palabra1);
                                System.out.println();
                                break;        
                            } else {
                                System.out.println("Eleccion invalida");
                            }
                        } catch (InputMismatchException e){
                            System.out.println("Eleccion invalida");
                            scanner.nextLine();
                        }
                    }

                    while(true){    
                        try{    
                            System.out.println("Jugador 2, indique la cantidad de letras de su palabra (minimo 2)");
                            Ahorcado.cantidad2 = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (Ahorcado.cantidad2 >= 2){
                                Ahorcado.palabra2 = new char[Ahorcado.cantidad2];

                                System.out.println("Jugador 2, indique su nombre");
                                String nombrek = scanner.nextLine();

                                for(int j= 0; j < Ahorcado.palabra2.length; j++){
                                    while(true){
                                        try{
                                            System.out.println("Indique la letra en la posicion "+ (j+1) + " (unicamente MAYUSCULAS):");
                                            String letrak = scanner.nextLine();
                                            if (letrak.matches("[A-Z]")){
                                                Ahorcado.palabra2[j] = letrak.charAt(0);
                                                break;
                                            } else {
                                                throw new IllegalArgumentException("Letra invalida");
                                            }
                                        } catch(IllegalArgumentException e){
                                            System.out.println("Eleccion invalida, elija otra letra");
                                            scanner.nextLine();
                                        }
                                    }
                                }

                                Ahorcado.jugador2 = new Jugador(nombrek, 6, Ahorcado.palabra2);
                                System.out.println();
                                break;        
                            } else {
                                System.out.println("Eleccion invalida");
                            }
                        } catch (InputMismatchException e){
                            System.out.println("Eleccion invalida");
                            scanner.nextLine();
                        }
                    }

                    Ahorcado.palabra1Aux = new boolean[Ahorcado.cantidad];
                    for(int h = 0; h < Ahorcado.palabra1Aux.length; h++){
                        Ahorcado.palabra1Aux[h] = false; 
                    }
                    Ahorcado.palabra2Aux = new boolean[Ahorcado.cantidad2];
                    for(int p = 0; p < Ahorcado.palabra2Aux.length; p++){
                        Ahorcado.palabra2Aux[p] = false; 
                    }

                    Ahorcado juegoAhorcado = new Ahorcado(Ahorcado.jugador1, Ahorcado.jugador2);
                    juegoAhorcado.iniciarJuego(Ahorcado.jugador1, Ahorcado.jugador2);
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
