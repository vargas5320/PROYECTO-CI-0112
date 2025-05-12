

public class Jugador {
    //atributos

    private String nombre;
    private int intentos;
    private char[] palabra;

    // constructor

    public Jugador(String nombre, int intentos, char[] palabra){
        this.nombre = nombre;
        this.intentos = intentos;
        this.palabra= palabra; 
    }

    //set y get

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }  
    public void setIntentos (int intentos) {
        this.intentos = intentos;
    } 
     public void setPalabra (char[] palabra) {
        this.palabra = palabra;
    } 
    
    public String getNombre () {
        return this.nombre;
    }
    public int getIntentos () {
        return this.intentos;
    }
   
    

    


}