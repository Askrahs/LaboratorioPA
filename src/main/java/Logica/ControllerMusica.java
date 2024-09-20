package Logica;

import Excepciones.*;
import java.util.List;
import LogicaDTO.*;
import Excepciones.GenroYaExiste;
import java.util.ArrayList;
import Persistencia.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;


public class ControllerMusica implements IControllerMusica {
    public ControllerMusica() {}       
    ControllerPersistencia cPersist = new ControllerPersistencia();
    @Override
    public void AltaGenero (String refe, String nombregen, String nombrepadre) throws GenroYaExiste{    
        ManejadorGenero mg= ManejadorGenero.getInstance();        
        if(mg.EncuentroGenerobool(nombregen)==true){//chequeo si el genero existe
           // JOptionPane.showMessageDialog(null,"llegue1");
           if(nombrepadre.isEmpty()){
               DefaultMutableTreeNode Generoall = mg.ObtengoNodoRaiz();
                mg.AñadoGenero(refe, nombregen,Generoall);
               Generoall=null;                 
           }else{
            if(mg.EncuentroGenerobool(nombrepadre)==true){//Si no existe genero padre lo creo, poniendo por default al padre como el nodo Generos              
                DefaultMutableTreeNode Generoall = mg.ObtengoNodoRaiz();
                mg.AñadoGenero(refe, nombregen,Generoall);//Creo el genero padre
            }
            DefaultMutableTreeNode nodopadre = mg.EncuentroGenero(nombrepadre);//Creo una variable DefaultMutableTreeNode que va a señar al nodo padre del nodo nuevo que quiero crear
            mg.AñadoGenero(refe, nombregen,nodopadre);//Creo el nuevo genero y lo añado al arbol;
            JOptionPane.showMessageDialog(null, "Se Creo el genero Correctamente"); 
           }
        }else{
            if(nombrepadre == null){
            //JOptionPane.showMessageDialog(null,"llegue2");
            if(mg.EncuentroGenerobool(nombrepadre)==true){//Verifico si el genero padre existe
                //JOptionPane.showMessageDialog(null,"llegue3");
                 DefaultMutableTreeNode Generoall = mg.ObtengoNodoRaiz();
                mg.AñadoGenero(refe, nombregen,Generoall);//Creo el genero padre
                DefaultMutableTreeNode Generoexis = mg.EncuentroGenero(nombregen);
                DefaultMutableTreeNode Generopapa = mg.EncuentroGenero(nombrepadre);
                if(mg.eshijode(Generoexis,Generopapa)!=true){//verifico si es el hijo
                mg.lepongopadre(Generoexis,Generopapa);
                 JOptionPane.showConfirmDialog(null, "Se Añado al padre Correctamente");           
                }     
            }else{
                //JOptionPane.showMessageDialog(null,"llegue4");
                DefaultMutableTreeNode Generoexis = mg.EncuentroGenero(nombregen);
                DefaultMutableTreeNode Generopapa = mg.EncuentroGenero(nombrepadre);
                if(mg.eshijode(Generoexis,Generopapa)!=true){//verifico si es el hijo
                mg.lepongopadre(Generoexis,Generopapa);
                JOptionPane.showConfirmDialog(null, "Se Añado al padre Correctamente");
                }else{
                    JOptionPane.showConfirmDialog(null, "Este nodo ya es hijo");   
                }
            }
            }
            throw new GenroYaExiste("El genero ya existe");
        }
}
    
    @Override
       public  void ModificoPadre(String nombrenodo, String nombrepadrenuevo){
           ManejadorGenero man = ManejadorGenero.getInstance();
           JOptionPane.showMessageDialog(null, "llegue0");
           if(man.EncuentroGenerobool(nombrepadrenuevo)!=true){
               JOptionPane.showMessageDialog(null, "llegue1");
               if(man.EncuentroGenerobool(nombrenodo)!=true){
                   JOptionPane.showMessageDialog(null, "llegue2");
                   DefaultMutableTreeNode nod = man.EncuentroGenero(nombrenodo);
                   DefaultMutableTreeNode nodpapi = man.EncuentroGenero(nombrepadrenuevo);
                   man.lepongopadre(nod, nodpapi);
               }
           }else{
               try {
                   throw new GenroYaExiste("El Genero " + nombrepadrenuevo + " no esta ingresado");
               } catch (GenroYaExiste ex) {
                   Logger.getLogger(ControllerMusica.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }   
       
    @Override
    public DefaultMutableTreeNode DameTodoslosgeneros(){
        ManejadorGenero mg = ManejadorGenero.getInstance();
        mg.obtengoarbolbasedatos();           
        return mg.ObtengoNodoRaiz();
    }
   
    @Override
    public void EliminoGenero(String nombregen, String refe){
        ManejadorGenero mg= ManejadorGenero.getInstance();
        if(mg.EncuentroGenerobool(nombregen)!=true){
            mg.remuevoGenero(nombregen, refe);
        }else{
            try {
              throw new GenroYaExiste("El Genero " + nombregen + " no esta registrado");
          } catch (GenroYaExiste ex) {
             Logger.getLogger(ControllerMusica.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }   
    
    @Override
     public void altaAlbum(DTOAlbum albumDTO, Set<DTOTema> temas) throws AlbumYaExisteException, UsuarioNoExisteException{       
        ManejadorUsuario mart = ManejadorUsuario.getinstance();
        Artista art = mart.obtenerArtista(albumDTO.getArtista());
        Set<Genero> generosAlb;
        generosAlb = cargarSetGeneros(albumDTO.getGeneros());
        if (art == null){
            throw new UsuarioNoExisteException("El Artista " + albumDTO.getArtista() + " no esta registrado");
        } 
        Set<Tema> temasAlb = new HashSet<>();
        Album alb = new Album(art, albumDTO.getTitulo(), generosAlb, albumDTO.getAnio(), null, albumDTO.getRutaImagen());
        for(DTOTema dtoTema : temas){
            Tema nuevoTema = new Tema(dtoTema.getNombre(), dtoTema.getDuracion(), dtoTema.getEnlace(), dtoTema.getPosicion(), alb);
            temasAlb.add(nuevoTema);
        }
        alb.setTemas(temasAlb);
        try {
            cPersist.altaAlbum(alb);
        } catch (Exception ex) {
            Logger.getLogger(Logica.ControllerMusica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }         
    
     @Override
     //A la espera de la otra parte del codigo
    public void altaListaReproduccion(String nombre, String genero, String duenio, String ruta, boolean privada) throws ListaYaExisteException{
       //JOptionPane.showMessageDialog(null,"llegue2");
        ManejadorLista ml = ManejadorLista.getInstance();
        ManejadorGenero mangen =ManejadorGenero.getInstance();
        ManejadorUsuario usrman = ManejadorUsuario.getinstance();
        //( String nombre, String rutaImagen, Boolean estado, Genero genero, Usuario duenio)
        //JOptionPane.showMessageDialog(null,"llegue097");
       // JOptionPane.showMessageDialog(null,"Nombre ingresado: "+nombre);
        Lista los = ml.ExisteLista(nombre);
       // JOptionPane.showMessageDialog(null,"llegue323");
        if(los==null){//si existe lista
           // JOptionPane.showMessageDialog(null,"llegue3");
            if(genero.isEmpty()){
           
                if(usrman.obtenerUsuario(duenio)!=null){//si usuario existe
                   //JOptionPane.showMessageDialog(null,"llegue5");
                    ml.creolista(nombre, genero, duenio,ruta,privada);
               // JOptionPane.showMessageDialog(null,"llegue4");
            }
            }else{
                Genero gen = mangen.Existegenbasedatoss(genero);
                 if(gen!=null){ //si es false existe
                 //   JOptionPane.showMessageDialog(null,"llegue6");
                     ml.creolista(nombre, genero, duenio,ruta, privada);
                 }else{
                    JOptionPane.showMessageDialog(null,"Genero no existe"); 
                 }
             }
            }else{
        JOptionPane.showMessageDialog(null,"Lista ya existe");
        }
    } 

    @Override
    public void publicarLista(String nombreUsuario, String nombreLista) throws UsuarioNoExisteException, ListaNoexisteException, OperacionNoPermitidaException, ListaYaEsPublicaException {
        //( ͡❛ ͜ʖ͡❛ )
    ManejadorUsuario manejadorU = ManejadorUsuario.getinstance();
    Usuario usuario = manejadorU.obtenerUsuario(nombreUsuario);
    ManejadorLista Ml = ManejadorLista.getInstance();
    Lista lista = Ml.ExisteLista(nombreLista);
    if (usuario == null || !(usuario instanceof Cliente)) {
        throw new UsuarioNoExisteException("El usuario " + nombreUsuario + " no existe o no es un cliente.");
    }

    if (lista == null) {
        throw new ListaNoexisteException("La lista " + nombreLista + " no existe.");
    }    
    //Verificar si el cliente es el propietario de la lista
    if (lista.getDuenio().getNombre() != usuario.getNombre()) {
        throw new OperacionNoPermitidaException("El usuario seleccionado no es propietario de dicha lista.");
    }
    if (!lista.getEsPrivada()) {
        throw new ListaYaEsPublicaException("La lista " + nombreLista + " ya es pública.");
    }else{
        // Hacer pública la lista de reproducción
        Ml.publicolista(false, lista);  
    }
    } 

    @Override
    public Set<Genero> cargarSetGeneros(Set<String> generos) {
        ManejadorGenero mg = ManejadorGenero.getInstance();  
        Set<Genero> setGeneros = new HashSet<>();
       for(String nombreGenero : generos){
           Genero genero = mg.obtenerGeneroPorNombre(nombreGenero);
           if(genero != null){
               setGeneros.add(genero);
           }
       }
       return setGeneros; 
    } 
    
    @Override
    public List<String> obtenerAlbumsPorGenero(String generoSeleccionado){
        return cPersist.obtenerAlbumsPorGenero(generoSeleccionado);
    }   

    @Override
    public List<String> obtenerAlbumsPorArtista(String artistaSeleccionado){   
        return cPersist.obtenerAlbumsPorArtista(artistaSeleccionado);
    }
    
    @Override
    public  DTOAlbum consultaAlbumPorTitulo(String albumSeleccionado){
        Album a = cPersist.consultaAlbumPorTitulo(albumSeleccionado);
        Set<String> generosString = new HashSet<>();
        Set<DTOTema> tDTO = new HashSet<>();
        for(Genero gen : a.getGeneros()){
            generosString.add(gen.getNombre());
        }
        for(Tema tem : a.getTemas()){
            //DTOTema(String nombre, String duracion, String enlace, int posicion)
            DTOTema nuevoTDTO = new DTOTema(tem.getNombre(), tem.getDuracion(), tem.getEnlace(), tem.getPosicion());
            tDTO.add(nuevoTDTO);
        }       
        DTOAlbum aDTO = new DTOAlbum(a.getTitulo(), a.getAnio(), a.getRutaImagen(), a.getArtista().getNickname(), generosString, tDTO);
        return aDTO;
    }

    @Override
    public  List <DTOGenero> Datageneros(){
        ManejadorGenero mang = ManejadorGenero.getInstance();
        List <Genero> gen = mang.obtengoListaGenero();
        Genero genunoauno;
            List <DTOGenero> dtogeneros = new ArrayList<>();
            //JOptionPane.showMessageDialog(null,"llegue4");
            for (int i = 0; i<gen.size();i++){
                genunoauno = gen.get(i);
                DTOGenero dagenero = new DTOGenero(genunoauno.getRef(),genunoauno.getNombre(),genunoauno.getNombrepapa());
                dtogeneros.add(dagenero);
            }
             return dtogeneros;   
    } 
    
    @Override
    //Usado para control de AltaAlbum
    public boolean existeAlbum(String nicknameArtista, String titulo){      
        return cPersist.existeAlbum(nicknameArtista, titulo);
    }
    
    @Override
    public void AñadotemalistaAlbum(String nombreAlbum, String nombreLista, String nombreTema, String nombreUsuario){
         Album a = cPersist.consultaAlbumPorTitulo(nombreAlbum);
         ManejadorUsuario usr = ManejadorUsuario.getinstance();
         
        ManejadorLista L = ManejadorLista.getInstance();
        Lista lo =L.ExisteLista(nombreLista);
        Cliente C = usr.obtenerCliente(nombreUsuario);
        Usuario U = lo.getDuenio();
        if(C instanceof Cliente){
            if(C == U){
        if(lo==null){
            JOptionPane.showMessageDialog(null,"Lista no existe");
            return;
        }
        Tema iteratema;
        Lista lis = L.ExisteLista(nombreLista);
        List<Tema> temaslista = lis.getTemas();
        Set<Tema> lostemas = a.getTemas();
        Iterator <Tema> iterador = lostemas.iterator();
        
       
        Tema t;
        while(iterador.hasNext()){
            
            t = iterador.next();
            if(t.getNombre().equalsIgnoreCase(nombreTema)){//cheque el nombre tema en el album
               // JOptionPane.showMessageDialog(null,"ENTRE AL if");
               if(temaslista.isEmpty()){
                   L.aniadotemalista(nombreLista, t);
                   return;
                 }else{
                   for (int i = 0;i<temaslista.size();i++){//Me fijo tema por tema dentro de los temas de la lista
                       iteratema = temaslista.get(i);
                       if(iteratema.getNombre().equalsIgnoreCase(nombreTema)){
                           //retorna que ya existe
                            JOptionPane.showMessageDialog(null,"Tema ya existe");
                            return;
                       }
                   }
                   L.aniadotemalista(nombreLista, t);
                   JOptionPane.showMessageDialog(null,"Tema Añadido con exito");
            }
        }
    }        
            }else{
                JOptionPane.showMessageDialog(null,"el nombre usuario que paso no es el dueño de la lista");
            }
        }else{
            JOptionPane.showMessageDialog(null,"El usuario no es cliente");
        }
        
    }
    
    @Override
    public List<DTOLista> Obtengolistasconduenio()throws NoExisteLista{
           //JOptionPane.showMessageDialog(null,"llegue2");
            ManejadorLista man= ManejadorLista.getInstance();
            Lista losta;
            List <Lista> lista;
            lista = man.todaslistasconduenio();          
            List <DTOLista> dtolista = new ArrayList<>();
            //JOptionPane.showMessageDialog(null,"llegue4");
            for (int i = 0; i<lista.size();i++){
                losta = lista.get(i);
                DTOLista datolista = new DTOLista(losta.getNombre());
                dtolista.add(datolista);
            }     
             return dtolista;          
        }
    
                  
    @Override
    public List<DTOLista> Obtengolistassinduenio()throws NoExisteLista{
           //JOptionPane.showMessageDialog(null,"llegue2");
            ManejadorLista man= ManejadorLista.getInstance();
            Lista losta;
            List <Lista> lista;
            lista = man.todaslistassinduenio();          
            List <DTOLista> dtolista = new ArrayList<>();
            //JOptionPane.showMessageDialog(null,"llegue4");
            for (int i = 0; i<lista.size();i++){
                losta = lista.get(i);
                DTOLista datolista = new DTOLista(losta.getNombre());
                dtolista.add(datolista);
            }     
             return dtolista;          
        }
             
    @Override
    public List<DTOLista> Obtengolistas()throws NoExisteLista{
           //JOptionPane.showMessageDialog(null,"llegue2");
            ManejadorLista man= ManejadorLista.getInstance();
            Lista losta;
            List <Lista> lista;
            lista = man.todaslistas();          
            List <DTOLista> dtolista = new ArrayList<>();
            //JOptionPane.showMessageDialog(null,"llegue4");
            for (int i = 0; i<lista.size();i++){
                losta = lista.get(i);
                DTOLista datolista = new DTOLista(losta.getNombre());
                dtolista.add(datolista);
            }     
             return dtolista;          
        }
    
    @Override
    public List<DTOLista> ObtengolistasPUBLICAS() throws NoExisteLista {
        ManejadorLista man = ManejadorLista.getInstance();
        List<Lista> lista = man.todaslistaspublica();
        List<DTOLista> dtolista = new ArrayList<>();
        for (Lista losta : lista) {
            DTOLista datolista = new DTOLista(losta.getNombre());
            dtolista.add(datolista);
        }
    return dtolista;
    }

    
    @Override
    public void aniadoTemaListaPublica(String nombreLista, String nombreTema){
        JOptionPane.showMessageDialog(null,"llegue1");
        Tema tem = cPersist.findTemaPorNombre(nombreTema);
        Tema iteratem;
        ManejadorLista manlis = ManejadorLista.getInstance();
        Lista lis = manlis.ExisteLista(nombreLista);
        List <Tema> temos = lis.getTemas();
        if(lis!=null){
            if(lis.getDuenio()==null){
            if(lis.getEsPrivada()!=true){
                // JOptionPane.showMessageDialog(null,"llegue2");
                if(temos.isEmpty()){
                    // JOptionPane.showMessageDialog(null,"llegue3");
                    manlis.aniadotemalista(nombreLista, tem);
                    JOptionPane.showMessageDialog(null,"Tema Añadido con exito");
                }else{
                    for(int i = 0; i<temos.size();i++){
                       iteratem = temos.get(i);
                       if(iteratem.getNombre().equalsIgnoreCase(nombreTema)){
                           //retorna que ya existe
                            JOptionPane.showMessageDialog(null,"Tema ya existe");
                            return;
                       }
                    }
                    manlis.aniadotemalista(nombreLista, tem);
                    JOptionPane.showMessageDialog(null,"Tema Añadido con exito");
                    return;
                }
            }else{
            JOptionPane.showMessageDialog(null,"Lista no es publica");
            return;
            }
            }else{
                JOptionPane.showMessageDialog(null,"La lista no es por defecto tiene dueño");
            }
        }else{
         JOptionPane.showMessageDialog(null,"Lista no existe");
        }
    }
    
    @Override
    public void EliminotemaLista(String nombreLista, String nombreTema){
        JOptionPane.showMessageDialog(null,"llegue1");
        Tema tem = cPersist.findTemaPorNombre(nombreTema);
        Tema iteratem;
        ManejadorLista manlis = ManejadorLista.getInstance();
        Lista lis = manlis.ExisteLista(nombreLista);
        List <Tema> temos = lis.getTemas();
        if(lis!=null){
            if(lis.getDuenio()==null){
            if(lis.getEsPrivada()!=true){
                // JOptionPane.showMessageDialog(null,"llegue2");
                if(temos.isEmpty()){
                    // JOptionPane.showMessageDialog(null,"llegue3");
                    JOptionPane.showMessageDialog(null,"No hay Temas en la lista");
                    return;
                }else{
                    for(int i = 0; i<temos.size();i++){
                       iteratem = temos.get(i);
                       if(iteratem.getNombre().equalsIgnoreCase(nombreTema)){
                           //retorna que ya existe
                            manlis.Eliminotemalista(nombreLista, tem);
                            return;
                       }
                    }
                    
                    JOptionPane.showMessageDialog(null,"No existe el tema");
                    return;
                }
            }else{
            JOptionPane.showMessageDialog(null,"Lista no es publica");
            return;
            }
            }else{
                JOptionPane.showMessageDialog(null,"La lista no es por defecto tiene dueño");
            }
        }else{
         JOptionPane.showMessageDialog(null,"Lista no existe");
        }
    }
    
    @Override
     public void EliminoTemaListaConduenio(String nombreUsuario,String nombreLista,String nombreTema){
         Tema tem = cPersist.findTemaPorNombre(nombreTema);
        Tema iteratem;
        ManejadorLista manlis = ManejadorLista.getInstance();
        Lista lis = manlis.ExisteLista(nombreLista);
        List <Tema> temos = lis.getTemas();
        ManejadorUsuario USR = ManejadorUsuario.getinstance();
        Cliente Cli = USR.obtenerCliente(nombreUsuario);
        if(tem!=null){
        if(Cli!=null){
        if(lis!=null){
            if(lis.getDuenio().getNombre().equalsIgnoreCase(Cli.getNombre())){
                if(lis.getEsPrivada()!=true){
                    // JOptionPane.showMessageDialog(null,"llegue2");
                    if(temos.isEmpty()){
                        // JOptionPane.showMessageDialog(null,"llegue3");
                        JOptionPane.showMessageDialog(null,"la lista esta vacia");
                    }else{
                        for(int i = 0; i<temos.size();i++){
                            iteratem = temos.get(i);
                            if(iteratem.getNombre().equalsIgnoreCase(nombreTema)){
                                manlis.Eliminotemalista(nombreLista, tem);
                                JOptionPane.showMessageDialog(null,"Tema eliminado con exito");
                                return;
                            }
                        }
                        JOptionPane.showMessageDialog(null,"No se encontro el tema");
                        return;
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Lista no es publica");
                    return;
                }
            }else{
                JOptionPane.showMessageDialog(null,"Ese no es el dueñio de la lista");
            }
        }else{
         JOptionPane.showMessageDialog(null,"Lista no existe");
        }
        }else{
             JOptionPane.showMessageDialog(null,"El suaurio ingresado no es un cliente");
        }
        }else{
          JOptionPane.showMessageDialog(null,"El tema no existe");  
    }
     }
    @Override
    public void aniadoTemaListaConduenio(String nombreUsuario,String nombreLista,String nombreTema){
       //JOptionPane.showMessageDialog(null,"llegue1");
        Tema tem = cPersist.findTemaPorNombre(nombreTema);
        Tema iteratem;
        ManejadorLista manlis = ManejadorLista.getInstance();
        Lista lis = manlis.ExisteLista(nombreLista);
        List <Tema> temos = lis.getTemas();
        ManejadorUsuario USR = ManejadorUsuario.getinstance();
        Cliente Cli = USR.obtenerCliente(nombreUsuario);
        if(tem!=null){
        if(Cli!=null){
        if(lis!=null){
            if(lis.getDuenio().getNombre().equalsIgnoreCase(Cli.getNombre())){
                if(lis.getEsPrivada()!=true){
                    // JOptionPane.showMessageDialog(null,"llegue2");
                    if(temos.isEmpty()){
                        // JOptionPane.showMessageDialog(null,"llegue3");
                        manlis.aniadotemalista(nombreLista, tem);
                        JOptionPane.showMessageDialog(null,"Tema Añadido con exito");
                    }else{
                        for(int i = 0; i<temos.size();i++){
                            iteratem = temos.get(i);
                            if(iteratem.getNombre().equalsIgnoreCase(nombreTema)){
                                //retorna que ya existe
                                JOptionPane.showMessageDialog(null,"Tema ya existe");
                                return;
                            }
                        }
                        manlis.aniadotemalista(nombreLista, tem);
                        JOptionPane.showMessageDialog(null,"Tema Añadido con exito");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Lista no es publica");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Ese no es el dueñio de la lista");
            }
        }else{
         JOptionPane.showMessageDialog(null,"Lista no existe");
        }
        }else{
             JOptionPane.showMessageDialog(null,"El suaurio ingresado no es un cliente");
        }
        }else{
          JOptionPane.showMessageDialog(null,"El tema no existe");  
    }
    }
   
    @Override
    public List <DTOTema> TemasdeListas(String nombrelista){
        //JOptionPane.showMessageDialog(null,"ENTRE 1");
        ManejadorLista manlis = ManejadorLista.getInstance();
        List <Tema> temos = manlis.temasdelalista(nombrelista);
         //  JOptionPane.showMessageDialog(null,"ENTRE 2");
            
            Tema tem;
            List <DTOTema> dtotema = new ArrayList<>();
            //JOptionPane.showMessageDialog(null,"llegue4");
            for (int i = 0; i<temos.size();i++){
                tem = temos.get(i);
                DTOTema datotemo = new DTOTema(tem.getNombre(),tem.getDuracion(),tem.getEnlace(),tem.getPosicion());
                dtotema.add(datotemo);
            }     
             return dtotema;          
        }
    
    @Override
    public  List<DTOAlbum> ObtengoAlbums(){
        List <Album> Albumes = cPersist.Todoslosalbums();
        
        Album alb;
            List <DTOAlbum> dtoalbum = new ArrayList<>();
            //JOptionPane.showMessageDialog(null,"llegue4");
            for (int i = 0; i<Albumes.size();i++){
                alb = Albumes.get(i);
                DTOAlbum datoalbu = new DTOAlbum (alb.getTitulo(),alb.getAnio());
                dtoalbum.add(datoalbu);
            }     
             return dtoalbum;   
    }
    
    @Override
    public  List<DTOTema> ObtengoTemasdeAlbum(String nombreAlbum){
       //JOptionPane.showMessageDialog(null,"LLEGUE 1");
        List <Tema> temos = cPersist.ObtengotemaPorAlbum(nombreAlbum);
         Tema tem;
            List <DTOTema> dtotema = new ArrayList<>();
            //JOptionPane.showMessageDialog(null,"llegue4");
            for (int i = 0; i<temos.size();i++){
                tem = temos.get(i);
                DTOTema datotemo = new DTOTema(tem.getNombre(),tem.getDuracion(),tem.getEnlace(),tem.getPosicion());
                dtotema.add(datotemo);
            }     
             return dtotema;          
    }
    
    @Override
    public List<String> obtenerListaPorGenero(String generoSeleccionado){
        return cPersist.obtenerListaPorGenero(generoSeleccionado);
    }   

    @Override
    public List<String> obtenerListaPorCliente(String clienteseleccionado){   
        return cPersist.obtenerListaPorCliente (clienteseleccionado);
    }
    
    @Override
    public DTOLista consultaListaPorTitulo(String listaSeleccionada) {
    Lista l = cPersist.consultaListaPorTitulo(listaSeleccionada);

    List<DTOTema> tDTO = new ArrayList<>();
    for (Tema tem : l.getTemas()) {
        DTOTema nuevoTDTO = new DTOTema(tem.getNombre(), tem.getDuracion(), tem.getEnlace(), tem.getPosicion());
        tDTO.add(nuevoTDTO);
    }

    DTOLista lDTO;
    if (l.getEsPrivada()) {
        lDTO = new DTOLista(l.getNombre(), l.getDuenio().getNickname(), tDTO);
    } else {
        lDTO = new DTOLista(l.getNombre(), l.getRutaImagen(), l.getGenero(), tDTO);
    }
    
    return lDTO;
    
    }
    
    @Override
    public DTOLista consultaListaPorTituloyGenero(String listaSeleccionada, String genero) {
    Lista l = cPersist.consultaListaPorTituloyGenero(listaSeleccionada, genero);

    List<DTOTema> tDTO = new ArrayList<>();
    for (Tema tem : l.getTemas()) {
        DTOTema nuevoTDTO = new DTOTema(tem.getNombre(), tem.getDuracion(), tem.getEnlace(), tem.getPosicion());
        tDTO.add(nuevoTDTO);
    }

    DTOLista lDTO;
    lDTO = new DTOLista(l.getNombre(), l.getRutaImagen(), l.getGenero(), tDTO);
    return lDTO;
    
    }
    
    @Override
    public List<DTOTema> obtenerTemitasfavCliente(String nickname) {
    List<Tema> temas = cPersist.obtenerTemasFavoritosDeCliente(nickname);
    List<DTOTema> dtoTemas = new ArrayList<>();

    for (Tema t : temas) {
        // String nombre, String duracion, String enlace, int posicion
        DTOTema dtoTema = new DTOTema(t.getNombre(), t.getDuracion(), t.getEnlace(), t.getPosicion());
        dtoTemas.add(dtoTema);
    }
    return dtoTemas;            
}

    @Override
    public List<DTOTema> obtenerTemitas() {
    List<Tema> temas = cPersist.findTemitas();
    List<DTOTema> dtoTemas = new ArrayList<>();

    for (Tema t : temas) {
        DTOTema dtoTema = new DTOTema(t.getNombre(), t.getDuracion(), t.getEnlace(), t.getPosicion());
        dtoTemas.add(dtoTema);
    }
    return dtoTemas;            
} 

    @Override
    public List<DTOLista> obtenerListitas() {
    List<Lista> listas = cPersist.findListas();
    List<DTOLista> dtoListas = new ArrayList<>();

    for (Lista l : listas) {
        //String nombre, String rutaImagen, String generoOCreador)
        DTOLista dtoLista = new DTOLista(l.getNombre(), l.getRutaImagen(), l.getGenero().getNombre());
        dtoListas.add(dtoLista);
    }
    return dtoListas;            
}

    @Override
    public List<DTOLista> obtenerListitasfavCliente(String nickname) {
    List<Lista> listas = cPersist.obtenerListasFavoritasDeCliente(nickname);
    List<DTOLista> dtoListas = new ArrayList<>();

    for (Lista l : listas) {
        // Crear el DTO con los datos de la lista favorita
        DTOLista dtoLista = new DTOLista(l.getNombre(), l.getRutaImagen(), l.getGenero().getNombre());
        dtoListas.add(dtoLista);
    }
    return dtoListas;            
}

    @Override
    public List<DTOAlbum> obtenerAlbums() {
    List<Album> albums = cPersist.findAlbums();
    List<DTOAlbum> dtoAlbums = new ArrayList<>();

    for (Album a : albums) {
        //String titulo, int anio, String rutaImagen, String artista
        DTOAlbum dtoAlbum = new DTOAlbum(a.getTitulo(), a.getAnio(), a.getRutaImagen(), a.getArtista().getNickname());
        dtoAlbums.add(dtoAlbum);
    }
    return dtoAlbums;            
}

    @Override
    public List<DTOAlbum> obtenerAlbumsfavCliente(String nickname) {
    List<Album> albums = cPersist.obtenerAlbumsFavoritosDeCliente(nickname);
    List<DTOAlbum> dtoAlbums = new ArrayList<>();

    for (Album a : albums) {
        // Crear el DTO con los datos del álbum favorito
        DTOAlbum dtoAlbum = new DTOAlbum(a.getTitulo(), a.getAnio(), a.getRutaImagen(), a.getArtista().getNickname());
        dtoAlbums.add(dtoAlbum);
    }
    return dtoAlbums;            
}

    @Override
    public DTOTema consultaTemaPorTitulo(String temaSeleccionada){
    Tema t = cPersist.findTemaPorTitulo(temaSeleccionada);
    //( ͡❛ ͜ʖ͡❛ )
    DTOTema tDTO = new DTOTema(t.getNombre(), t.getDuracion(), t.getEnlace(), t.getPosicion());
    return tDTO;
    }
    }
 
