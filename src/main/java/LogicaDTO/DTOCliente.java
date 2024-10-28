package LogicaDTO;

import java.util.HashSet;
import java.util.Set;

public class DTOCliente {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private String imagen;
    private String fechaNac;
    private Set<String> temasFavoritos;
    private Set<String> albumsFavoritos;
    private Set<String> listasFavoritas;

    // Constructor por defecto
    public DTOCliente(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imagen = imagen;
        this.fechaNac = fechaNac;
        this.temasFavoritos = new HashSet<>();
        this.albumsFavoritos = new HashSet<>();
        this.listasFavoritas = new HashSet<>();
    }

    // Constructor con parámetros
    public DTOCliente(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac,
                      Set<String> temasFavoritos, Set<String> albumsFavoritos, Set<String> listasFavoritas) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imagen = imagen;
        this.fechaNac = fechaNac;
        this.temasFavoritos = temasFavoritos;
        this.albumsFavoritos = albumsFavoritos;
        this.listasFavoritas = listasFavoritas;
    }

    // Getters y setters
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Set<String> getTemasFavoritos() {
        return temasFavoritos;
    }

    public void setTemasFavoritos(Set<String> temasFavoritos) {
        this.temasFavoritos = temasFavoritos;
    }

    public Set<String> getAlbumsFavoritos() {
        return albumsFavoritos;
    }

    public void setAlbumsFavoritos(Set<String> albumsFavoritos) {
        this.albumsFavoritos = albumsFavoritos;
    }

    public Set<String> getListasFavoritas() {
        return listasFavoritas;
    }

    public void setListasFavoritas(Set<String> listasFavoritas) {
        this.listasFavoritas = listasFavoritas;
    }
}
