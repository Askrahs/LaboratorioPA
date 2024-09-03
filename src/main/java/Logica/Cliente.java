package Logica;
//leandro
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    // Atributo que almacena las listas de reproducción del cliente
    private List<Lista> listasPropias;

    // Constructor vacío
    public Cliente() {
        super();
        this.listasPropias = new ArrayList<>(); // Inicializar la lista
    }
    
    // Constructor con parámetros
    public Cliente(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) {
        super(nickname, nombre, apellido, email, imagen, fechaNac, siguiendo, seguidores);
        this.listasPropias = new ArrayList<>(); // Inicializar la lista
    }
    
    public Lista buscarListaPorNombre(String nombreLista) {
        for (Lista lista : listasPropias) {
            if (lista.getNombre().equalsIgnoreCase(nombreLista)) {
                return lista;
            }
        }
        return null; // Retorna null si no encuentra ninguna lista con ese nombre
    }
    
    public List<Lista> getListasPropias() {
        return listasPropias;
    }

    public void addListaPropia(Lista lista) {
        this.listasPropias.add(lista);
    }

    public void removeListaPropia(Lista lista) {
        this.listasPropias.remove(lista);
    }

    @Override
    public String getNickname() {
        return nickname;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
}
