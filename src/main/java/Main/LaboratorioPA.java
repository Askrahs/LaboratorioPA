package Main;

import Excepciones.NoExisteLista;
import Logica.*;
import Presentacion.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class LaboratorioPA {
    public static final String CARPETA_IMAGEN = "D:/Netbeans/EspotifyBD/";
    private JFrame principal;
    private IControllerUsuario ctrlU;
    private IControllerMusica ctrlM;
    private AltaUsuario AltUsr;
    private SeguirUsuario SegUsr;
    private DejarDeSeguirUsuario DejUsr;
    private ConsultaCliente ConCli;
    private AltaAlbum AltAlb;
    private ConsultaAlbum ConAlb;
    private AltaListaReproduccion AltLis;
    private AltaGenero AltGen;
    private AgregarTemaLista AgreTemList;
    private ConsultaArtista ConArt;
    private AgregarTemaListaPublica TiposAniaTemList;
    private AgregarTemaListaÁlbum AgrTemLisAlb;
    private PublicarLista PblLista;
    private ConsultaListadeReproduccion ConList;
    private EliminarTemaListaAlbum EliTemLisAlb;    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LaboratorioPA window = new LaboratorioPA();
                    window.principal.setVisible(true); //menu principal
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LaboratorioPA() throws NoExisteLista {
        iniciar();
        Fabrica fabrica = Fabrica.getInstance();
        ctrlU = fabrica.getIControllerUsuario();
        ctrlM = fabrica.getIControllerMusica();
        //instancio menus y los sete invisible.
        AltUsr = new Presentacion.AltaUsuario(ctrlU, principal);
        AltUsr.setVisible(false);

        //seguir Usuario
        SegUsr = new Presentacion.SeguirUsuario(ctrlU, principal);
        SegUsr.setVisible(false);
        DejUsr = new Presentacion.DejarDeSeguirUsuario(ctrlU, principal);
        SegUsr.setVisible(false);
        ConCli = new Presentacion.ConsultaCliente(ctrlU, principal);
        ConCli.setVisible(false);
        AgrTemLisAlb = new Presentacion.AgregarTemaListaÁlbum(ctrlM,ctrlU,principal);
        AgrTemLisAlb.setVisible(false);
        EliTemLisAlb = new Presentacion.EliminarTemaListaAlbum(ctrlM, ctrlU, principal);
        EliTemLisAlb.setVisible(false);
        
        
        ConList = new Presentacion.ConsultaListadeReproduccion(ctrlU, ctrlM, principal);
        ConList.setVisible(false);
        PblLista = new Presentacion.PublicarLista(ctrlM, principal);
        PblLista.setVisible(false);
        AltAlb = new Presentacion.AltaAlbum(ctrlM, principal);
        AltAlb.setVisible(false);
        ConAlb = new Presentacion.ConsultaAlbum(ctrlU, ctrlM, principal);
        ConAlb.setVisible(false);
        AltLis = new Presentacion.AltaListaReproduccion(ctrlM, principal);
        AltLis.setVisible(false);
        AltGen = new Presentacion.AltaGenero(ctrlM, principal);
        AltGen.setVisible(false);
        AgreTemList = new Presentacion.AgregarTemaLista(ctrlM, principal);
        AgreTemList.setVisible(false);
        ConArt = new Presentacion.ConsultaArtista(ctrlU,principal);
        ConArt.setVisible(false);
        TiposAniaTemList = new Presentacion.AgregarTemaListaPublica(ctrlM, principal);
        TiposAniaTemList.setVisible(false);
        
        //principal.getContentPane().add(AU);   //SI ES UN JINTERNALFRAME.   
    }

    public void iniciar() {
        //ventana principal 
        principal = new JFrame();
        principal.setTitle("Espotify - Menu principal.");
        principal.setBounds(100, 100, 600, 600);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //sub menu de la ventana principal
        JMenuBar menuBar = new JMenuBar();
        principal.setJMenuBar(menuBar);
        JMenu menuSistema = new JMenu("Sistema");
        menuBar.add(menuSistema);

        //opcion Salir del sub menu
        JMenuItem menuSalir = new JMenuItem("Salir");
        menuSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Salgo de la aplicación
                principal.setVisible(false);
                principal.dispose();
            }
        });
        menuSistema.add(menuSalir);

        //opciones de usuarios del submenu
        JMenu menuUsuarios = new JMenu("Usuarios");
        menuBar.add(menuUsuarios);
        JMenuItem menuItemRegistrarUsr = new JMenuItem("Registrar Usuario");
        menuItemRegistrarUsr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
                AltUsr.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrarUsr);

        //SEGUIR USUARIO
        JMenuItem menuItemSeguirUsr = new JMenuItem("Seguir Usuario");
        menuItemSeguirUsr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                principal.setVisible(false);
                SegUsr.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemSeguirUsr);

        //DEJAR DE SEGUIR USUARIO
        JMenuItem menuItemDejarDeSeguirUsr = new JMenuItem("Dejar de seguir Usuario");
        menuItemDejarDeSeguirUsr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
                DejUsr.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemDejarDeSeguirUsr);

        //CONSULTA CLIENTE
        JMenuItem menuItemConCli = new JMenuItem("Consulta Cliente");
        menuItemConCli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
                
                ConCli.setVisible(true);
                
                
                
            }
        });
        menuUsuarios.add(menuItemConCli);
        
         //AÑADIR FAVORITOS SACAR
        JMenuItem menuItemconAnia = new JMenuItem("Añado Favorito");
        menuItemconAnia.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
//                AgrTemLisAlb.setVisible(true);
                
            }
        });
        menuUsuarios.add(menuItemconAnia);
        
         //AÑADIR FAVORITOS
        JMenuItem menuItemconElim = new JMenuItem("Elimino Favorito");
        menuItemconElim.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
//                EliTemLisAlb.setVisible(true);
                
            }
        });
        menuUsuarios.add(menuItemconElim);
        //CONSULTA ARTISTA
        JMenuItem menuItemConArt = new JMenuItem("Consulta Artista");
        menuItemConArt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
                ConArt.setVisible(true);
                
            }
        });
        menuUsuarios.add(menuItemConArt);
        
        //Opcion submenu Album
        JMenu menuAlbum = new JMenu("Albums");
        menuBar.add(menuAlbum);
        JMenuItem menuItemRegistrarAlbum = new JMenuItem("Registrar Album");
        JMenuItem menuItemConsultaAlbum = new JMenuItem("Consulta Album");
        menuItemRegistrarAlbum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
                AltAlb.setBounds(100,100,800,500);
                AltAlb.setVisible(true);
            }
        });
        menuItemConsultaAlbum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
                ConAlb.setVisible(true);
            }
        });
        menuAlbum.add(menuItemRegistrarAlbum);
        menuAlbum.add(menuItemConsultaAlbum);

        //Opcion submenu Lista
        JMenu menuLista = new JMenu("Listas de Reproduccion");
        menuBar.add(menuLista);
        JMenuItem menuItemRegistrarLista = new JMenuItem("Crear Lista");
        menuItemRegistrarLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                principal.setVisible(false);              
                AltLis.setVisible(true);
            }
        });
        menuLista.add(menuItemRegistrarLista);
        
        //opcion submenu Publicar Lista
        JMenuItem menuItemPblLista = new JMenuItem("Publicar Lista");
        menuItemPblLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
                PblLista.setVisible(true);
                //( ͡❛ ͜ʖ͡❛ )
            }
        });
        menuLista.add(menuItemPblLista);
        
        //opcion submenu Consulta Lista
        JMenuItem menuItemConList = new JMenuItem("Consulta Lista");
        menuItemConList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
               ConList.setVisible(true);
                //( ͡❛ ͜ʖ͡❛ )
            }
        });
        menuLista.add(menuItemConList);
        
        //Añado tema a lista
        JMenuItem MenuItemaniadotem = new JMenuItem("Añado Tema a Lista");
        MenuItemaniadotem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
                TiposAniaTemList.setVisible(true);
            }
        });
        menuLista.add(MenuItemaniadotem);
        
        

        //Opcion submenu Genero
        JMenu menuGen = new JMenu("Generos");
        menuBar.add(menuGen);
        JMenuItem menuItemRegistrarGenero = new JMenuItem("Registrar Genero");
        menuItemRegistrarGenero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                principal.setVisible(false);
                AltGen.setVisible(true);
            }
        });
        menuGen.add(menuItemRegistrarGenero);

    }
    
}
