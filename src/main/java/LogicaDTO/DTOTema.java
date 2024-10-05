package LogicaDTO;

public class DTOTema {
    private String nombre;
    private String duracion;
    private String enlace;
    private int posicion;

    public DTOTema(String nombre, String duracion, String enlace, int posicion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.enlace = enlace;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }   

}