
package Logica;


import Logica.Lista;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
    

public class ManejadordeListas {
     EntityManagerFactory em = Persistence.createEntityManagerFactory("EspotifyBD2");
    private final EntityManager man = em.createEntityManager();
    private List<Lista> Listas;
    private static ManejadordeListas instancia = null;
    

    private ManejadordeListas(){
        
        Listas = new ArrayList<>();
    }
    
    public static ManejadordeListas getInstance(){
        if(instancia == null){
            instancia = new ManejadordeListas();
        }       
    return instancia;
    }
    
    public boolean esdueño(Cliente cli, Lista list){
        if(list.getPropietario().equals(cli)){
              return true;
        }else{
              return false;
        }
                        
    }
    
   public void pongotema(Lista list, Tema tem){
       
       list.añadotema(tem);
      try{
          man.getTransaction().begin();
       man.merge(list);
       man.getTransaction().commit();
      }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un ERROR","Error", JOptionPane.ERROR_MESSAGE);
                   
            }  
    }
    
    @SuppressWarnings("unchecked")
   public List<Lista> Obtengolista(String nombre){
       for(int i=0;i<Listas.size();i++){
           Lista li = Listas.get(i);
           if(li.getNombre().equalsIgnoreCase(nombre)){
               return (List<Lista>) li;
           }
       }
       return null;
   }
    public boolean espublica(Lista list ){
        if(list.isPublica()==true){
            return true;
        }
    return false;
    }

    public List<Lista> Listasdefault(){
        //JOptionPane.showMessageDialog(null,"llegue3");
        if(Listas.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay Listas en el sistema");
            return null;
        }    
        List <Lista> lisdefault;
        lisdefault = new ArrayList<>();
       for(int i=0;i<Listas.size();i++){
           Lista li = Listas.get(i);
           if(li.getPropietario()==null){
              lisdefault.add(li);
           }
       }
       
      return lisdefault;
          
       }
   }

    
    




