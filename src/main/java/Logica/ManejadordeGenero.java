package Logica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Santiago
 */
public class ManejadordeGenero {
   EntityManagerFactory em = Persistence.createEntityManagerFactory("EspotifyBD2");
    private final EntityManager man = em.createEntityManager();
    
    private final DefaultMutableTreeNode ArbolGenero;
    private static ManejadordeGenero instancia = null;
    List<Genero> Todosgeneros;
    
    private ManejadordeGenero(){
        this.Todosgeneros = new ArrayList<>();
        ArbolGenero = new DefaultMutableTreeNode("Generos");
    }
    
    public static ManejadordeGenero getInstance(){
        if(instancia == null){
            instancia = new ManejadordeGenero();
        }       
    return instancia;
    }
    
   
    public DefaultMutableTreeNode ObtengoNodoRaiz(){
        return ArbolGenero;
    }
    
    public DefaultMutableTreeNode EncuentroGenero(String nombreGenero){
        return BuscoNodoRecursi(ArbolGenero, nombreGenero);
    }
    
    public boolean EncuentroGenerobool(String nombreGenero){
        if(BuscoNodoRecursi(ArbolGenero,nombreGenero)==null){
            return true;
        }else{
            return false;
        }
    }
    
    public  DefaultMutableTreeNode BuscoNodoRecursi(DefaultMutableTreeNode Nodo,String nombreGenero){
        if(Nodo.toString().equalsIgnoreCase(nombreGenero)){//Si el nodo actual coincide con el nombre que estás buscando, se devuelve este nodo y se termina la búsqueda.
            return Nodo;
        }
        for(int i = 0; i<Nodo.getChildCount();i++){// Nodo.getchildcount devuelve el número de hijos que tiene el nodo actual. Si no tiene hijos, el método for no se ejecutará.
            DefaultMutableTreeNode hijo =(DefaultMutableTreeNode) Nodo.getChildAt(i);//Obtiene el hijo en la posición i del nodo actual este hijo lo guardo en la variable child
            DefaultMutableTreeNode resultado = BuscoNodoRecursi(hijo, nombreGenero);//Se llama a si misma la funcion pero ahora con el nodo hijo
            if(resultado != null){
                return resultado;
            }
        }
    return null;
    }
    
    
//public boolean Existegenerobool(String nombre){
//        for (Genero g : TodoslosGeneros){
//           if(g.getNombre().equalsIgnoreCase(nombre)){
//                return true;
//            }
//        }
//        return false;
//}

public boolean esvacio(){
    if(ArbolGenero==null){
        return false;
    }
    return true;
}


public void remuevoGenero(String GeneroElimino){
    DefaultMutableTreeNode nodoelimin = EncuentroGenero(GeneroElimino);
   nodoelimin.removeFromParent();
}

public void AñadoGenerobasedatos(Genero ge){
    
    JOptionPane.showMessageDialog(null, "llegue1");
          try{
                  man.getTransaction().begin();
                  
                  man.persist(ge);
                  
                  man.getTransaction().commit();
            }catch(Exception e){}
          Seteopadrenull();
}
 
public void AñadoGenero(String refe, String nombreGenero, DefaultMutableTreeNode nodopadre){
    
    String namepapa = (String)nodopadre.getUserObject();
    Genero g = new Genero(refe, nombreGenero, namepapa);
   
    
        AñadoGenerobasedatos(g);
    
    Todosgeneros.add(g);
    
    DefaultMutableTreeNode NuevoNodo = new DefaultMutableTreeNode(g.getNombre());
    nodopadre.add(NuevoNodo);
    
    
    
    
}

public boolean eshijode(DefaultMutableTreeNode nodohijo,DefaultMutableTreeNode nodopadre){
    for (int i = 0; i<nodopadre.getChildCount();i++){
        if(nodopadre.getChildAt(i).equals(nodohijo)){
            return true;
        }
    }
    return false;
}

public void lepongopadre(DefaultMutableTreeNode nodohijo, DefaultMutableTreeNode nodopapa){
  
        nodopapa.add(nodohijo);
     
}

public boolean Existegenerolistabool(String refe, String nombre, String nombrepapa){
    Genero gen;
    for( int i=0; i<Todosgeneros.size();i++){
        gen=Todosgeneros.get(i);
        if(gen.getNombre().equals(nombre)){
            if(gen.getpadre().equals(nombrepapa)){
                if(gen.getref().equals(refe)){
                return true;
                }
            }
        }
    }


    return false;
}

public Genero Existegenerolista(String refe, String nombre, String nombrepapa){
    Genero gen;
    for( int i=0; i<Todosgeneros.size();i++){
        gen=Todosgeneros.get(i);
        if(gen.getNombre().equals(nombre)){
            if(gen.getpadre().equals(nombrepapa)){
                if(gen.getref().equals(refe)){
                return gen;
                }
            }
        }
    }
    return null;
}
  


public boolean Existegenbasedatos(String refe){

    Genero gus = (Genero) man.find(Genero.class, refe);
    if(gus!=null){
                return true;
        }
    
    return false;
}

public void Seteopadrenull(){
   
    man.getTransaction().begin();
       String cuestion = ("update Genero g set g.nombrepapa=null where g.nombrepapa = 'Generos'");
       int total = man.createQuery(cuestion).executeUpdate();
       System.out.println("Rengoles actualizados" + total);
    man.getTransaction().commit();
}



}


    
    
    

