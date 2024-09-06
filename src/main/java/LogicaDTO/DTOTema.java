
package LogicaDTO;


public class DTOTema {
    private String referencia;
   private String nombre;
    private int duracion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public DTOTema(String refe) {
        this.referencia = refe;
 
    }
    

}
