package Logica;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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

            TypedQuery<Lista> query = em.createQuery("SELECT l from Lista l where l.nombre = :nombre", Lista.class);
            
            query.setParameter("nombre", nombrelista);
            Lista lis;
            try{        
            lis = query.getSingleResult();
            }catch(Exception e){
               //  System.out.println("No se encontró ninguna lista con el nombre proporcionado.");
                 return null;
            }

           // JOptionPane.showMessageDialog(null,"El nobre de la lista es: "+lis.getNombre());
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
        
        public void aniadotemalista(String nombrelista,Tema tem){
            Lista lis = this.ExisteLista(nombrelista);
            lis.addTema(tem);
            t.begin();
            em.merge(lis);
            t.commit();
            JOptionPane.showMessageDialog(null,"Tema añadido con exito a la lista");
         }
     
        
        
        
        public List <Lista> todaslistas(){
            //JOptionPane.showMessageDialog(null,"llegue3");
            List<Lista> listas = em.createQuery("select l from Lista l", Lista.class).getResultList();
            return listas;
            
        }
        
        public List<Lista> todaslistassinduenio(){
            List<Lista> listas = em.createQuery("select l from Lista l where l.duenio = null", Lista.class).getResultList();
            return listas;
        }
        
        public List<Lista> todaslistaspublica(){
            List<Lista> listas = em.createQuery("select l from Lista l where l.esPrivada = false", Lista.class).getResultList();
            return listas;
        }
        
        public List<Lista> todaslistasconduenio(){
            List<Lista> listas = em.createQuery("select l from Lista l where l.duenio is not null", Lista.class).getResultList();
            return listas;
        }
        

        //(nombre, genero, duenio,ruta,privada)
        public void creolista (String nombre, String genero, String duenio,String ruta,boolean privada){
            //JOptionPane.showMessageDialog(null,"llegue1");
            ManejadorGenero mang = ManejadorGenero.getInstance();
            ManejadorUsuario manu = ManejadorUsuario.getinstance();
            Genero g = mang.Existegenbasedatoss(genero);
            Usuario u = manu.obtenerUsuario(duenio);
            Lista L = new Lista(nombre, ruta, privada,g,u);
            addLista(L);
        }
        
        
        public List<Tema> temasdelalista(String nombrelista){
            Lista lis = this.ExisteLista(nombrelista);
            List<Tema> temos = lis.getTemas();
            return temos;
        }
        
        public void Eliminotemalista(String nombreLista, Tema tem){
        Tema temardo = em.find(Tema.class, tem.getId());  // Pido el tema buscandolo por ID
    if (temardo != null) {
        Lista lis = this.ExisteLista(nombreLista);
        lis.removeTema(temardo);  // Remover el tema de la lista
        t.begin();
        em.merge(lis);  // Actualizar la lista
        t.commit();
    }
            JOptionPane.showMessageDialog(null,"Tema Removido con exito a la lista");
        }
        
        public void publicolista( boolean Privada , Lista lista){
        lista.setEsPrivada(Privada);
        lista.removeDuenio();
        try {
                t.begin();
                em.merge(lista);
                t.commit();
            } catch (Exception e) {
                //si sale mal rollback
                t.rollback();
            }
        
    }
}