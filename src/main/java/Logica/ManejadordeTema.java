//package Logica;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//public class ManejadordeTema {
//    
//     private EntityManagerFactory emf;
//    private EntityManager em;
//    private EntityTransaction t;
//    private static ManejadordeTema instancia = null;
//    
//    private ManejadordeTema() {
//       emf = Persistence.createEntityManagerFactory("EspotifyBD");
//        em = emf.createEntityManager();
//        t = em.getTransaction(); //se usa para las consultas y commits/rollbacks
//    }
//
//    public static ManejadordeTema getinstance() {
//        if (instancia == null)
//            instancia = new ManejadordeTema();
//        return instancia;
//    }
//    
//     public void addTema(Tema T) {
//         try {
//            t.begin();
//            em.persist(T);
//            t.commit();
//        } catch (Exception e) {
//            //si sale mal rollback
//            t.rollback();
//        String nomTema = T.getNombre();
//        nombreTema.put(nomTema, T);
//    }
//    
////    public Tema obtenerTema(String nomTema) {
////        return ((Tema) nombreTema.get(nomTema));
////    }
//     
//    //ADAPTAR EL CODIGO ADECUADAMENTE
////    public  Tema AltaTema(String nombre, int Duracion){
////    Tema t = new Tema(nombre,Duracion);
////    return t;
////    
////    }
//    
//     public Tema[] getTemas() {
//        if (nombreTema.isEmpty())
//            return null;
//        else {
//            Collection<Tema> tem = nombreTema.values();
//            Object[] o = tem.toArray();
//            Tema[] temas = new Tema[o.length];
//            for (int i = 0; i < o.length; i++) {
//                temas[i] = (Tema) o[i];
//            }
//
//            return temas;
//        }
//    }
//    
//    public Tema obtenerTema(String referencia) {
//             Tema Tem = em.find(Tema.class, referencia);
//        return Tem;
//    }
//     
//    public  Tema AltaTema(String referencia, String nombre, String Duracion){
//        Tema t = new Tema(referencia, nombre,Duracion);
//    
//             return t;
//    
//    }
//    
//     public List<Tema> getTemas() {
//            
//             List<Tema> temas = em.createQuery("select t from Tema t", Tema.class).getResultList();
//            
//        return temas;
//    }
//    
//}
