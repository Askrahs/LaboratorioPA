package Logica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;




@Entity
public class Tema {
    @Id
    @Column (unique = true,name="Nombre")
    private String nombre;
    @Column (name="Duracion")
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
