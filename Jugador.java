import java.util.Scanner;

/**
 * @class Jugador
 * @brief Representa a un jugador del juego Ahorcado. Contiene su nombre, intentos, palabra secreta y el estado de letras adivinadas.
 */
public class Jugador {

    //atributos

    /** Nombre del jugador */
    private String nombre;

    /** Cantidad de intentos restantes */
    private int intentos;

    /** Palabra secreta que el oponente debe adivinar */
    private char[] palabra;

    /** Arreglo auxiliar que indica qué letras han sido adivinadas correctamente */
    private boolean[] palabraAux; 

    /** Scanner para lectura de entrada desde consola */
    Scanner scanner = new Scanner(System.in);

    // constructor

    /**
     * @brief Constructor de la clase Jugador
     * @param nombre Nombre del jugador
     * @param intentos Número de intentos permitidos
     * @param palabra Arreglo de caracteres de la palabra secreta
     * @param palabraAux Arreglo de booleanos que marca letras adivinadas
     */
    public Jugador(String nombre, int intentos, char[] palabra, boolean[] palabraAux){
        this.nombre = nombre;
        this.intentos = intentos;
        this.palabra = palabra;
        this.palabraAux = palabraAux;
    }

    //setters

    /**
     * @brief Establece el nombre del jugador
     * @param nombre Nombre del jugador
     */
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    /**
     * @brief Establece la cantidad de intentos del jugador
     * @param intentos Número de intentos
     */
    public void setIntentos (int intentos) {
        this.intentos = intentos;
    }

    /**
     * @brief Establece la palabra del jugador
     * @param palabra Arreglo de caracteres que representa la palabra
     */
    public void setPalabra (char[] palabra) {
        this.palabra = palabra;
    }

    /**
     * @brief Establece el estado de letras adivinadas
     * @param palabraAux Arreglo booleano auxiliar
     */
    public void setPalabraAux (boolean[] palabraAux) {
        this.palabraAux = palabraAux;
    }  

    //getters

    /**
     * @return Nombre del jugador
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * @return Número de intentos restantes
     */
    public int getIntentos(){
        return this.intentos;
    }

    /**
     * @return Palabra secreta del jugador
     */
    public char[] getPalabra(){
        return this.palabra;
    }

    /**
     * @return Arreglo auxiliar con el estado de letras adivinadas
     */
    public boolean[] getPalabraAux(){
        return this.palabraAux;
    }

    /**
     * @brief Permite a un jugador adivinar una letra de la palabra del oponente.
     * Realiza validaciones y actualiza los intentos o el estado del juego según el resultado.
     * @param jugador1 Jugador que adivina
     * @param jugador2 Jugador que tiene la palabra
     */
    public void adivinarLetra(Jugador jugador1, Jugador jugador2){
        if(jugador1.getIntentos() > 0){
            try{
                System.out.println();
                System.out.println();
                System.out.println(jugador1.getNombre()+ " "+"elija una letra para adivinar");
                char letra= scanner.nextLine().charAt(0);
                    
                if (letra== 'A' || letra == 'B' || letra == 'C' || letra == 'D' || letra == 'E' || letra == 'F' || letra == 'G' || letra == 'H' || letra == 'I' || letra == 'J' || letra == 'K' || letra == 'L' || letra == 'M' || letra == 'N' || letra == 'O' || letra == 'P' || letra == 'Q' || letra == 'R' || letra == 'S' || letra == 'T' || letra == 'U' || letra == 'V' || letra == 'W' || letra == 'X' || letra == 'Y' || letra == 'Z'){ 
                    boolean acierto = false;    
                    for(int j = 0; j< jugador2.getPalabra().length;j++){
                        if(jugador2.getPalabra()[j]== letra){
                            jugador2.getPalabraAux()[j] = true;
                            acierto = true; 
                        }
                    }
                    if (acierto){
                        System.out.println ("HA ACERTADO");
                    }
                    else{
                        System.out.println();
                        System.out.println("Ha perdido un intento");
                        jugador1.setIntentos(jugador1.getIntentos() - 1);
                        if(jugador1.getIntentos() ==0){
                             System.out.println();
                            System.out.println( jugador1.getNombre() +" "+"ha perdido");
                            System.out.println();
                            System.out.println( jugador2.getNombre() +" "+"GANA");
                            //System.exit(0);
                        }
                        else{
                            System.out.println();
                            System.out.println("Le quedan"+" "+ jugador1.getIntentos() +" "+"intentos");
                        }
                    }
               
                }
                else{
                        throw new IllegalArgumentException("letra invalida");
                }
            }     
            catch (IllegalArgumentException e){
                System.out.println("letra INVALIDA, elija otra");
                scanner.nextLine();
            }                  
        }
    }

    /**
     * @brief Revisa el estado actual de la palabra del oponente.
     * Muestra las letras adivinadas y verifica si la palabra ha sido completada.
     * @param jugador1 Jugador que está adivinando
     * @param jugador2 Jugador oponente que tiene la palabra
     * @return true si la palabra fue completamente adivinada; false en caso contrario
     */
    public boolean revisarPalabra (Jugador jugador1, Jugador jugador2){
        for(int j = 0; j< jugador2.getPalabra().length; j++){
            if(jugador2.getPalabraAux()[j]){
                System.out.print(jugador2.getPalabra()[j]+ " ");
            }
            else{
                System.out.print("_");
            }
        }
        boolean palabraAcertada = true;
        for(int j = 0; j< jugador2.getPalabra().length; j++){
            if(!jugador2.getPalabraAux()[j]){
                palabraAcertada = false;
            }
        }
        if(palabraAcertada){
            System.out.println();
            System.out.println();
            System.out.println(jugador1.getNombre()+" "+"HA  GANADO");
            return true;
        }
        return false;
    }

} // clase.
