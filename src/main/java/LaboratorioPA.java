import java.util.List;
import Logica.*;
import Presentacion.Agregar_Tema_Lista;
import Presentacion.AltaAlbum;
import java.util.ArrayList;
import Presentacion.AltaUsuario;
import Presentacion.Alta_Genero;
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
    private Alta_Genero AltGen;
    private Agregar_Tema_Lista AgreTemList;
       
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
    ctrlM = fabrica.getIController();
    //instancio menus y los sete invisible.
    AltUsr = new Presentacion.AltaUsuario(ctrlU,principal);
    AltUsr.setVisible(false);
    
    AltAlb = new Presentacion.AltaAlbum(ctrlM,principal);
    AltAlb.setVisible(false);
    
    AltGen = new Presentacion.Alta_Genero(ctrlM,principal);
    AltGen.setVisible(false);
    
    AgreTemList = new Presentacion.Agregar_Tema_Lista(ctrlU, principal);
    AgreTemList.setVisible(false);
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
        menuItemRegistrarAlbum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                principal.setVisible(false);
                AltAlb.setVisible(true);
            }
        });
        menuAlbum.add(menuItemRegistrarAlbum);
        
        
        
        //Opcion submenu Genero
        JMenu MenuGen = new JMenu("Generos");
        menuBar.add(MenuGen);
        JMenuItem menuItemRegistrarGenero = new JMenuItem("Registrar Genero");
        menuItemRegistrarGenero.addActionListener (new ActionListener() {
        public void actionPerformed(ActionEvent e){
            //muestro le iternalframe para registrar genero
            principal.setVisible(false);
            AltGen.setVisible(true);
        }
    
    }); 
    MenuGen.add(menuItemRegistrarGenero);

        //Opcion Agregar Tema a Lista
         JMenu MenuAgreTemList = new JMenu("Agrego Temas a Lista");
        menuBar.add(MenuAgreTemList);
        JMenuItem menuItemRegistrarTemaLista = new JMenuItem("Registrar Tema a Lista");
        menuItemRegistrarTemaLista.addActionListener (new ActionListener() {
        public void actionPerformed(ActionEvent e){
            //muestro le iternalframe para registrar genero
            principal.setVisible(false);
            AgreTemList.setVisible(true);
        }
    
    }); 
    MenuAgreTemList.add(menuItemRegistrarTemaLista);
    
    
    }
}
