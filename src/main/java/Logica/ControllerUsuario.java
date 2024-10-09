package Logica;

import Excepciones.*;
import LogicaDTO.DTOAlbum;
import LogicaDTO.DTOLista;
import LogicaDTO.DTOTema;
import java.util.ArrayList;
import Persistencia.ControllerPersistencia;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ControllerUsuario implements IControllerUsuario {
    ControllerPersistencia cPersist = new ControllerPersistencia();
    
    @Override
    public void registrarCliente(String nickname, String nombre, String apellido, String Email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String contraseña) throws UsuarioYaExisteException, EmailYaExiste {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        //Controles
        Usuario u = mu.obtenerUsuario(nickname);
        if (u == null) {
            Boolean a = mu.EmailUsado(Email);
            if (a == false) {
                mu.AltaCliente(nickname, nombre, apellido, Email, imagen, fechaNac, siguiendo, seguidores, contraseña);
            } else {
                throw new EmailYaExiste("El Email ingresado ya existe");
            }
        } else {
            throw new UsuarioYaExisteException("El usuario ingresado ya existe");
        }
    }

    @Override
    public void registrarArtista(String nickname, String nombre, String apellido, String Email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String biografia, String website, String contraseña) throws UsuarioYaExisteException, EmailYaExiste {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        //Controles
        Usuario u = mu.obtenerUsuario(nickname);
        if (u == null) {
            Boolean a = mu.EmailUsado(Email);
            if (a == false) {
                mu.AltaArtista(nickname, nombre, apellido, Email, imagen, fechaNac, siguiendo, seguidores, biografia, website, contraseña);
            } else {
                throw new EmailYaExiste("El Email ingresado ya existe");
            }
        } else {
            throw new UsuarioYaExisteException("El usuario ingresado ya existe");
        }
    }

    @Override
    public void ListarUsuarios(String nickname) throws NoHayUsuariosEnElSistemaException {
        throw new NoHayUsuariosEnElSistemaException("No hay usuarios en el sistema.");
    }

    @Override
    public void EliminarUsuario(String nickname) throws UsuarioNoExisteException {
        throw new UsuarioNoExisteException("El usuario " + nickname + " no existe");
    }

    @Override
    public void ModificarUsuario(String nickname) throws UsuarioNoExisteException {
        throw new UsuarioNoExisteException("El usuario " + nickname + " no existe.");
    }

    @Override
    public void SeguirUsuario(String nickname1, String nickname2) throws UsuariosNoExisten {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        //Verificar que existan
        Cliente seguidor = mu.obtenerCliente(nickname1);
        Usuario seguido = mu.obtenerUsuario(nickname2);
        if (seguidor == null) {
            throw new UsuariosNoExisten("El cliente ingresado no existe.");
        } else if (seguido == null) {
            throw new UsuariosNoExisten("El usuario ingresado a seguir no existe.");
        }
        mu.SeguirUsuario(nickname1, nickname2);
    }

    @Override
    public void DejarDeSeguirUsuario(String nickname1, String nickname2) throws UsuariosNoExisten {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        //Verificar que existan
        Cliente seguidor = mu.obtenerCliente(nickname1);
        Usuario seguido = mu.obtenerUsuario(nickname2);
        if (seguidor == null) {
            throw new UsuariosNoExisten("El cliente no existe.");
        } else if (seguido == null) {
            throw new UsuariosNoExisten("El usuario ingresado no existe.");
        }
        mu.DejarDeSeguirUsuario(nickname1, nickname2);
    }

    @Override
    public List<String> ObtenerNicknamesClientes() throws NoHayUsuariosEnElSistemaException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        List<String> nicknames = null;
        nicknames = mu.ObtenerNicknamesClientes(); //METODO MANEJADOR
        if (nicknames != null) {
            return nicknames;
        } else {
            throw new NoHayUsuariosEnElSistemaException("No hay usuarios en el sistema."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    @Override
    public Cliente ObtenerCliente(String nickname) throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Cliente c = null;
        c = mu.obtenerCliente(nickname);
        if (c == null) {
            throw new UsuarioNoExisteException("El usuario seleccionado no existe...");
        }
        return c;
    }

    @Override
    public List<String> ObtenerSeguidoresCliente(String nickname) throws SinSeguidores {
        List<String> nickSeguidores = new ArrayList<>();
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Cliente cliente = mu.obtenerCliente(nickname);
        Collection<Usuario> seguidores = cliente.getSeguidores();
        for (Usuario u : seguidores) {
            nickSeguidores.add(u.getNickname());
        }
        if (nickSeguidores == null) {
            throw new SinSeguidores("Cliente sin seguidores");
        }
        return nickSeguidores;
    }

    @Override
    public List<String> ObtenerSiguiendoCliente(String nickname) throws NoSigueANadie {
        List<String> nickSiguiendo = new ArrayList<>();
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Cliente cliente = mu.obtenerCliente(nickname);
        Collection<Usuario> siguiendo = cliente.getSiguiendo();
        for (Usuario u : siguiendo) {
            nickSiguiendo.add(u.getNickname());
        }
        if (nickSiguiendo == null) {
            throw new NoSigueANadie("Este Cliente no sigue a ningun Usuario.");
        }
        return nickSiguiendo;
    }
    
    @Override
    public Artista ObtenerArtista(String nickname) throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Artista a = null;
        a = mu.obtenerArtista(nickname);
        if (a == null) {
            throw new UsuarioNoExisteException("El Artista seleccionado no existe...");
        }
        return a;
    }
    
    @Override
    public List<String> ObtenerSeguidoresArtista(String nickname) throws SinSeguidores {
        List<String> nickSeguidores = new ArrayList<>();
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Artista artista = mu.obtenerArtista(nickname);
        Collection<Usuario> seguidores = artista.getSeguidores();
        for (Usuario u : seguidores) {
            nickSeguidores.add(u.getNickname());
        }
        if (nickSeguidores == null) {
            throw new SinSeguidores("Artista sin seguidores");
        }
        return nickSeguidores;
    }

    @Override
    public List<String> ObtenerAlbumsArtista(String nickname) throws ArtistaSinAlbums {
        List<String> titulos = new ArrayList<>();
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Artista artista = mu.obtenerArtista(nickname);
        Collection<Album> albums = artista.getPublicados();
        for (Album a : albums) {
            titulos.add(a.getTitulo());
        }
        if (titulos == null) {
            throw new ArtistaSinAlbums("Artista sin Albums");
        }
          return titulos;
          
    }

    @Override
    public Long ObtenerCuentaSeguidores(String nickname) {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        return mu.ObtenerCuentaSeguidores(nickname);
    }
    
    @Override
    public List<String> obtenerArtistas(){
            return cPersist.obtenerArtistas();
    }

    @Override
    public List<String> obtenerClientes(){
            return cPersist.obtenerClientes();
    }
    
    

    @Override
    public void agregarTemaAFavoritos(String nickname, DTOTema tema) throws ElementoNoValidoException {
        ManejadorUsuario Mu = ManejadorUsuario.getinstance();
        Cliente c = Mu.obtenerCliente(nickname);
        Tema t = cPersist.findTemaPorDatos(tema.getNombre(), tema.getDuracion(), tema.getEnlace(), tema.getPosicion());
        if (t == null) {
            throw new ElementoNoValidoException("El tema no existe.");
        }
        if (c.getTemasFavoritos() != null && c.getTemasFavoritos().contains(t)) {
        throw new ElementoNoValidoException("El Tema ya está en los favoritos.");
        }
        Mu.addTemafavoritos(c, t);
    }

        @Override
    public void agregarListaAFavoritos(String nickname, DTOLista lista) throws ElementoNoValidoException {
        ManejadorUsuario Mu = ManejadorUsuario.getinstance();
    Cliente c = Mu.obtenerCliente(nickname);
    Lista l = cPersist.consultaListaPorTitulo(lista.getNombre());
    if (l == null) {
        throw new ElementoNoValidoException("La lista no existe.");
    }
    if (c.getAlbumsFavoritos() != null && c.getAlbumsFavoritos().contains(l)) {
        throw new ElementoNoValidoException("El Album ya está en los favoritos.");
    }
    Mu.addListafavoritos(c, l);
    }

    @Override
    public void agregarAlbumAFavoritos(String nickname, DTOAlbum album) throws ElementoNoValidoException {
        ManejadorUsuario Mu = ManejadorUsuario.getinstance();
        Cliente c = Mu.obtenerCliente(nickname);
        Album a = cPersist.findAlbumPorDatos(album.getArtista(), album.getTitulo());
        if (a == null) {
            throw new ElementoNoValidoException("El tema no existe.");
        }
        if (c.getAlbumsFavoritos() != null && c.getAlbumsFavoritos().contains(a)) {
        throw new ElementoNoValidoException("El Album ya está en los favoritos.");
        }
        Mu.addAlbumfavoritos(c, a);
    }
    
    
    @Override
    public void eliminarTemaDeFavoritos(String nickname, DTOTema tema) throws ElementoNoValidoException {
    ManejadorUsuario Mu = ManejadorUsuario.getinstance();
    Cliente c = Mu.obtenerCliente(nickname);
    
    // Verificar si el DTOTema proporcionado es válido
    if (tema == null) {
        throw new ElementoNoValidoException("El tema proporcionado es inválido.");
    }

    // Buscar el tema real en la base de datos utilizando los datos del DTO
    Tema t = cPersist.findTemaPorDatos(tema.getNombre(), tema.getDuracion(), tema.getEnlace(), tema.getPosicion());

    // Verificar si la lista existe en la base de datos
    if (t == null) {
        throw new ElementoNoValidoException("El Tema no existe.");
    }
    boolean encontrado = false;
    for (Tema temas : c.getTemasFavoritos()) {
    if (temas.getNombre().equals(t.getNombre())) {
        encontrado = true;
        break;
    }
    }

    if (encontrado) {
    Mu.EliminarTemafavoritos(c, t);
    } else {
    throw new ElementoNoValidoException("El Album no está en los favoritos del cliente.");
    }
}

    @Override
    public void eliminarListaDeFavoritos(String nickname, DTOLista lista) throws ElementoNoValidoException {
    ManejadorUsuario Mu = ManejadorUsuario.getinstance();
    Cliente c = Mu.obtenerCliente(nickname);
    
    // Verificar si el DTOLista proporcionado es válido
    if (lista == null) {
        throw new ElementoNoValidoException("La lista proporcionada es inválida.");
    }
    Lista l = cPersist.consultaListaPorTitulo(lista.getNombre());
    if (l == null) {
        throw new ElementoNoValidoException("La lista no existe.");
    }
    boolean encontrado = false;
    for (Lista listas : c.getListasFavoritas()) {
    if (listas.getNombre().equals(l.getNombre())) {
        encontrado = true;
        break;
    }
    }

    if (encontrado) {
    Mu.EliminarListafavoritos(c, l);
    } else {
    throw new ElementoNoValidoException("La lista no está en los favoritos del cliente.");
    }
    
}

    @Override
    public void eliminarAlbumDeFavoritos(String nickname, DTOAlbum album) throws ElementoNoValidoException {
    ManejadorUsuario Mu = ManejadorUsuario.getinstance();
    Cliente c = Mu.obtenerCliente(nickname);

    if (album == null) {
        throw new ElementoNoValidoException("El álbum proporcionado es inválido.");
    }
    Album a = cPersist.findAlbumPorDatos(album.getArtista(), album.getTitulo());
    if (a == null) {
        throw new ElementoNoValidoException("El Album no existe.");
    }
    boolean encontrado = false;
    for (Album Albums : c.getAlbumsFavoritos()) {
    if (Albums.getTitulo().equals(a.getTitulo())) {
        encontrado = true;
        break;
    }
    }
    if (encontrado) {
    Mu.EliminarAlbumfavoritos(c, a);
    } else {
    throw new ElementoNoValidoException("El tema no está en los favoritos del cliente.");
    }
}

    @Override
    public List<String> ObtenerListasCliente(String nickname) {
        ManejadorUsuario Mu = ManejadorUsuario.getinstance();
        List<String> nombresListas = Mu.obtenerListasCli(nickname);
        return nombresListas;
    }

    @Override
    public List<String> ObtenerAlbumsCliente(String nickname) {
        ManejadorUsuario Mu = ManejadorUsuario.getinstance();
        List<String> nombresAlbums = Mu.obtenerAlbumsCli(nickname);
        return nombresAlbums;
    }

    @Override
    public List<String> ObtenerTemasCliente(String nickname) {
        ManejadorUsuario Mu = ManejadorUsuario.getinstance();
        List<String> nombresTemas = Mu.obtenerTemasCli(nickname);
        return nombresTemas;
    }

    
}