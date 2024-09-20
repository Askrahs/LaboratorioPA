package Logica;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.swing.JOptionPane;

@Entity
public class Cliente extends Usuario{

    @ManyToMany
    @JoinTable(
        name = "cliente_tema_favorito", 
        joinColumns = @JoinColumn(name = "cliente_id"), 
        inverseJoinColumns = @JoinColumn(name = "tema_id")
    )
    private Set<Tema> temasFavoritos = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "cliente_album_favorito", 
        joinColumns = @JoinColumn(name = "cliente_id"), 
        inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private Set<Album> albumsFavoritos = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "cliente_lista_favorita", 
        joinColumns = @JoinColumn(name = "cliente_id"), 
        inverseJoinColumns = @JoinColumn(name = "lista_id")
    )
    private Set<Lista> listasFavoritas = new HashSet<>();
    
    public  Cliente(){ 
    this.temasFavoritos = new HashSet<>();
    this.albumsFavoritos = new HashSet<>();
    this.listasFavoritas = new HashSet<>();
    }

    public Cliente(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) {
        super(nickname, nombre, apellido, email, imagen, fechaNac, siguiendo, seguidores);
    }
    
     public void removerTemaFavorito(Tema tema) {
        if (temasFavoritos.contains(tema)) {
            temasFavoritos.remove(tema);
        }
    }

    public void removerListaFavorita(Lista lista) { 
        listasFavoritas.remove(lista);
    }

    public void removerAlbumFavorito(Album album) {
        if (albumsFavoritos.contains(album)) {
            albumsFavoritos.remove(album);
        }
    }

    public Set<Tema> getTemasFavoritos() {
        return temasFavoritos;
    }

    public Set<Lista> getListasFavoritas() {
        return listasFavoritas;
    }

    public Set<Album> getAlbumsFavoritos() {
        return albumsFavoritos;
    }
    
    public void agregarTemaFavorito(Tema tema) {
        if (!temasFavoritos.contains(tema)) {
            temasFavoritos.add(tema);
        }
    }

    public void agregarListaFavorita(Lista lista) {
        if (!listasFavoritas.contains(lista)) {
            listasFavoritas.add(lista);
        }
    }

    public void agregarAlbumFavorito(Album album) {
        if (!albumsFavoritos.contains(album)) {
            albumsFavoritos.add(album);
        }
    }
    
}
