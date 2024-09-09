package Logica;

import java.util.Collection;
import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario{
    public  Cliente(){ }
    public Cliente(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) {
        super(nickname, nombre, apellido, email, imagen, fechaNac, siguiendo, seguidores);
    }
}
