package Logica;
import java.util.Collection;

public class Cliente extends Usuario{
    public  Cliente(){ }

    public Cliente(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) {
        super(nickname, nombre, apellido, email, imagen, fechaNac, siguiendo, seguidores);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
