package Logica;

import Excepciones.*;
import LogicaDTO.*;
import Persistencia.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class ControllerMusica implements IControllerMusica {

    public ControllerMusica() {
    }

    ControllerPersistencia cPersist = new ControllerPersistencia();

    @Override
    public void AltaGenero(String nombregen, String nombrepadre) throws GenroYaExiste {
        ManejadorGenero mg = ManejadorGenero.getInstance();
        if (mg.EncuentroGenerobool(nombregen) == true) {// chequeo si el genero existe

            if (nombrepadre.isEmpty()) {
                DefaultMutableTreeNode Generoall = mg.ObtengoNodoRaiz();
                mg.AñadoGenero(nombregen, Generoall);
                Generoall = null;
            } else {
                if (mg.EncuentroGenerobool(nombrepadre) == true) {// Si no existe genero padre lo creo, poniendo por
                                                                  // default al padre como el nodo Generos

                    JOptionPane.showMessageDialog(null, "El nodo padre no existe");
                    return;

                }
                DefaultMutableTreeNode nodopadre = mg.EncuentroGenero(nombrepadre);// Creo una variable
                                                                                   // DefaultMutableTreeNode que va a
                                                                                   // señar al nodo padre del nodo nuevo
                                                                                   // que quiero crear

                mg.AñadoGenero(nombregen, nodopadre);// Creo el nuevo genero y lo añado al arbol;
                JOptionPane.showMessageDialog(null, "Se Creo el genero Correctamente");
            }
        } else {
            if (nombrepadre == null) {

                if (mg.EncuentroGenerobool(nombrepadre) == true) {// Verifico si el genero padre existe

                    DefaultMutableTreeNode Generoall = mg.ObtengoNodoRaiz();
                    mg.AñadoGenero(nombregen, Generoall);// Creo el genero padre
                    DefaultMutableTreeNode Generoexis = mg.EncuentroGenero(nombregen);
                    DefaultMutableTreeNode Generopapa = mg.EncuentroGenero(nombrepadre);
                    if (mg.eshijode(Generoexis, Generopapa) != true) {// verifico si es el hijo
                        mg.lepongopadre(Generoexis, Generopapa);
                        JOptionPane.showConfirmDialog(null, "Se Añado al padre Correctamente");
                    }
                } else {

                    DefaultMutableTreeNode Generoexis = mg.EncuentroGenero(nombregen);
                    DefaultMutableTreeNode Generopapa = mg.EncuentroGenero(nombrepadre);
                    if (mg.eshijode(Generoexis, Generopapa) != true) {// verifico si es el hijo
                        mg.lepongopadre(Generoexis, Generopapa);
                        JOptionPane.showConfirmDialog(null, "Se Añado al padre Correctamente");
                    } else {
                        JOptionPane.showConfirmDialog(null, "Este nodo ya es hijo");
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "El Genero ya existe");
            throw new GenroYaExiste("El genero ya existe");
        }
    }

   

    @Override
    public DefaultMutableTreeNode DameTodoslosgeneros() {
        ManejadorGenero mg = ManejadorGenero.getInstance();
        mg.obtengoarbolbasedatos();
        return mg.ObtengoNodoRaiz();
    }

    @Override
    public void EliminoGenero(String nombregen) {
        ManejadorGenero mg = ManejadorGenero.getInstance();
        if (mg.EncuentroGenerobool(nombregen) != true) {
            mg.remuevoGenero(nombregen);
        } else {
            try {
                throw new GenroYaExiste("El Genero " + nombregen + " no esta registrado");
            } catch (GenroYaExiste ex) {
                Logger.getLogger(ControllerMusica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void altaAlbum(DTOAlbum albumDTO, Set<DTOTema> temas)
            throws AlbumYaExisteException, UsuarioNoExisteException {
        ManejadorUsuario mart = ManejadorUsuario.getinstance();
        Artista art = mart.obtenerArtista(albumDTO.getArtista());
        Set<Genero> generosAlb;
        generosAlb = cargarSetGeneros(albumDTO.getGeneros());
        if (art == null) {
            throw new UsuarioNoExisteException("El Artista " + albumDTO.getArtista() + " no esta registrado");
        }
        Set<Tema> temasAlb = new HashSet<>();
        Album alb = new Album(art, albumDTO.getTitulo(), generosAlb, albumDTO.getAnio(), null,
                albumDTO.getRutaImagen());
        for (DTOTema dtoTema : temas) {
            Tema nuevoTema = new Tema(dtoTema.getNombre(), dtoTema.getDuracion(), dtoTema.getEnlace(),
                    dtoTema.getPosicion(), alb);
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
    // A la espera de la otra parte del codigo
    public void altaListaReproduccion(String nombre, String genero, String duenio, String ruta, boolean privada)
        throws ListaYaExisteException, GeneroNoExiste{

    ManejadorLista ml = ManejadorLista.getInstance();
    ManejadorGenero mangen = ManejadorGenero.getInstance();
    ManejadorUsuario usrman = ManejadorUsuario.getinstance();

    Lista los = ml.ExisteLista(nombre);

    // Verificar si la lista ya existe
    if (los == null) {
        
        // Verificar que el usuario existe
        if (usrman.obtenerCliente(duenio) != null) {
            
           

            // Crear la lista pasando `ruta`, que puede ser null si no se cargó una imagen
            ml.creolista(nombre, genero, duenio, ruta, privada);

        } else {
            Genero gen = null;

            // Verificar que el género existe si se especificó uno
            if (!genero.isEmpty()) {
                gen = mangen.Existegenbasedatoss(genero);
                if (gen == null) {
                     throw new GeneroNoExiste("El Genero no existe.");
                     
                }else{
                    ml.creolista(nombre, genero, duenio, ruta, privada);

                   
                }
            }
            
        }
    } else {
        throw new ListaYaExisteException("La Lista ya existe");
    }
}

    @Override
    public void publicarLista(String nombreUsuario, String nombreLista) throws UsuarioNoExisteException,
            ListaNoexisteException, OperacionNoPermitidaException, ListaYaEsPublicaException {
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
        // Verificar si el cliente es el propietario de la lista
        if (lista.getDuenio().getNombre() != usuario.getNombre()) {
            throw new OperacionNoPermitidaException("El usuario seleccionado no es propietario de dicha lista.");
        }
        if (!lista.getEsPrivada()) {
            throw new ListaYaEsPublicaException("La lista " + nombreLista + " ya es pública.");
        } else {
            // Hacer pública la lista de reproducción
            Ml.publicolista(false, lista);
        }
    }

    public Set<Genero> cargarSetGeneros(Set<String> generos) {
        ManejadorGenero mg = ManejadorGenero.getInstance();
        Set<Genero> setGeneros = new HashSet<>();
        for (String nombreGenero : generos) {
            Genero genero = mg.obtenerGeneroPorNombre(nombreGenero);
            if (genero != null) {
                setGeneros.add(genero);
            }
        }
        return setGeneros;
    }

    @Override
    public List<String> obtenerAlbumsPorGenero(String generoSeleccionado) {
        return cPersist.obtenerAlbumsPorGenero(generoSeleccionado);
    }

    @Override
    public List<String> obtenerAlbumsPorArtista(String artistaSeleccionado) {
        return cPersist.obtenerAlbumsPorArtista(artistaSeleccionado);
    }

    @Override
    public DTOAlbum consultaAlbumPorTitulo(String albumSeleccionado) {
        Album a = cPersist.consultaAlbumPorTitulo(albumSeleccionado);
        if (a != null) {
            Set<String> generosString = new HashSet<>();
            Set<DTOTema> tDTO = new HashSet<>();
            for (Genero gen : a.getGeneros()) {
                generosString.add(gen.getNombre());
            }
            for (Tema tem : a.getTemas()) {
                DTOTema nuevoTDTO = new DTOTema(tem.getNombre(), tem.getDuracion(), tem.getEnlace(), tem.getPosicion());
                tDTO.add(nuevoTDTO);
            }
            DTOAlbum aDTO = new DTOAlbum(a.getTitulo(), a.getAnio(), a.getRutaImagen(), a.getArtista().getNickname(),
                    generosString, tDTO);
            return aDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<DTOGenero> Datageneros() {
        ManejadorGenero mang = ManejadorGenero.getInstance();
        List<Genero> gen = mang.obtengoListaGenero();
        Genero genunoauno;
        List<DTOGenero> dtogeneros = new ArrayList<>();

        for (int i = 0; i < gen.size(); i++) {
            genunoauno = gen.get(i);
            DTOGenero dagenero = new DTOGenero(genunoauno.getNombre(), genunoauno.getNombrepapa());
            dtogeneros.add(dagenero);
        }
        return dtogeneros;
    }

    @Override
    // Usado para control de AltaAlbum
    public boolean existeAlbum(String nicknameArtista, String titulo) {
        return cPersist.existeAlbum(nicknameArtista, titulo);
    }

    @Override
    public void AñadotemalistaAlbum(String nombreAlbum, String nombreLista, String nombreTema, String nombreUsuario) {
        Album a = cPersist.consultaAlbumPorTitulo(nombreAlbum);
        ManejadorUsuario usr = ManejadorUsuario.getinstance();

        ManejadorLista L = ManejadorLista.getInstance();
        Lista lo = L.ExisteLista(nombreLista);
        Cliente C = usr.obtenerCliente(nombreUsuario);
        Usuario U = lo.getDuenio();
        if (C instanceof Cliente) {
            if (C == U) {
                if (lo == null) {
                    JOptionPane.showMessageDialog(null, "Lista no existe");
                    return;
                }
                Tema iteratema;
                Lista lis = L.ExisteLista(nombreLista);
                List<Tema> temaslista = lis.getTemas();
                Set<Tema> lostemas = a.getTemas();
                Iterator<Tema> iterador = lostemas.iterator();

                Tema t;
                while (iterador.hasNext()) {

                    t = iterador.next();
                    if (t.getNombre().equalsIgnoreCase(nombreTema)) {// cheque el nombre tema en el album

                        if (temaslista.isEmpty()) {
                            L.aniadotemalista(nombreLista, t);
                            return;
                        } else {
                            for (int i = 0; i < temaslista.size(); i++) {// Me fijo tema por tema dentro de los temas de
                                                                         // la lista
                                iteratema = temaslista.get(i);
                                if (iteratema.getNombre().equalsIgnoreCase(nombreTema)) {
                                    // retorna que ya existe
                                    JOptionPane.showMessageDialog(null, "Tema ya existe");
                                    return;
                                }
                            }
                            L.aniadotemalista(nombreLista, t);
                            JOptionPane.showMessageDialog(null, "Tema Añadido con exito");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "el nombre usuario que paso no es el dueño de la lista");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no es cliente");
        }

    }

    public DTOTema consultaTemaPorTituloYAlbum(String nombreTema, String nombreAlbum, String nombreArtista) {

        String nombrEAlbum;
        String nombreartista;
        DTOTema tre = null;

        DTOAlbum alb = cPersist.BuscoAlbumartista(nombreAlbum, nombreArtista);

        List<Tema> temis = cPersist.ObtengotemaPorAlbum(alb.getTitulo());

        for (Tema te : temis) {
            if (te.getNombre().equalsIgnoreCase(nombreTema)) {
                nombrEAlbum = te.getAlbum().getTitulo();

                nombreartista = te.getAlbum().getArtista().getNickname();

                tre = new DTOTema(te.getNombre(), te.getDuracion(), te.getEnlace(), nombrEAlbum, nombreartista);
            }
        }
        if (tre != null) {

            return tre;

        } else {
            return null;
        }
    }

    @Override
    public List<DTOLista> Obtengolistasconduenio() throws NoExisteLista {

        ManejadorLista man = ManejadorLista.getInstance();
        Lista losta;
        List<Lista> lista;
        lista = man.todaslistasconduenio();
        List<DTOLista> dtolista = new ArrayList<>();
        Usuario usr;
        for (int i = 0; i < lista.size(); i++) {
            losta = lista.get(i);
            usr = losta.getDuenio();
            DTOUsuario datousr = new DTOUsuario(usr.getNickname());
            DTOLista datolista = new DTOLista(losta.getNombre(), datousr);
            dtolista.add(datolista);
        }
        return dtolista;
    }

    @Override
    public List<DTOLista> Obtengolistassinduenio() throws NoExisteLista {

        ManejadorLista man = ManejadorLista.getInstance();
        Lista losta;
        List<Lista> lista;
        lista = man.todaslistassinduenio();
        List<DTOLista> dtolista = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            losta = lista.get(i);
            DTOLista datolista = new DTOLista(losta.getNombre());
            dtolista.add(datolista);
        }
        return dtolista;
    }

    @Override
    public List<DTOLista> Obtengolistas() throws NoExisteLista {

        ManejadorLista man = ManejadorLista.getInstance();
        Lista losta;
        List<Lista> lista;
        lista = man.todaslistas();
        List<DTOLista> dtolista = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            losta = lista.get(i);
            DTOLista datolista = new DTOLista(losta.getNombre());
            dtolista.add(datolista);
        }
        return dtolista;
    }

    @Override
    public void aniadoTemaListaPublica(String nombrelista, String nombreteam, String nombrealb) {

        ManejadorLista manlis = ManejadorLista.getInstance();
        Lista lis = cPersist.consultaListaPorTitulo(nombrelista);
        Album alb = cPersist.BuscoAlbumtemalis(nombrealb);

        if (alb != null) {

            if (lis.getEsPrivada() != true) {

                Set<Tema> tems = alb.getTemas();
                Iterator<Tema> temass = tems.iterator();
                Tema tem = null;
                while (temass.hasNext()) {
                    tem = temass.next();
                    if (tem.getNombre().equals(nombreteam)) {
                        break;
                    }
                }
                if (!tem.getNombre().equals(nombreteam)) {
                    
                    return;
                }
                List<Tema> temalis = manlis.temasdelalista(nombrelista);
                Tema tom;

                for (int i = 0; i < temalis.size(); i++) {
                    tom = temalis.get(i);
                    if (tom.getId() == tem.getId()) {
                        
                        return;
                    }
                }

                Iterator<Tema> segundoTemass = tems.iterator();
                while (segundoTemass.hasNext()) {
                    tem = segundoTemass.next();
                    if (tem.getNombre().equalsIgnoreCase(nombreteam)) {
                        manlis.aniadotemalista(nombrelista, tem);
                        return;
                    }

                }

            } else {
                
            }
        } else {
            
        }

    }

    @Override
    public void EliminotemaLista(String nombreLista, String nombreTema, String nombreAlbum) {
        if (nombreAlbum.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un Album");
            return;
        }
        Album alb = cPersist.consultaAlbumPorTitulo(nombreAlbum);
        Set<Tema> temardos = alb.getTemas();
        Iterator<Tema> temass = temardos.iterator();
        Tema tem = null;
        while (temass.hasNext()) {
            tem = temass.next();
            if (tem.getNombre().equalsIgnoreCase(nombreTema)) {
                break;
            }
        }
        if (tem == null) {
            JOptionPane.showMessageDialog(null, "El tema no existe");
            return;
        }

        Tema iteratem;
        ManejadorLista manlis = ManejadorLista.getInstance();
        Lista lis = manlis.ExisteLista(nombreLista);
        List<Tema> temos = lis.getTemas();
        if (lis != null) {
            if (lis.getDuenio() == null) {
                if (lis.getEsPrivada() != true) {

                    if (temos.isEmpty()) {

                        JOptionPane.showMessageDialog(null, "No hay Temas en la lista");
                        return;
                    } else {
                        for (int i = 0; i < temos.size(); i++) {
                            iteratem = temos.get(i);
                            if (iteratem.getNombre().equalsIgnoreCase(nombreTema)) {
                                // retorna que ya existe
                                manlis.Eliminotemalista(nombreLista, tem);
                                return;
                            }
                        }

                        JOptionPane.showMessageDialog(null, "No existe el tema");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Lista no es publica");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "La lista no es por defecto tiene dueño");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista no existe");
        }
    }

    @Override
    public void EliminoTemaListaConduenio(String nombreUsuario, String nombreLista, String nombreTema,
            String nombreAlbum) {
        if (nombreAlbum.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un Album");
            return;
        }
        Album alb = cPersist.consultaAlbumPorTitulo(nombreAlbum);
        Set<Tema> temardos = alb.getTemas();
        Iterator<Tema> temass = temardos.iterator();
        Tema tem = null;
        while (temass.hasNext()) {
            tem = temass.next();
            if (tem.getNombre().equalsIgnoreCase(nombreTema)) {
                break;
            }
        }
        if (tem == null) {
            JOptionPane.showMessageDialog(null, "El tema no existe");
            return;
        }
        Tema iteratem;
        ManejadorLista manlis = ManejadorLista.getInstance();
        Lista lis = manlis.ExisteLista(nombreLista);
        List<Tema> temos = lis.getTemas();
        ManejadorUsuario USR = ManejadorUsuario.getinstance();
        Cliente Cli = USR.obtenerCliente(nombreUsuario);

        if (Cli != null) {
            if (lis != null) {
                if (lis.getDuenio().getNombre().equalsIgnoreCase(Cli.getNombre())) {
                    if (lis.getEsPrivada() != true) {

                        if (temos.isEmpty()) {

                            JOptionPane.showMessageDialog(null, "la lista esta vacia");
                        } else {
                            for (int i = 0; i < temos.size(); i++) {
                                iteratem = temos.get(i);
                                if (iteratem.getNombre().equalsIgnoreCase(nombreTema)) {
                                    manlis.Eliminotemalista(nombreLista, tem);
                                    JOptionPane.showMessageDialog(null, "Tema eliminado con exito");
                                    return;
                                }
                            }
                            JOptionPane.showMessageDialog(null, "No se encontro el tema");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista no es publica");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ese no es el dueñio de la lista");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lista no existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El suaurio ingresado no es un cliente");
        }

    }

    @Override
    public void aniadoTemaListaConduenio(String nombreUsuario, String nombrelista, String nombreteam,
            String nombrealb) {
        ManejadorUsuario manusr = ManejadorUsuario.getinstance();
        Cliente Cli = manusr.obtenerCliente(nombreUsuario);

        ManejadorLista manlis = ManejadorLista.getInstance();
        Lista lis = cPersist.consultaListaPorTitulo(nombrelista);
        Album alb = cPersist.BuscoAlbumtemalis(nombrealb);

        if (Cli != null) {
            if (alb != null) {
                String nick = lis.getDuenio().getNickname();
                if (nick.equalsIgnoreCase(nombreUsuario)) {

                    if (lis.getEsPrivada() != true) {
                        Set<Tema> tems = alb.getTemas();
                        Iterator<Tema> temass = tems.iterator();
                        Tema tem = null;
                        while (temass.hasNext()) {
                            tem = temass.next();
                            if (tem.getNombre().equals(nombreteam)) {
                                break;
                            }
                        }
                        if (!tem.getNombre().equals(nombreteam)) {
                            JOptionPane.showMessageDialog(null, "El Tema no existe");
                            return;
                        }
                        List<Tema> temalis = manlis.temasdelalista(nombrelista);
                        Tema tom;

                        for (int i = 0; i < temalis.size(); i++) {
                            tom = temalis.get(i);
                            if (tom.getId() == tem.getId()) {
                                JOptionPane.showMessageDialog(null, "El Tema ya existe");
                                return;
                            }
                        }

                        Iterator<Tema> segundoTemass = tems.iterator();
                        while (segundoTemass.hasNext()) {
                            tem = segundoTemass.next();
                            if (tem.getNombre().equalsIgnoreCase(nombreteam)) {
                                manlis.aniadotemalista(nombrelista, tem);
                                return;
                            }

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "La lista es privada");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ese usuario no es el dueñio");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El album no existe");
            }

        } else {
            JOptionPane.showMessageDialog(null, "El cliente no existe");
        }

    }

    @Override
    public List<DTOTema> TemasdeListasDTO(String nombrelista) {
        ManejadorLista manlis = ManejadorLista.getInstance();
        List<DTOTema> temos = manlis.temasdelalistadto(nombrelista);
        return temos;
    }

    @Override
    public List<DTOTema> TemasdeListas(String nombrelista) {

        ManejadorLista manlis = ManejadorLista.getInstance();
        List<Tema> temos = manlis.temasdelalista(nombrelista);

        Tema tem;
        List<DTOTema> dtotema = new ArrayList<>();

        for (int i = 0; i < temos.size(); i++) {
            tem = temos.get(i);
            DTOTema datotemo = new DTOTema(tem.getId(), tem.getNombre(), tem.getDuracion(), tem.getEnlace(), tem.getPosicion(), 0);
            dtotema.add(datotemo);
        }
        return dtotema;
    }

    @Override
    public List<DTOAlbum> ObtengoAlbums() {
        List<Album> Albumes = cPersist.obtenerTodosLosAlbumsCompletos();
        List<DTOAlbum> dtoalbum = new ArrayList<>();

        for (Album alb : Albumes) {
            if (alb.getArtista() != null) {

                Set<String> generos = new HashSet<>();
                for (Genero genero : alb.getGeneros()) {
                    generos.add(genero.getNombre());
                }

                Set<DTOTema> temas = new HashSet<>();
                for (Tema tema : alb.getTemas()) {
                    temas.add(new DTOTema(tema.getNombre(), tema.getDuracion(), tema.getEnlace(), tema.getPosicion()));
                }
                DTOAlbum datoalbu = new DTOAlbum(
                        alb.getTitulo(),
                        alb.getAnio(),
                        alb.getRutaImagen(),
                        alb.getArtista().getNickname(),
                        generos,
                        temas);
                dtoalbum.add(datoalbu);
            }
        }
        return dtoalbum;
    }

    @Override
    public List<DTOTema> obtenerTemitasDATA() {
        List<Tema> temas = cPersist.findTemitas();
        List<DTOTema> dtoTemas = new ArrayList<>();
        String nombreartista;

        for (Tema t : temas) {
            String nombralb = t.getAlbum().getTitulo();
            nombreartista = t.getAlbum().getArtista().getNickname();
            DTOTema dtoTema = new DTOTema(t.getNombre(), t.getDuracion(), t.getEnlace(), nombralb, nombreartista);
            dtoTemas.add(dtoTema);
        }
        return dtoTemas;
    }

    @Override
    public List<DTOTema> ObtengoTemasdeAlbum(String nombreAlbum) {

        List<Tema> temos = cPersist.ObtengotemaPorAlbum(nombreAlbum);
        Tema tem;
        List<DTOTema> dtotema = new ArrayList<>();

        for (int i = 0; i < temos.size(); i++) {
            tem = temos.get(i);
            DTOTema datotemo = new DTOTema(tem.getNombre(), tem.getDuracion(), tem.getEnlace(), tem.getPosicion());
            dtotema.add(datotemo);
        }
        return dtotema;
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
    public List<DTOLista> ObtengoListasPublicasDATA() {
        ManejadorLista man = ManejadorLista.getInstance();
        List<Lista> lista = man.todaslistaspublica();
        List<DTOLista> dtolista = new ArrayList<>();
        String nick;
        for (Lista losta : lista) {
            if (losta.getDuenio() == null) {
                // Valor predeterminado cuando no hay dueño
                nick = "Desconocido";

            } else {

                nick = losta.getDuenio().getNickname();
            }

            DTOLista datolista = new DTOLista(losta.getNombre(), losta.getRutaImagen(), nick);
            dtolista.add(datolista);
        }

        return dtolista;
    }

    @Override
    public List<DTOLista> ObtengoListasPublicas() throws NoExisteLista {
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
    public List<DTOAlbum> obtenerAlbums() {
        List<Album> albums = cPersist.todosLosAlbums();
        List<DTOAlbum> dtoAlbums = new ArrayList<>();

        for (Album a : albums) {
            // String titulo, int anio, String rutaImagen, String artista, Set<String>
            // generos, Set<DTOTema> temas
            DTOAlbum dtoAlbum = new DTOAlbum(a.getTitulo(), a.getAnio(), a.getRutaImagen(),
                    a.getArtista().getNickname(), null, null);
            dtoAlbums.add(dtoAlbum);
        }
        return dtoAlbums;
    }

    @Override
    public List<String> obtenerListaPorGenero(String generoSeleccionado) {
        return cPersist.obtenerListaPorGenero(generoSeleccionado);
    }

    @Override
    public List<DTOLista> obtenerListaPorClienteDATA(String clienteseleccionado) {
        return cPersist.obtenerListaPorClienteDATA(clienteseleccionado);
    }

    @Override
    public List<String> obtenerListaPorCliente(String clienteseleccionado) {
        return cPersist.obtenerListaPorCliente(clienteseleccionado);
    }

    @Override
    public DTOLista ObtenerListaporTitulo(String nombrelista) throws NoExisteLista {
        Lista lis = cPersist.consultaListaPorTitulo(nombrelista);

        // Verifica si la lista existe antes de intentar convertirla
        if (lis != null) {
            String nombre = lis.getNombre();
            String rutaImagen = lis.getRutaImagen();

            // Obtén el nickname del dueño, si existe
            String duenioNickname = (lis.getDuenio() != null) ? lis.getDuenio().getNickname() : "Desconocido";

            // Crea el DTOLista con los datos obtenidos de la lista
            DTOLista pom = new DTOLista(nombre, rutaImagen, duenioNickname);
            return pom;
        } else {
            // Manejo en caso de que no se encuentre la lista
            throw new NoExisteLista("La lista no existe.");

        }
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
    public List<DTOLista> obtenerListitas() {
        List<Lista> listas = cPersist.findListas();
        List<DTOLista> dtoListas = new ArrayList<>();

        for (Lista l : listas) {
            // String nombre, String rutaImagen, String generoOCreador)
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
            DTOLista dtoLista = new DTOLista(l.getNombre(), l.getRutaImagen());
            dtoListas.add(dtoLista);
        }
        return dtoListas;
    }

    @Override
    public List<DTOAlbum> obtenerAlbumsfavCliente(String nickname) {
        List<Album> albums = cPersist.obtenerAlbumsFavoritosDeCliente(nickname);
        List<DTOAlbum> dtoAlbums = new ArrayList<>();

        for (Album a : albums) {
            // Crear el DTO con los datos del álbum favorito
            DTOAlbum dtoAlbum = new DTOAlbum(a.getTitulo(), a.getAnio(), a.getRutaImagen(),
                    a.getArtista().getNickname(), null, null);
            dtoAlbums.add(dtoAlbum);
        }
        return dtoAlbums;
    }

    @Override
    public DTOTema consultaTemaPorTitulo(String temaSeleccionada) {
        Tema t = cPersist.findTemaPorTitulo(temaSeleccionada);
        DTOTema tDTO = new DTOTema(t.getNombre(), t.getDuracion(), t.getEnlace(), t.getPosicion());
        return tDTO;
    }

    @Override
    public void aniadoTemaListaConduenioLista(String nombreUsuario, String nombrelista, String nombreteam,
            String nombreListadeltema) {
        ManejadorLista manlis = ManejadorLista.getInstance();
        Lista lis = cPersist.consultaListaPorTitulo(nombrelista);
        ManejadorUsuario manusr = ManejadorUsuario.getinstance();
        Cliente Cli = manusr.obtenerCliente(nombreUsuario);

        if (Cli != null) {
            if (lis.getEsPrivada() != true) {
                String nick = lis.getDuenio().getNickname();
                if (nick.equals(nombreUsuario)) {

                    Lista lisdeltema = cPersist.consultaListaPorTitulo(nombreListadeltema);
                    if (lisdeltema.getEsPrivada() != true) {
                        List<Tema> temaslis = lis.getTemas();
                        if (temaslis == null) {

                            List<Tema> temas = lisdeltema.getTemas();
                            Tema tem;
                            for (int i = 0; i < temas.size(); i++) {
                                tem = temas.get(i);
                                if (tem.getNombre().equalsIgnoreCase(nombreteam)) {
                                    manlis.aniadotemalista(nombrelista, tem);
                                    return;
                                }
                            }
                        } else {
                            List<Tema> temas = lisdeltema.getTemas();
                            Tema tem;
                            Tema tom;

                            for (int i = 0; i < temas.size(); i++) {
                                tem = temas.get(i);
                                for (int d = 0; d < temaslis.size(); d++) {
                                    tom = temaslis.get(d);
                                    if (tom.getId() == tem.getId()) {
                                        JOptionPane.showMessageDialog(null, "El tema ya existe");
                                        return;
                                    }
                                }
                            }

                            for (int i = 0; i < temas.size(); i++) {
                                tem = temas.get(i);
                                if (tem.getNombre().equalsIgnoreCase(nombreteam)) {
                                    manlis.aniadotemalista(nombrelista, tem);
                                    JOptionPane.showMessageDialog(null, "El tema fue añadido con exito");
                                    return;
                                }
                            }

                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ese no es el dueñio");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La lista es privada");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Cliente no existe");
        }
    }

    @Override
    public  void aniadoTemaListaPublicaLista(String nombrelista,String nombreteam,String nombrealistadeltema){  
        ManejadorLista manlis = ManejadorLista.getInstance();
        Lista lis = cPersist.consultaListaPorTitulo(nombrelista);
        Lista lis2 = cPersist.consultaListaPorTitulo(nombrealistadeltema);     
        if(lis!=null){           
            if(lis.getEsPrivada()!=true){ 
                if(lis.getEsPrivada()!=true){                   
                    List <Tema> temaslis = lis.getTemas();
                    if(temaslis==null){
                        List <Tema> tems = lis2.getTemas();
                        Tema tem;
                        Iterator <Tema> temass =tems.iterator();
                        while (temass.hasNext()){
                            tem = temass.next();
                            if(tem.getNombre().equalsIgnoreCase(nombreteam)){
                                manlis.aniadotemalista(nombrelista, tem);
                                return;
                            }
                        }
                    }else{                        
                        List <Tema> tems = lis2.getTemas();
                        Tema tem;
                        Tema tom;
                        Iterator <Tema> temass =tems.iterator();
                        while (temass.hasNext()){
                                tem = temass.next();
                            for(int i=0;i<temaslis.size();i++){
                                tom = temaslis.get(i);
                                if(tom.getId()==tem.getId()){
                                    JOptionPane.showMessageDialog(null,"El tema ya existe");
                                    return;
                                }
                                }
                            }
                        temass = tems.iterator();
                        while (temass.hasNext()){
                            tem = temass.next();
                            if(tem.getNombre().equalsIgnoreCase(nombreteam)){
                                manlis.aniadotemalista(nombrelista, tem);
                                return;
                            }
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"La lista es privada");
                }
            }else{
            JOptionPane.showMessageDialog(null,"La lista no existe");
            }
        } 
    }

    @Override
    public List<String> obtenerNombresGeneros() {
        ManejadorGenero mang = ManejadorGenero.getInstance();
        List<Genero> gen = mang.obtengoListaGenero();
        Genero genunoauno;
        List<String> nombres = new ArrayList<>();
        for (int i = 0; i < gen.size(); i++) {
            genunoauno = gen.get(i);
            nombres.add(genunoauno.getNombre());
        }
        return nombres;
    }

    @Override
    public List<DTOAlbum> obtenerTodosLosAlbums() {
        List<Album> albums = cPersist.obtenerTodosLosAlbumsCompletos();
        List<DTOAlbum> dtoAlbums = new ArrayList<>();

        for (Album alb : albums) {
            DTOAlbum dtoAlbum = new DTOAlbum();
            dtoAlbum.setTitulo(alb.getTitulo());
            dtoAlbum.setAnio(alb.getAnio());
            dtoAlbum.setRutaImagen(alb.getRutaImagen());
            dtoAlbum.setArtista(alb.getArtista().getNombre());

            Set<String> generosString = new HashSet<>();
            for (Genero genero : alb.getGeneros()) {
                generosString.add(genero.getNombre());
            }
            dtoAlbum.setGeneros(generosString);

            Set<DTOTema> temasDto = new HashSet<>();
            for (Tema tema : alb.getTemas()) {
                DTOTema dtoTema = new DTOTema();
                dtoTema.setNombre(tema.getNombre());
                dtoTema.setDuracion(tema.getDuracion());
                dtoTema.setEnlace(tema.getEnlace());
                dtoTema.setPosicion(tema.getPosicion());
                temasDto.add(dtoTema);
            }
            dtoAlbum.setTemas(temasDto);

            dtoAlbums.add(dtoAlbum);
        }

        return dtoAlbums;
    }

    public List<DTOLista> obtenerListaPorGeneroDTOLISTA(String generoSeleccionado) {
        return cPersist.obtenerListaPorGeneroDATALISTA(generoSeleccionado);
    }

    @Override
    public boolean albumEsDeXGenero(String albumTitulo, String artistaNickname, String generoNombre) {
        return cPersist.albumEsDeXGenero(albumTitulo, artistaNickname, generoNombre);
    }

    @Override
    public List<DTOTema> temasDelAlbum(String titulo) {
        List<Tema> temas = cPersist.temasDelAlbum(titulo);
        List<DTOTema> listDTOTemas = new ArrayList<>();

        for (Tema t : temas) {
            DTOTema dtoTema = new DTOTema(t.getNombre(), t.getDuracion(), t.getEnlace(), t.getPosicion());
            listDTOTemas.add(dtoTema);
        }
        return listDTOTemas;
    }

    @Override
    public List<String> ObtengolistasClipriv(String nickcli) throws NoExisteLista {
        // Obtenemos las listas privadas del cliente, que deberían ser objetos de tipo
        // Lista o similar
        List<String> listas = cPersist.findListaPorClientePriv(nickcli);
        List<String> dtoListas = new ArrayList<>();

        // Iteramos sobre la lista de objetos de tipo Lista
        for (String l : listas) {
            dtoListas.add(l);
        }

        return dtoListas;
    }

    public void AgregarTemaLista(String nombreusuario, String nombrelista, String nombretema)
            throws UsuariosNoExisten, ListaNoexisteException, NoesDueñodelaLista, TemaNoExiste {

    }
    
    
    public  boolean existeGenero(String genero){
        ManejadorGenero manG = ManejadorGenero.getInstance();
        
       Genero g = manG.Existegenbasedatoss(genero);
        
       if ( g ==null ){
           return false;
       }else{
           return true;
       }
    }
    
    
    public boolean obtenerPadre(String nombreGenero){
        ManejadorGenero manG = ManejadorGenero.getInstance();
        
        Genero gun = manG.Existegenbasedatoss(nombreGenero);
        
        if (gun == null){
            return false;
        }
        return true;
        
        
    }
       public  boolean espublicasiono(String nombreUsuario, String NombreLista){
           ManejadorUsuario usrM = ManejadorUsuario.getinstance();
           
          Cliente cli = usrM.obtenerCliente(nombreUsuario);
          
          if(cli!=null){
              
              ManejadorLista manL = ManejadorLista.getInstance();
              Lista lis = manL.ExisteLista(NombreLista);
              if(lis!=null){
              if(lis.getEsPrivada()==true){
                  return true;
          }else{
                System.out.println("NO ES PUBLICA");
                 return false;
          }
           
       }else{
                System.out.println("NO EXISTE LISTA");
                 return false;
          }
          
    }else{
               System.out.println("NO EXISTE USUARIO");
        return false;
          }
       }
       
       public boolean sumaDescarga(DTOTema t){
           
           
           List<Tema> temos = cPersist.findTemitas();
           
           for(Tema tem : temos){
               if(tem.getNombre().equalsIgnoreCase(t.getNombre())&&tem.getAlbum().getTitulo().equalsIgnoreCase(t.getAlbum())){
                   
                    return cPersist.sumaDescarga(tem);
               }
           }
           
          
          return false;
       }
       
       public boolean sumaReproduccion(DTOTema t){
           
           
           List<Tema> temos = cPersist.findTemitas();
           
           for(Tema tem : temos){
               if(tem.getNombre().equalsIgnoreCase(t.getNombre())&&tem.getAlbum().getTitulo().equalsIgnoreCase(t.getAlbum())){
                   
                    return cPersist.sumaReproduccion(tem);
               }
           }
           
          
          return false;
       }
       
       public List<DTOTema> promedioTemas() {
    // Obtener la lista de temas
    List<Tema> temas = cPersist.findTemitas();

    // Crear una lista para los DTOs
    List<DTOTema> dtoTemas = new ArrayList<>();

    // Calcular el puntaje para cada tema y crear los DTOs
    for (Tema tema : temas) {
        // Obtener los valores necesarios para calcular el puntaje
        int descargas = tema.getDescarga(); // Método que retorna las descargas del tema
        int reproducciones = tema.getReproduccion(); // Método que retorna las reproducciones del tema
        int listasCon = cPersist.findCantidadListasConTema(tema.getId()); // Método que retorna las listas que contienen el tema
        int favoritosCon = cPersist.findCantidadFavoritosConTema(tema.getId()); // Método que retorna los favoritos que incluyen el tema

        // Calcular el puntaje basado en la fórmula
        double puntaje = descargas * 0.2 + reproducciones * 0.3 + listasCon * 0.2 + favoritosCon * 0.3;

        // Crear un DTO con la información del tema y el puntaje
        DTOTema dtoTema = new DTOTema(tema.getId(), tema.getNombre(), tema.getDuracion(),tema.getEnlace(),tema.getPosicion() ,puntaje);

        // Agregar el DTO a la lista
        dtoTemas.add(dtoTema);
    }

    // Ordenar los DTOs por puntaje en orden descendente (opcional, si necesitas el orden)
    dtoTemas.sort((a, b) -> Double.compare(b.getPuntaje(), a.getPuntaje()));

    // Devolver todos los temas con sus puntajes
    return dtoTemas;
}
       
}