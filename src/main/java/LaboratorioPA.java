import java.util.List;
import Logica.*;
import Presentacion.AltaAlbum;
import Presentacion.AltaListaReproduccion;
import java.util.ArrayList;
import Presentacion.AltaUsuario;
import Presentacion.ConsultaAlbum;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;

public class LaboratorioPA {    
    private JFrame principal;
    private IControllerUsuario ctrlU;
    private IControllerMusica ctrlM;
    private AltaUsuario AltUsr;
    private AltaAlbum AltAlb;
    private ConsultaAlbum ConAlb;
    private AltaListaReproduccion AltLis;
       
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
        
    public  LaboratorioPA(){
    iniciar();       
    Fabrica fabrica = Fabrica.getInstance();
    ctrlU = fabrica.getIControllerUsuario();   
    //instancio menus y los sete invisible.
    AltUsr = new Presentacion.AltaUsuario(ctrlU,principal);
    AltUsr.setVisible(false);
    
    ctrlM = fabrica.getIControllerMusica();   
    AltAlb = new Presentacion.AltaAlbum(ctrlM,principal);
    AltAlb.setVisible(false);
    ConAlb = new Presentacion.ConsultaAlbum(ctrlM,principal);
    ConAlb.setVisible(false);
    AltLis = new Presentacion.AltaListaReproduccion(ctrlM,principal);
    AltLis.setVisible(false);
    
    //principal.getContentPane().add(AU);   //SI ES UN JINTERNALFRAME.   
    }
    
    public void iniciar(){       
        //ventana principal 
        principal = new JFrame();
        principal.setTitle("Espotify - Menu principal.");
        principal.setBounds(100, 100, 450, 400);
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
                // Muestro el InternalFrame para registrar un usuario
                principal.setVisible(false);
                AltUsr.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrarUsr);
        
        //Opcion submenu Album
        JMenu menuAlbum = new JMenu("Albums");
        menuBar.add(menuAlbum);
        JMenuItem menuItemRegistrarAlbum = new JMenuItem("Registrar Album");
         JMenuItem menuItemConsultaAlbum = new JMenuItem("Consulta Album");
        menuItemRegistrarAlbum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                principal.setVisible(false);
                AltAlb.setVisible(true);
            }
        });
        menuItemConsultaAlbum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
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
    }    
}
