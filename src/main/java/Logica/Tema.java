package Logica;

public class Tema {
    private String nombre;
    private int duracion;
    
    public Tema(String nombre, int duracion){
        this.nombre = nombre;
        this.duracion = duracion;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getDuracion(){
        return duracion;
    }
    
    public void setNombre(){
        this.nombre = nombre;
    }
    
    public void setDuracion(){
        this.duracion = duracion;
    }
}
