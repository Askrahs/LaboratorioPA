/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaDTO;


/**
 *
 * @author Santiago
 */
public class DTOGenero {

    private String Ref;

    private String nombre;

    private String nombrepapa;

    public DTOGenero(String Ref, String nombre, String nombrepapa) {
        this.Ref = Ref;
        this.nombre = nombre;
        this.nombrepapa = nombrepapa;
    }
    
    

        public String getRef() {
            return Ref;
        }

        public void setRef(String Ref) {
            this.Ref = Ref;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getNombrepapa() {
            return nombrepapa;
        }

        public void setNombrepapa(String nombrepapa) {
            this.nombrepapa = nombrepapa;
        }

    
    
}
