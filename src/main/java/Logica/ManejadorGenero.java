package Logica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class ManejadorGenero {
    EntityManagerFactory em = Persistence.createEntityManagerFactory("EspotifyBD");
    private final EntityManager man = em.createEntityManager();
    private final DefaultMutableTreeNode ArbolGenero;
    private static ManejadorGenero instancia = null;
   // private List<Genero> Todosgeneros;

    private ManejadorGenero() {
  //      this.Todosgeneros = new ArrayList<>();
        ArbolGenero = new DefaultMutableTreeNode("Generos");
    }

    public static ManejadorGenero getInstance() {
        if (instancia == null) {
            instancia = new ManejadorGenero();
        }
        return instancia;
    }

    //Me devulve el genero de la lista de todos los generos del sistema
   // public Genero Obtengogenero(String nombregen) {
    //    for (int i = 0; i < Todosgeneros.size(); i++) {
    //        Genero g = Todosgeneros.get(i);
    //        if (g.getNombre().equalsIgnoreCase(nombregen)) {
    //            return g;
    //        }
    //    }
    //    return null;
    //}

    public DefaultMutableTreeNode ObtengoNodoRaiz() {
        return ArbolGenero;
    }

    public DefaultMutableTreeNode EncuentroGenero(String nombreGenero) {
        return BuscoNodoRecursi(ArbolGenero, nombreGenero);
    }

    public boolean EncuentroGenerobool(String nombreGenero) {
        if (BuscoNodoRecursi(ArbolGenero, nombreGenero) == null) {
            return true;
        } else {
            return false;
        }
    }

    public DefaultMutableTreeNode BuscoNodoRecursi(DefaultMutableTreeNode Nodo, String nombreGenero) {
        if (Nodo.toString().equalsIgnoreCase(nombreGenero)) {//Si el nodo actual coincide con el nombre que estás buscando, se devuelve este nodo y se termina la búsqueda.
            return Nodo;
        }
        for (int i = 0; i < Nodo.getChildCount(); i++) {// Nodo.getchildcount devuelve el número de hijos que tiene el nodo actual. Si no tiene hijos, el método for no se ejecutará.
            DefaultMutableTreeNode hijo = (DefaultMutableTreeNode) Nodo.getChildAt(i);//Obtiene el hijo en la posición i del nodo actual este hijo lo guardo en la variable child
            DefaultMutableTreeNode resultado = BuscoNodoRecursi(hijo, nombreGenero);//Se llama a si misma la funcion pero ahora con el nodo hijo
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }

    public boolean esvacio() {
        if (ArbolGenero == null) {
            return false;
        }
        return true;
    }
    
    
     public List<Genero> obtengoListaGenero() {
        List<Genero> generos = man.createQuery("select g from Genero g", Genero.class).getResultList();
        return generos;
    }

    public DefaultMutableTreeNode obtengoarbolbasedatos() {
        List<Genero> generos = man.createQuery("select g from Genero g", Genero.class).getResultList();
        if (generos == null) {
            return this.ArbolGenero;
        } else {
            this.construirArbol(generos);
            return this.ArbolGenero;
        }
    }

    
    public Genero Existegenbasedatoss(String nombre){
        
        Genero Gen = man.find(Genero.class, nombre);
        
            return Gen;
        
    }
    
    public void eliminopornombrepadre(String Generoelimino){
        
        man.getTransaction().begin();
        String referenciaMayus = Generoelimino.toUpperCase();
        String pregun = ("DELETE FROM Genero g WHERE UPPER(g.nombrepapa) = :nombrepadre");
        
        Query consu = man.createQuery(pregun);
        consu.setParameter("nombrepadre", referenciaMayus);
        int total = consu.executeUpdate();
        man.getTransaction().commit();
        System.out.println("Rengoles actualizados" + total);
    }
    public void remuevoGenero(String GeneroElimino) {   
        this.remuevoGenerobasesdatos(GeneroElimino);
        this.eliminopornombrepadre(GeneroElimino);
        DefaultMutableTreeNode nodoelimin = EncuentroGenero(GeneroElimino);
        nodoelimin.removeFromParent();     
    }

public void remuevoGenerobasesdatos(String Nombre) {
        man.getTransaction().begin();
        String referenciaMayus = Nombre.toUpperCase();
        String cuestion = ("DELETE FROM Genero g WHERE UPPER(g.nombre) = :Nombre");
        Query consulta = man.createQuery(cuestion);
        consulta.setParameter("Nombre",referenciaMayus);
        int total = consulta.executeUpdate();
        man.getTransaction().commit();
        System.out.println("Rengoles actualizados" + total);
    }

    public boolean AñadoGenerobasedatos(Genero ge) {
        //JOptionPane.showMessageDialog(null, "llegue1");
        try {
            man.getTransaction().begin();
            man.persist(ge);
            man.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Uno de los campos que quiere añadir ya estan ingresados en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Seteopadrenull();
        return true;
    }

    public void AñadoGenero(String nombreGenero, DefaultMutableTreeNode nodopadre) {
        String namepapa = (String) nodopadre.getUserObject();
        Genero g = new Genero(nombreGenero, namepapa);
        boolean persistencia = AñadoGenerobasedatos(g);
        if (persistencia == true) {
            DefaultMutableTreeNode NuevoNodo = new DefaultMutableTreeNode(g.getNombre());
            nodopadre.add(NuevoNodo);
     //       Todosgeneros.add(g);
        }
    }

    public boolean eshijode(DefaultMutableTreeNode nodohijo, DefaultMutableTreeNode nodopadre) {
        for (int i = 0; i < nodopadre.getChildCount(); i++) {
            if (nodopadre.getChildAt(i).equals(nodohijo)) {
                return true;
            }
        }
        return false;
    }

    public void lepongopadre(DefaultMutableTreeNode nodohijo, DefaultMutableTreeNode nodopapa) {
        nodopapa.add(nodohijo);
    }

    public void pongopadre(String nompapa, String nombre){
        man.getTransaction().begin();
        String cuestion = ("Update Genero g set g.nombrepapa ='"+nompapa+"' where g.nombre ='"+nombre+"'");
         int total = man.createQuery(cuestion).executeUpdate();
        System.out.println("Rengoles actualizados" + total);
        man.getTransaction().commit();
    }
    
    public void Seteopadrenull() {
        man.getTransaction().begin();
        String cuestion = ("update Genero g set g.nombrepapa=null where g.nombrepapa = 'Generos'");
        int total = man.createQuery(cuestion).executeUpdate();
        System.out.println("Rengoles actualizados" + total);
        man.getTransaction().commit();
    }

    //Metodo para construir un arbol a partir de una lista de generos
    public void construirArbol(List<Genero> generos) {
        Map<String, DefaultMutableTreeNode> TodosNodos = new HashMap<>();
        for (int i = 0; i < generos.size(); i++) {//Genero todos los generos como nodo de arbol y despues los que no tienen padre les asigro como padre el nodo Generos
            Genero genero = generos.get(i);
            DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(genero.getNombre());
            TodosNodos.put(genero.getNombre(), nodo);
  //          Todosgeneros.add(genero);
            if (genero.getNombrepapa() == null) {
                if (EncuentroGenerobool(genero.getNombre()) == true) {
                    this.ArbolGenero.add(nodo);
                } else {
                    nodo = null;
                }
            }
        }
        for (int i = 0; i < generos.size(); i++) {//Conecto todos los generos con sus respectivos padres
            Genero genero = generos.get(i);
            DefaultMutableTreeNode nodo = TodosNodos.get(genero.getNombre());
            String nombrePadre = genero.getNombrepapa();

            if (nombrePadre != null) {
                DefaultMutableTreeNode nodopadre = TodosNodos.get(nombrePadre);
                if (nodopadre != null) {
                    nodopadre.add(nodo);
                }
            }
        }
    }
    
     public List<Genero> DevuelveListaArbol() {
        List<Genero> generos = man.createQuery("select g from Genero g", Genero.class).getResultList();
        return generos;
    }
    
    public Genero obtenerGeneroPorNombre(String nombre) {
        try {
            String consulta = "select g from Genero g where g.nombre = :nombre";
            Query query = man.createQuery(consulta);
            query.setParameter("nombre", nombre);
            return (Genero) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
