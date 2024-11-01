package Logica;

import LogicaDTO.DTOAlbum;
import LogicaDTO.DTOArtista;
import LogicaDTO.DTOCliente;
import LogicaDTO.DTOLista;
import LogicaDTO.DTOTema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerUsuarioTest {
    
    public ControllerUsuarioTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    

    
    @org.junit.jupiter.api.Test
    public void testRegistrarCliente() throws Exception {
    String nickname = "testNick";
    String nombre = "Test";
    String apellido = "User";
    String Email = "test@example.com";
    String imagen = "testImage.jpg";
    String fechaNac = "12/10/2002";
    Collection<Usuario> siguiendo = new ArrayList<>();
    Collection<Usuario> seguidores = new ArrayList<>();
    String contraseña = "password";
    
    ControllerUsuario instance = new ControllerUsuario();
    instance.registrarCliente(nickname, nombre, apellido, Email, imagen, fechaNac, siguiendo, seguidores, contraseña);

    
    assertNotNull(instance.ObtenerCliente(nickname)); // Verifica si el cliente fue registrado
    }

    
    @org.junit.jupiter.api.Test
    public void testRegistrarArtista() throws Exception {
        System.out.println("registrarArtista");
        String nickname = "artistaTest";
        String nombre = "test";
        String apellido = "test";
        String Email = "test@gmail.test";
        String imagen = "imagenes/test.jpg";
        String fechaNac = "12/10/2001";
        Collection<Usuario> siguiendo = null;
        Collection<Usuario> seguidores = null;
        String biografia = "Test bio";
        String website = "test.com";
        String contraseña = "test";
        ControllerUsuario instance = new ControllerUsuario();
        instance.registrarArtista(nickname, nombre, apellido, Email, imagen, fechaNac, siguiendo, seguidores, biografia, website, contraseña);
        
        assertNotNull(instance.ObtenerArtista(nickname));
    }

    /**
     * Test of SeguirUsuario method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testSeguirUsuario() throws Exception {
        System.out.println("SeguirUsuario");
        String nickname1 = "lachiqui";
        String nickname2 = "Heisenberg";
        ControllerUsuario instance = new ControllerUsuario();
        instance.SeguirUsuario(nickname1, nickname2);
        
        assertNotNull(instance.usuarioSigueA(nickname1, nickname2) );
    }

    /**
     * Test of DejarDeSeguirUsuario method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testDejarDeSeguirUsuario() throws Exception {
        System.out.println("DejarDeSeguirUsuario");
        String nickname1 = "lachiqui";
        String nickname2 = "Heisenberg";
        ControllerUsuario instance = new ControllerUsuario();
        instance.DejarDeSeguirUsuario(nickname1, nickname2);
        
        assertNotNull(instance.usuarioSigueA(nickname1, nickname2) == false);
    }

    /**
     * Test of ObtenerNicknamesClientes method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerNicknamesClientes() throws Exception {
        System.out.println("ObtenerNicknamesClientes");
        ControllerUsuario instance = new ControllerUsuario();
        List<String> result = instance.ObtenerNicknamesClientes();
        assertNotNull(result != null);
    }

    /**
     * Test of ObtenerCliente method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerCliente() throws Exception {
        System.out.println("ObtenerCliente");
        String nickname = "testNick";
        ControllerUsuario instance = new ControllerUsuario();
        
        Cliente result = instance.ObtenerCliente(nickname);
        assertNotNull(result != null);
    }

    /**
     * Test of ObtenerSeguidoresCliente method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerSeguidoresCliente() throws Exception {
        System.out.println("ObtenerSeguidoresCliente");
        String nickname = "benKenobi";
        ControllerUsuario instance = new ControllerUsuario();
        List<String> result = instance.ObtenerSeguidoresCliente(nickname);
        assertNotNull(result != null);
        
    }

    /**
     * Test of ObtenerSiguiendoCliente method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerSiguiendoCliente() throws Exception {
        System.out.println("ObtenerSiguiendoCliente");
        String nickname = "benKenobi";
        ControllerUsuario instance = new ControllerUsuario();
        List<String> result = instance.ObtenerSiguiendoCliente(nickname);
        assertNotNull(result != null);
    }

    /**
     * Test of ObtenerArtista method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerArtista() throws Exception {
        System.out.println("ObtenerArtista");
        String nickname = "clauper";
        ControllerUsuario instance = new ControllerUsuario();
        
        Artista result = instance.ObtenerArtista(nickname);
        
        assertNotNull(result != null);
    }

    /**
     * Test of ObtenerSeguidoresArtista method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerSeguidoresArtista() throws Exception {
        System.out.println("ObtenerSeguidoresArtista");
        String nickname = "clauper";
        ControllerUsuario instance = new ControllerUsuario();
        List<String> result = instance.ObtenerSeguidoresArtista(nickname);
        assertNotNull(result != null);
    }

    /**
     * Test of ObtenerAlbumsArtista method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerAlbumsArtista() throws Exception {
        System.out.println("ObtenerAlbumsArtista");
        String nickname = "dmode";
        ControllerUsuario instance = new ControllerUsuario();
        
        List<String> result = instance.ObtenerAlbumsArtista(nickname);
        assertNotNull(result != null);
    }

    /**
     * Test of ObtenerCuentaSeguidores method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerCuentaSeguidores() {
        System.out.println("ObtenerCuentaSeguidores");
        String nickname = "cbochinche";
        ControllerUsuario instance = new ControllerUsuario();
        Long result = instance.ObtenerCuentaSeguidores(nickname);
        assertNotNull(result > 0);
    }

    /**
     * Test of obtenerArtistas method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerArtistas() {
        System.out.println("obtenerArtistas");
        ControllerUsuario instance = new ControllerUsuario();

        List<String> result = instance.obtenerArtistas();

        assertNotNull(result != null);
    }

    /**
     * Test of obtenerClientes method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerClientes() {
        System.out.println("obtenerClientes");
        ControllerUsuario instance = new ControllerUsuario();
        List<String> result = instance.obtenerClientes();
        assertNotNull(result != null);
    }

    

   

   

    

    

   

    /**
     * Test of ObtenerListasClienteDATA method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerListasClienteDATA() {
        System.out.println("ObtenerListasClienteDATA");
        String nickname = "Heisenberg";
        ControllerUsuario instance = new ControllerUsuario();
        List<DTOLista> result = instance.ObtenerListasClienteDATA(nickname);
        assertNotNull(result != null);
        
    }

    /**
     * Test of ObtenerAlbumsClienteDATA method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerAlbumsClienteDATA() {
        System.out.println("ObtenerAlbumsClienteDATA");
        String nickname = "dmode";
        ControllerUsuario instance = new ControllerUsuario();
        List<DTOAlbum> result = instance.ObtenerAlbumsClienteDATA(nickname);
        assertNotNull(result != null);
        
    }

    /**
     * Test of ObtenerTemasClienteDATA method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerTemasClienteDATA() {
        System.out.println("ObtenerTemasClienteDATA");
        String nickname = "Eleven11";
        ControllerUsuario instance = new ControllerUsuario();
        List<DTOTema> result = instance.ObtenerTemasClienteDATA(nickname);
        assertNotNull(result != null);
    }

    /**
     * Test of ObtenerListasCliente method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerListasCliente() {
        System.out.println("ObtenerListasCliente");
        String nickname = "Heisenberg";
        ControllerUsuario instance = new ControllerUsuario();
        List<String> result = instance.ObtenerListasCliente(nickname);
        assertNotNull(result != null);
    }

    /**
     * Test of ObtenerAlbumsCliente method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerAlbumsCliente() {
        System.out.println("ObtenerAlbumsCliente");
        String nickname = "cbochinche";
        ControllerUsuario instance = new ControllerUsuario();
        List<String> result = instance.ObtenerAlbumsCliente(nickname);
        assertNotNull(result != null);
    }

    /**
     * Test of ObtenerTemasCliente method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerTemasCliente() {
        System.out.println("ObtenerTemasCliente");
        String nickname = "ppArgento";
        ControllerUsuario instance = new ControllerUsuario();
        List<String> result = instance.ObtenerTemasCliente(nickname);
        assertNotNull(result != null);
        
    }

    /**
     * Test of LoginCliente method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testLoginCliente() {
        System.out.println("LoginCliente");
        String nickname = "Heisenberg";
        String contraseña = "1234";
        ControllerUsuario instance = new ControllerUsuario();
        boolean result = instance.LoginCliente(nickname, contraseña);
        assertEquals(result, true);
    }

    /**
     * Test of LoginArtista method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testLoginArtista() {
        System.out.println("LoginArtista");
        String nickname = "clauper";
        String contraseña = "1234";
        ControllerUsuario instance = new ControllerUsuario();
        boolean expResult = true;
        boolean result = instance.LoginArtista(nickname, contraseña);
        assertEquals(expResult, result);
    }

    /**
     * Test of EmailUsado method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testEmailUsado() {
        System.out.println("EmailUsado");
        String Email = "nicoleneu@hotmail.com";
        ControllerUsuario instance = new ControllerUsuario();
        boolean expResult = true;
        boolean result = instance.EmailUsado(Email);
        assertEquals(expResult, result);
    }

    /**
     * Test of NicknameUsado method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testNicknameUsado() {
        System.out.println("NicknameUsado");
        String nickname = "ppArgento";
        ControllerUsuario instance = new ControllerUsuario();
        boolean expResult = true;
        boolean result = instance.NicknameUsado(nickname);
        assertEquals(expResult, result);
    }

    /**
     * Test of ObtenerNicknamesSuscripciones method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerNicknamesSuscripciones() {
        System.out.println("ObtenerNicknamesSuscripciones");
        ControllerUsuario instance = new ControllerUsuario();
        List<String> result = instance.ObtenerNicknamesSuscripciones();
        assertNotNull(result != null); //existen suscripciones
    }

    /**
     * Test of ObtenerSuscripcion method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerSuscripcion() {
        System.out.println("ObtenerSuscripcion");
        String nickname = "Heisenberg";
        ControllerUsuario instance = new ControllerUsuario();
        Suscripcion result = instance.ObtenerSuscripcion(nickname);
        assertNotNull(result != null); //existe la suscripcion
        
    }

    /**
     * Test of ModificarSuscripcion method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testModificarSuscripcion() {
        System.out.println("ModificarSuscripcion");
        String nickname = "Heisenberg";
        String fecha = "27/9/2024";
        String Estado = "VIGENTE";
        String Tipo = "ANUAL";
        ControllerUsuario instance = new ControllerUsuario();
        instance.ModificarSuscripcion(nickname, fecha, Estado, Tipo);
        Suscripcion sus = instance.ObtenerSuscripcion(nickname);
        
        assertNotNull("27/9/2024".equals(sus.getFecha()));
    }

    /**
     * Test of obtenerArtistasData method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerArtistasData() {
        System.out.println("obtenerArtistasData");
        ControllerUsuario instance = new ControllerUsuario();
        List<DTOArtista> result = instance.obtenerArtistasData();
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerClientesData method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerClientesData() {
        System.out.println("obtenerClientesData");
        ControllerUsuario instance = new ControllerUsuario();
        List<DTOCliente> result = instance.obtenerClientesData();
        assertNotNull(result != null);
    }

    /**
     * Test of CrearSuscripcion method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testCrearSuscripcion() {
        System.out.println("CrearSuscripcion");
        String nickname = "testNick";
        String Tipo = "MENSUAL";
        ControllerUsuario instance = new ControllerUsuario();
        instance.CrearSuscripcion(nickname, Tipo);
        Suscripcion sus = instance.ObtenerSuscripcion(nickname);
        assertNotNull(sus != null);
    }

    /**
     * Test of ObtenerArtistaDTO method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerArtistaDTO() throws Exception {
        System.out.println("ObtenerArtistaDTO");
        String nickname = "lospimpi";
        ControllerUsuario instance = new ControllerUsuario();
        DTOArtista result = instance.ObtenerArtistaDTO(nickname);
        assertNotNull(result != null);
    }

    /**
     * Test of ObtenerClienteDTO method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerClienteDTO() throws Exception {
        System.out.println("ObtenerClienteDTO");
        String nickname = "Heisenberg";
        ControllerUsuario instance = new ControllerUsuario();
        DTOCliente result = instance.ObtenerClienteDTO(nickname);
        assertNotNull(result != null);
    }

    

    /**
     * Test of usuarioSigueA method, of class ControllerUsuario.
     */
    @org.junit.jupiter.api.Test
    public void testUsuarioSigueA() {
        System.out.println("usuarioSigueA");
        String seguidor = "el_padrino";
        String seguido = "benKenobi";
        ControllerUsuario instance = new ControllerUsuario();
        boolean result = instance.usuarioSigueA(seguidor, seguido);
        assertNotNull(result == true);
    }
    
}
