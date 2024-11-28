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
    public abstract void agregarAlbumAFavoritos(String nickname, DtoAlbum album) throws ElementoNoValidoException;
    public abstract void agregarListaAFavoritos(String nickname, DtoLista lista) throws ElementoNoValidoException;
    public abstract void agregarTemaAFavoritos(String nickname, DtoTema tema) throws ElementoNoValidoException;
    public abstract void eliminarTemaDeFavoritos(String nickname, DtoTema tema) throws ElementoNoValidoException;
    public abstract void eliminarListaDeFavoritos(String nickname, DtoLista lista) throws ElementoNoValidoException;
    public abstract void eliminarAlbumDeFavoritos(String nickname, DtoAlbum album) throws ElementoNoValidoException;
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
    public abstract List<DtoArtista> obtenerArtistasData();
    public abstract List<DtoLista> ObtenerListasClienteDATA(String nickname);
    public abstract List<DtoAlbum> ObtenerAlbumsClienteDATA(String nickname);
    public abstract List<DtoTema> ObtenerTemasClienteDATA(String nickname);
    public abstract DtoTema ObtenerElTemadelAlbumdelArtista(String nickname, String NombreAlbum ,String NombreTema) throws UsuarioNoExisteException, ArtistaSinAlbums;
    public abstract List<DtoCliente> obtenerClientesData();
    public abstract void CrearSuscripcion(String nickname,String Tipo);
    public abstract DtoArtista ObtenerArtistaDTO(String nickname) throws UsuarioNoExisteException;
    public abstract DtoCliente ObtenerClienteDTO(String nickname) throws UsuarioNoExisteException;
    public abstract boolean usuarioSigueA(String seguidor, String seguido);
    public abstract List<String> obtenerNickArtistasBorrados();
    public abstract void darDeBajaArtista(String nickname);
    public abstract Boolean artistaActivo(String nickname);
    public abstract List<RegistroAcceso> obtenerTodosLosRegistros();
    public abstract void crearRegistro(String ipUsuario, String urlAcceso, String browserUsuario, String soUsuario);
    public abstract List<String> ObtenerRankingDeSeguidores();
    public abstract String ObtenerEstadoSus(String nickname);
    public abstract Boolean ClienteTieneSuscripcion(String nickname);
    public abstract DtoSuscripcion obtenerDTOSuscripcion(String nickname);
    public abstract void GuardarImagenDesdeWeb (byte[] imagenBytes, String nick);
    public abstract void GuardarImagenDesdeWebLista (byte[] imagenBytes, String nick, String nombreLista);
    public abstract byte[] cargarImagenCliWeb(String ruta);
    public abstract byte[] obtenerMp3(String ruta);

}