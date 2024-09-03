/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaDTO;

/**
 *
 * @author gasto
 */
public class DTOArtista {
    private String nickname;
    private String nombre; 
    private String apellido; 
    private String email; 
    private String biografia; 
    private String website;

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getWebsite() {
        return website;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
