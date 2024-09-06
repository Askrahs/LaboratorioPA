package Logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="Tema")
public class Tema implements Serializable {
    @Id
    @Column(name ="Referencia")
    private String Referencia;
    @Column(name ="Nombre")
    private String nombre;
    @Column(name ="Duracion")
    private String duracion;
    

   
    
    public Tema() {
    }


   
    
    
    
 

    public Tema(String Referencia, String nombre, String duracion) {
        this.Referencia = Referencia;
        this.nombre = nombre;
        this.duracion = duracion;
    }
    
     public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }
    public String getNombre(){
        return nombre;
    }
    
    public String getDuracion(){
        return duracion;
    }
    
    public void setNombre(){
        this.nombre = nombre;
    }
    
    public void setDuracion(){
        this.duracion = duracion;
    }

    void begin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
