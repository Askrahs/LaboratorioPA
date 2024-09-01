package Logica;
import java.util.List;

public class Genero {
    private String nombre;
    List <Genero> GeneroPapa;
    public Genero(){}
    
     public Genero(String nombree){
        this.nombre=nombree;      
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Genero> getGeneroPapa() {
        return GeneroPapa;
    }

    public void setGeneroPapa(List<Genero> GeneroPapa) {
        this.GeneroPapa = GeneroPapa;
    }
    public void añadopapa(Genero g){
        GeneroPapa.add(g);
    }
    
   public boolean Existpapa(List<Genero> genpap,String nombre){
        for (Genero g : genpap){
            if(g.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }  
}
