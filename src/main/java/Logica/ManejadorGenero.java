package Logica;
import java.util.ArrayList;
import java.util.List;

public class ManejadorGenero {
    List <Genero> TodoslosGeneros;
    private static ManejadorGenero instancia = null;  
    
    private ManejadorGenero(){
        TodoslosGeneros = new ArrayList<>();
    }
    
    public static ManejadorGenero getInstance(){
        if(instancia == null){
            instancia = new ManejadorGenero();
        }       
    return instancia;
    }
    
    public Genero ObtenerGenero(String nombre){
        for (Genero g : TodoslosGeneros){
            if(g.getNombre().equalsIgnoreCase(nombre)){
                return g;
            }
        }
    return null;
    }
    
    public void AltaGenero(String nombregen, String nombrepadre){
        Genero g = new Genero(nombregen);
        Genero gen = ObtenerGenero(nombrepadre);
        g.añadopapa(gen);
        this.TodoslosGeneros.add(g);
    }
    public void AltaGeneroPadre(String nombregen){
        Genero g = new Genero(nombregen);
        this.TodoslosGeneros.add(g);
    }   
    
public boolean Existegenero(String nombre){
        for (Genero g : TodoslosGeneros){
            if(g.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
}

public boolean esvacio(){
    if(TodoslosGeneros==null){
        return false;
    }
    return true;
    }
}
    
    
    

