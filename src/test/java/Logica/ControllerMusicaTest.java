
package Logica;

import LogicaDTO.DTOAlbum;
import LogicaDTO.DTOGenero;
import LogicaDTO.DTOLista;
import LogicaDTO.DTOTema;
import java.util.List;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerMusicaTest {
    
    public ControllerMusicaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

   

    

    /**
     * Test of DameTodoslosgeneros method, of class ControllerMusica.
     */
    @Test
    public void testDameTodoslosgeneros() {
        System.out.println("DameTodoslosgeneros");
        ControllerMusica instance = new ControllerMusica();
        DefaultMutableTreeNode result = instance.DameTodoslosgeneros();
        assertNotNull(result != null);
        
    }

    

    

    /**
     * Test of altaListaReproduccion method, of class ControllerMusica.
     */
    @Test
    public void testAltaListaReproduccion() throws Exception {
        System.out.println("altaListaReproduccion");
        String nombre = "LaListaTestDePePe";
        String genero = "";
        String duenio = "ppArgento";
        String ruta = "/imagenes/testing.jpg";
        boolean privada = false;
        ControllerMusica instance = new ControllerMusica();
        instance.altaListaReproduccion(nombre, genero, duenio, ruta, privada);
        DTOLista listaTest = instance.ObtenerListaporTitulo(nombre);
        assertNotNull(listaTest != null);
    }

    /**
     * Test of publicarLista method, of class ControllerMusica.
     */
    @Test
    public void testPublicarLista() throws Exception {
        System.out.println("publicarLista");
        String nombreUsuario = "ppArgento";
        String nombreLista = "LaListaTestDePePe";
        ControllerMusica instance = new ControllerMusica();
        instance.publicarLista(nombreUsuario, nombreLista);
        List<DTOLista> listasPublicasTest = instance.ObtengoListasPublicas();
        DTOLista listaTestPublica = null;
        for (DTOLista dTOLista : listasPublicasTest) {
            if ("LaListaTestDePePe".equals(dTOLista.getNombre())){
                listaTestPublica = dTOLista;
            }
        }
        assertEquals(listaTestPublica.getNombre(), "LaListaTestDePePe");
    }

    

    /**
     * Test of obtenerAlbumsPorGenero method, of class ControllerMusica.
     */
    @Test
    public void testObtenerAlbumsPorGenero() {
        System.out.println("obtenerAlbumsPorGenero");
        String generoSeleccionado = "Dance-pop";
        ControllerMusica instance = new ControllerMusica();
        List<String> result = instance.obtenerAlbumsPorGenero(generoSeleccionado);
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerAlbumsPorArtista method, of class ControllerMusica.
     */
    @Test
    public void testObtenerAlbumsPorArtista() {
        System.out.println("obtenerAlbumsPorArtista");
        String artistaSeleccionado = "dmode";
        ControllerMusica instance = new ControllerMusica();
        List<String> result = instance.obtenerAlbumsPorArtista(artistaSeleccionado);
        assertNotNull(result != null);
    }

    /**
     * Test of consultaAlbumPorTitulo method, of class ControllerMusica.
     */
    @Test
    public void testConsultaAlbumPorTitulo() {
        System.out.println("consultaAlbumPorTitulo");
        String albumSeleccionado = "El Lago De Los Cisnes";
        ControllerMusica instance = new ControllerMusica();
        DTOAlbum result = instance.consultaAlbumPorTitulo(albumSeleccionado);
        assertNotNull(result != null);
    }

    /**
     * Test of Datageneros method, of class ControllerMusica.
     */
    @Test
    public void testDatageneros() {
        System.out.println("Datageneros");
        ControllerMusica instance = new ControllerMusica();
        List<DTOGenero> result = instance.Datageneros();
        assertNotNull(result != null);
    }

    /**
     * Test of existeAlbum method, of class ControllerMusica.
     */
    @Test
    public void testExisteAlbum() {
        System.out.println("existeAlbum");
        String nicknameArtista = "clauper";
        String titulo = "Shes So Unusual";
        ControllerMusica instance = new ControllerMusica();
        boolean result = instance.existeAlbum(nicknameArtista, titulo);
        assertNotNull(result == true);
    }

    /**
     * Test of AñadotemalistaAlbum method, of class ControllerMusica.
     */
    @Test
    public void testAñadotemalistaAlbum() {
        System.out.println("A\u00f1adotemalistaAlbum");
        String nombreAlbum = "";
        String nombreLista = "";
        String nombreTema = "";
        String nombreUsuario = "";
        ControllerMusica instance = new ControllerMusica();
        instance.AñadotemalistaAlbum(nombreAlbum, nombreLista, nombreTema, nombreUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultaTemaPorTituloYAlbum method, of class ControllerMusica.
     */
    @Test
    public void testConsultaTemaPorTituloYAlbum() {
        System.out.println("consultaTemaPorTituloYAlbum");
        String nombreTema = "";
        String nombreAlbum = "";
        String nombreArtista = "";
        ControllerMusica instance = new ControllerMusica();
        DTOTema expResult = null;
        DTOTema result = instance.consultaTemaPorTituloYAlbum(nombreTema, nombreAlbum, nombreArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Obtengolistasconduenio method, of class ControllerMusica.
     */
    @Test
    public void testObtengolistasconduenio() throws Exception {
        System.out.println("Obtengolistasconduenio");
        ControllerMusica instance = new ControllerMusica();
        List<DTOLista> result = instance.Obtengolistasconduenio();
        assertNotNull(result != null);
    }

    /**
     * Test of Obtengolistassinduenio method, of class ControllerMusica.
     */
    @Test
    public void testObtengolistassinduenio() throws Exception {
        System.out.println("Obtengolistassinduenio");
        ControllerMusica instance = new ControllerMusica();
        List<DTOLista> result = instance.Obtengolistassinduenio();
        assertNotNull(result != null);
    }

    /**
     * Test of Obtengolistas method, of class ControllerMusica.
     */
    @Test
    public void testObtengolistas() throws Exception {
        System.out.println("Obtengolistas");
        ControllerMusica instance = new ControllerMusica();
        List<DTOLista> result = instance.Obtengolistas();
        assertNotNull(result != null);
    }

    /**
     * Test of aniadoTemaListaPublica method, of class ControllerMusica.
     */
    @Test
    public void testAniadoTemaListaPublica() {
        System.out.println("aniadoTemaListaPublica");
        String nombrelista = "";
        String nombreteam = "";
        String nombrealb = "";
        ControllerMusica instance = new ControllerMusica();
        instance.aniadoTemaListaPublica(nombrelista, nombreteam, nombrealb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EliminotemaLista method, of class ControllerMusica.
     */
    @Test
    public void testEliminotemaLista() {
        System.out.println("EliminotemaLista");
        String nombreLista = "";
        String nombreTema = "";
        String nombreAlbum = "";
        ControllerMusica instance = new ControllerMusica();
        instance.EliminotemaLista(nombreLista, nombreTema, nombreAlbum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

    /**
     * Test of aniadoTemaListaConduenio method, of class ControllerMusica.
     */
    @Test
    public void testAniadoTemaListaConduenio() {
        System.out.println("aniadoTemaListaConduenio");
        String nombreUsuario = "";
        String nombrelista = "";
        String nombreteam = "";
        String nombrealb = "";
        ControllerMusica instance = new ControllerMusica();
        instance.aniadoTemaListaConduenio(nombreUsuario, nombrelista, nombreteam, nombrealb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TemasdeListasDTO method, of class ControllerMusica.
     */
    @Test
    public void testTemasdeListasDTO() {
        System.out.println("TemasdeListasDTO");
        String nombrelista = "Noche De La Nostalgia";
        ControllerMusica instance = new ControllerMusica();
        List<DTOTema> result = instance.TemasdeListasDTO(nombrelista);
        assertNotNull(result != null);
    }

    /**
     * Test of TemasdeListas method, of class ControllerMusica.
     */
    @Test
    public void testTemasdeListas() {
        System.out.println("TemasdeListas");
        String nombrelista = "Noche De La Nostalgia";
        ControllerMusica instance = new ControllerMusica();
        List<DTOTema> result = instance.TemasdeListas(nombrelista);
        assertNotNull(result != null);
    }

    /**
     * Test of ObtengoAlbums method, of class ControllerMusica.
     */
    @Test
    public void testObtengoAlbums() {
        System.out.println("ObtengoAlbums");
        ControllerMusica instance = new ControllerMusica();
        List<DTOAlbum> result = instance.ObtengoAlbums();
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerTemitasDATA method, of class ControllerMusica.
     */
    @Test
    public void testObtenerTemitasDATA() {
        System.out.println("obtenerTemitasDATA");
        ControllerMusica instance = new ControllerMusica();
        List<DTOTema> result = instance.obtenerTemitasDATA();
        assertNotNull(result != null);
    }

    /**
     * Test of ObtengoTemasdeAlbum method, of class ControllerMusica.
     */
    @Test
    public void testObtengoTemasdeAlbum() {
        System.out.println("ObtengoTemasdeAlbum");
        String nombreAlbum = "Primer Amor";
        ControllerMusica instance = new ControllerMusica();
        List<DTOTema> result = instance.ObtengoTemasdeAlbum(nombreAlbum);
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerTemitas method, of class ControllerMusica.
     */
    @Test
    public void testObtenerTemitas() {
        System.out.println("obtenerTemitas");
        ControllerMusica instance = new ControllerMusica();
        List<DTOTema> result = instance.obtenerTemitas();
        assertNotNull(result != null);
    }

    /**
     * Test of ObtengoListasPublicasDATA method, of class ControllerMusica.
     */
    @Test
    public void testObtengoListasPublicasDATA() {
        System.out.println("ObtengoListasPublicasDATA");
        ControllerMusica instance = new ControllerMusica();
        List<DTOLista> result = instance.ObtengoListasPublicasDATA();
        assertNotNull(result != null);
    }

    /**
     * Test of ObtengoListasPublicas method, of class ControllerMusica.
     */
    @Test
    public void testObtengoListasPublicas() throws Exception {
        System.out.println("ObtengoListasPublicas");
        ControllerMusica instance = new ControllerMusica();
        List<DTOLista> result = instance.ObtengoListasPublicas();
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerAlbums method, of class ControllerMusica.
     */
    @Test
    public void testObtenerAlbums() {
        System.out.println("obtenerAlbums");
        ControllerMusica instance = new ControllerMusica();
        List<DTOAlbum> result = instance.obtenerAlbums();
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerListaPorGenero method, of class ControllerMusica.
     */
    @Test
    public void testObtenerListaPorGenero() {
        System.out.println("obtenerListaPorGenero");
        String generoSeleccionado = "Rock";
        ControllerMusica instance = new ControllerMusica();
        List<String> result = instance.obtenerListaPorGenero(generoSeleccionado);
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerListaPorClienteDATA method, of class ControllerMusica.
     */
    @Test
    public void testObtenerListaPorClienteDATA() {
        System.out.println("obtenerListaPorClienteDATA");
        String clienteseleccionado = "Heisenberg";
        ControllerMusica instance = new ControllerMusica();
        List<DTOLista> result = instance.obtenerListaPorClienteDATA(clienteseleccionado);
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerListaPorCliente method, of class ControllerMusica.
     */
    @Test
    public void testObtenerListaPorCliente() {
        System.out.println("obtenerListaPorCliente");
        String clienteseleccionado = "Heisenberg";
        ControllerMusica instance = new ControllerMusica();
        List<String> result = instance.obtenerListaPorCliente(clienteseleccionado);
        assertNotNull(result != null);
    }

    /**
     * Test of ObtenerListaporTitulo method, of class ControllerMusica.
     */
    @Test
    public void testObtenerListaporTitulo() throws Exception {
        System.out.println("ObtenerListaporTitulo");
        String nombrelista = "Musica Clasica ";
        ControllerMusica instance = new ControllerMusica();
        DTOLista result = instance.ObtenerListaporTitulo(nombrelista);
        assertNotNull(result != null);
    }

    /**
     * Test of consultaListaPorTitulo method, of class ControllerMusica.
     */
    @Test
    public void testConsultaListaPorTitulo() {
        System.out.println("consultaListaPorTitulo");
        String listaSeleccionada = "Musica Clasica ";
        ControllerMusica instance = new ControllerMusica();
        DTOLista result = instance.consultaListaPorTitulo(listaSeleccionada);
        assertNotNull(result != null);
    }

    /**
     * Test of consultaListaPorTituloyGenero method, of class ControllerMusica.
     */
    @Test
    public void testConsultaListaPorTituloyGenero() {
        System.out.println("consultaListaPorTituloyGenero");
        String listaSeleccionada = "Musica Clasica ";
        String genero = "Clásica";
        ControllerMusica instance = new ControllerMusica();
        DTOLista result = instance.consultaListaPorTituloyGenero(listaSeleccionada, genero);
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerTemitasfavCliente method, of class ControllerMusica.
     */
    @Test
    public void testObtenerTemitasfavCliente() {
        System.out.println("obtenerTemitasfavCliente");
        String nickname = "Eleven11";
        ControllerMusica instance = new ControllerMusica();
        List<DTOTema> result = instance.obtenerTemitasfavCliente(nickname);
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerListitas method, of class ControllerMusica.
     */
    @Test
    public void testObtenerListitas() {
        System.out.println("obtenerListitas");
        ControllerMusica instance = new ControllerMusica();
        List<DTOLista> result = instance.obtenerListitas();
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerListitasfavCliente method, of class ControllerMusica.
     */
    @Test
    public void testObtenerListitasfavCliente() {
        System.out.println("obtenerListitasfavCliente");
        String nickname = "el_padrino";
        ControllerMusica instance = new ControllerMusica();
        List<DTOLista> result = instance.obtenerListitasfavCliente(nickname);
        assertNotNull(result != null);
    }

    /**
     * Test of obtenerAlbumsfavCliente method, of class ControllerMusica.
     */
    @Test
    public void testObtenerAlbumsfavCliente() {
        System.out.println("obtenerAlbumsfavCliente");
        String nickname = "el_padrino";
        ControllerMusica instance = new ControllerMusica();
        List<DTOAlbum> result = instance.obtenerAlbumsfavCliente(nickname);
        assertNotNull(result != null);
    }

    /**
     * Test of consultaTemaPorTitulo method, of class ControllerMusica.
     */
    @Test
    public void testConsultaTemaPorTitulo() {
        System.out.println("consultaTemaPorTitulo");
        String temaSeleccionada = "Glory Days";
        ControllerMusica instance = new ControllerMusica();
        DTOTema result = instance.consultaTemaPorTitulo(temaSeleccionada);
        assertEquals(result.getNombre(), "Glory Days");
        assertEquals(result.getEnlace(), "https://soundcloud.com/scottrek-160/glory-days-bruce-springsteen-the-e-street-band-1" );
        
    }

    

    

    

    /**
     * Test of obtenerTodosLosAlbums method, of class ControllerMusica.
     */
    @Test
    public void testObtenerTodosLosAlbums() {
        System.out.println("obtenerTodosLosAlbums");
        ControllerMusica instance = new ControllerMusica();
        List<DTOAlbum> result = instance.obtenerTodosLosAlbums();
        assertNotNull(result);
    }

    /**
     * Test of obtenerListaPorGeneroDTOLISTA method, of class ControllerMusica.
     */
    @Test
    public void testObtenerListaPorGeneroDTOLISTA() {
        System.out.println("obtenerListaPorGeneroDTOLISTA");
        String generoSeleccionado = "Rock Latino";
        ControllerMusica instance = new ControllerMusica();
        List<DTOLista> result = instance.obtenerListaPorGeneroDTOLISTA(generoSeleccionado);
        assertNotNull(result);
    }

    /**
     * Test of albumEsDeXGenero method, of class ControllerMusica.
     */
    @Test
    public void testAlbumEsDeXGenero() {
        System.out.println("albumEsDeXGenero");
        String albumTitulo = "Born In The U.S.A. ";
        String artistaNickname = "bruceTheBoss";
        String generoNombre = "Pop Clásico";
        ControllerMusica instance = new ControllerMusica();
        boolean result = instance.albumEsDeXGenero(albumTitulo, artistaNickname, generoNombre);
        assertNotNull(result);
    }

    /**
     * Test of temasDelAlbum method, of class ControllerMusica.
     */
    @Test
    public void testTemasDelAlbum() {
        System.out.println("temasDelAlbum");
        String titulo = "Primer Amor";
        ControllerMusica instance = new ControllerMusica();
        List<DTOTema> result = instance.temasDelAlbum(titulo);
        assertNotNull(result != null);
    }

    /**
     * Test of ObtengolistasClipriv method, of class ControllerMusica.
     */
    @Test
    public void testObtengolistasClipriv() throws Exception {
        System.out.println("ObtengolistasClipriv");
        String nickcli = "Heisenberg";
        ControllerMusica instance = new ControllerMusica();
        List<String> result = instance.ObtengolistasClipriv(nickcli);
        assertNotNull(result != null);
    }

    /**
     * Test of AgregarTemaLista method, of class ControllerMusica.
     */
    @Test
    public void testAgregarTemaLista() throws Exception {
        System.out.println("AgregarTemaLista");
        String nombreusuario = "";
        String nombrelista = "";
        String nombretema = "";
        ControllerMusica instance = new ControllerMusica();
        instance.AgregarTemaLista(nombreusuario, nombrelista, nombretema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
