package Logica;

import LogicaDTO.*;
import Excepciones.*;
import java.util.Collection;
import java.util.List;

public interface IControllerUsuario {
    public abstract void registrarCliente(String nickname, String nombre, String apellido, String Email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String contraseña) throws UsuarioYaExisteException,EmailYaExiste; // 
    public abstract void registrarArtista(String nickname, String nombre, String apellido, String Email, String imagen,String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String biografia, String website, String contraseña) throws UsuarioYaExisteException,EmailYaExiste; // 
    public abstract void ListarUsuarios(String nickname) throws NoHayUsuariosEnElSistemaException; 
    public abstract void EliminarUsuario(String nickname) throws UsuarioNoExisteException; 
    public abstract void ModificarUsuario(String nickname) throws UsuarioNoExisteException; 
    public abstract void SeguirUsuario(String nickname1,String nickname2) throws UsuariosNoExisten;
    public abstract void DejarDeSeguirUsuario(String nickname1,String nickname2) throws UsuariosNoExisten;
    public abstract List<String> ObtenerNicknamesClientes() throws NoHayUsuariosEnElSistemaException;
    public abstract Cliente ObtenerCliente(String nickname) throws UsuarioNoExisteException;
    public abstract List<String> ObtenerSeguidoresCliente(String nickname) throws SinSeguidores;
    public abstract List<String> ObtenerSiguiendoCliente(String nickname) throws NoSigueANadie;
    public abstract Artista ObtenerArtista(String nickname) throws UsuarioNoExisteException;
    public abstract List<String> ObtenerAlbumsArtista(String nickname) throws ArtistaSinAlbums;
    public abstract List<String> ObtenerSeguidoresArtista(String nickname) throws SinSeguidores;
    public abstract List<String> obtenerArtistas();
    public abstract List<String> obtenerClientes();
    public abstract Long ObtenerCuentaSeguidores(String nickname);
    public abstract void agregarAlbumAFavoritos(String nickname, DTOAlbum album) throws ElementoNoValidoException;
    public abstract void agregarListaAFavoritos(String nickname, DTOLista lista) throws ElementoNoValidoException;
    public abstract void agregarTemaAFavoritos(String nickname, DTOTema tema) throws ElementoNoValidoException;

    public abstract void eliminarTemaDeFavoritos(String nickname, DTOTema tema) throws ElementoNoValidoException;
    public abstract void eliminarListaDeFavoritos(String nickname, DTOLista lista) throws ElementoNoValidoException;
    public abstract void eliminarAlbumDeFavoritos(String nickname, DTOAlbum album) throws ElementoNoValidoException;
    public abstract List<String> ObtenerListasCliente(String nickname);
    public abstract List<String> ObtenerAlbumsCliente(String nickname);
    public abstract List<String> ObtenerTemasCliente(String nickname);
    public abstract boolean LoginCliente(String nickname,String contraseña);
    public abstract boolean LoginArtista(String nickname,String contraseña);
    public abstract boolean EmailUsado(String Email);
    public abstract boolean NicknameUsado(String nickname);
    public abstract List<String> ObtenerNicknamesSuscripciones();
    public abstract Suscripcion ObtenerSuscripcion(String nickname);
    public abstract void ModificarSuscripcion(String nickname, String fecha, String Estado, String Tipo);
}