package Logica;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class ManejadorLista {
    private static ManejadorLista instancia = null;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;
    
    public ManejadorLista(){
        emf = Persistence.createEntityManagerFactory("EspotifyBD");
        em = emf.createEntityManager();
        t = em.getTransaction(); //se usa para las consultas y commits/rollbacks
    }
    
    public static ManejadorLista getInstance(){
        if (instancia == null)
            instancia = new ManejadorLista();
        return instancia;
    }
    
        public void addLista(Lista lista) {
         try {
            t.begin();
            em.persist(lista);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
    }

        public Lista ExisteLista(String nombrelista){
            t.begin();
            Lista lis = em.find(Lista.class,nombrelista);
            t.commit();
            return lis;
                
        }
        public boolean esdueño(String nombrelista, String nombreusuario){
          
            Lista lis;
            lis = ExisteLista(nombrelista);
            
            if(lis.getDuenio().getNombre().equalsIgnoreCase(nombreusuario)){
                return true;
            }else{
                return false;
            }
        }
        
        public boolean espublica(String nombre){
            Lista lis;
            lis = ExisteLista(nombre);
            if(lis.getEsPrivada()!=true){
                return true;
        }else{
            return false;
            }
        }
        
//        public void aniadotemalista(String nombrelista,String nombretema){
//            ManejadordeTema mante = ManejadordeTema.getinstance();
//            Tema tem = mante.obtenerTema(nombretema);
//            Lista lis = this.ExisteLista(nombrelista);
//            lis.addTema(tem);
//            t.begin();
//            em.merge(lis);
//            t.commit();
//            JOptionPane.showMessageDialog(null,"Tema añadido con exito a la lista");
//        }
     
        
        
        
        public List <Lista> todaslistas(){
            //JOptionPane.showMessageDialog(null,"llegue3");
            List<Lista> listas = em.createQuery("select l from Lista l", Lista.class).getResultList();
            return listas;
            
        }

        
        public void creolista (String nombre, String genero, String duenio){
            JOptionPane.showMessageDialog(null,"llegue1");
            ManejadorGenero mang = ManejadorGenero.getInstance();
            ManejadorUsuario manu = ManejadorUsuario.getinstance();
            Genero g = mang.Existegenbasedatoss(genero);
            Usuario u = manu.obtenerUsuario(duenio);
            Lista L = new Lista(nombre, null, true,g,u);
            addLista(L);
        }
}
