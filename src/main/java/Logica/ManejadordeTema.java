package Logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class ManejadordeTema {
    EntityManagerFactory em = Persistence.createEntityManagerFactory("EspotifyBD2");
    private final EntityManager man = em.createEntityManager();
    private Map<String, Tema> nombreTema;
    private static ManejadordeTema instancia = null;
    
    private ManejadordeTema() {
    nombreTema = new HashMap<String, Tema>();
    }

    public static ManejadordeTema getinstance() {
        if (instancia == null)
            instancia = new ManejadordeTema();
        return instancia;
    }
    
     public void addTema(Tema T) {
        String nomTema = T.getNombre();
        nombreTema.put(nomTema, T);
    }
    
    public Tema obtenerTema(String nomTema) {
        return ((Tema) nombreTema.get(nomTema));
    }
     
    public  Tema AltaTema(String nombre, int Duracion){
    Tema t = new Tema(nombre,Duracion);
    return t;
    
    }
    
    public void AltatemaBasedatos(Tema t){
        try{
             man.getTransaction().begin();
             man.persist(t);
             man.getTransaction().commit();
      }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un ERROR","Error", JOptionPane.ERROR_MESSAGE);
                   
            }
    }
    
    
     public Tema[] getTemas() {
        if (nombreTema.isEmpty())
            return null;
        else {
            Collection<Tema> tem = nombreTema.values();
            Object[] o = tem.toArray();
            Tema[] temas = new Tema[o.length];
            for (int i = 0; i < o.length; i++) {
                temas[i] = (Tema) o[i];
            }

            return temas;
        }
    }
}
