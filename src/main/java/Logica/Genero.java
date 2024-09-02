
package Logica;


//import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name="Genero")
public class Genero {
    
    @Id
    @Column(name="Ref")
    private String Ref;
    @Column(unique = true, name="Nombre")
    private String nombre;
    @Column(name="Padre")
    private String nombrepapa;

    public String getRef() {
        return Ref;
    }

    public void setRef(String Ref) {
        this.Ref = Ref;
    }

    public String getNombrepapa() {
        return nombrepapa;
    }

    public void setNombrepapa(String nombrepapa) {
        this.nombrepapa = nombrepapa;
    }
    

    public Genero(){
        
    }
    
     public Genero(String refer,String nombree, String nompadre){
        this.Ref = refer;
        this.nombre=nombree;
        this.nombrepapa=nompadre;
        
        
    }
    
    public String getref(){
        return Ref;
    }
    
    public String getpadre(){
        return nombrepapa;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 
    /*
   public boolean Existpapa(List<Genero> genpap,String nombre){
        for (Genero g : genpap){
            if(g.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
} 
  */  
    
   

   
    
    
}