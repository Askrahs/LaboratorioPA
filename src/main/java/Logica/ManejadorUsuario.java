package Logica;

import LogicaDTO.DtoAlbum;
import LogicaDTO.DtoLista;
import LogicaDTO.DtoTema;
import Logica.Suscripcion.EstadoSuscripcion;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Logica.RegistroAcceso;
import static Logica.Suscripcion.TipoSuscripcion.ANUAL;
import static Logica.Suscripcion.TipoSuscripcion.MENSUAL;
import static Logica.Suscripcion.TipoSuscripcion.SEMANAL;
import LogicaDTO.DtoSuscripcion;
import static Main.LaboratorioPA.CARPETA_IMAGEN;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStream;

public class ManejadorUsuario {

    private Map<String, Usuario> usuarioNick;
    private static ManejadorUsuario instancia = null;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;

    private ManejadorUsuario() {
        usuarioNick = new HashMap<String, Usuario>(); //Lista de usuarios por pk nicj
        emf = Persistence.createEntityManagerFactory("EspotifyBD");
        em = emf.createEntityManager();
        t = em.getTransaction(); //se usa para las consultas y commits/rollbacks
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null) {
            instancia = new ManejadorUsuario();
        }
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String nick = usu.getNickname();
        usuarioNick.put(nick, usu);
    }

    public Usuario obtenerUsuario(String nickname) {
        Usuario usuario = em.find(Usuario.class, nickname);
        return usuario;
    }

    public Cliente obtenerCliente(String nickname) {
        Cliente c = em.find(Cliente.class, nickname);
        return c;
    }

    public Usuario[] getUsuarios() {
        if (usuarioNick.isEmpty()) {
            return null;
        } else {
            Collection<Usuario> usrs = usuarioNick.values();
            Object[] o = usrs.toArray();
            Usuario[] usuarios = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                usuarios[i] = (Usuario) o[i];
            }
            return usuarios;
        }
    }

    public Collection<Artista> ObtenerTodosLosArtistas() {
        Collection<Artista> artistas = null;
        //FOR EACH OBTENER ARTISTAS BD
        return artistas;
    }

    public Artista obtenerArtista(String nickname) {
        Artista a = em.find(Artista.class, nickname);
        return a;
    }

    public void AltaCliente(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String contraseña) {
        Cliente u = new Cliente(nickname, nombre, apellido, email, imagen, fechaNac, siguiendo, seguidores, contraseña);
        try {
            t.begin();
            em.persist(u);
            t.commit();
        } catch (Exception e) {
            //si sale mal rollback
            t.rollback();
        }
    }

    public void AltaArtista(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String biografia, String website, String contraseña) {
        Artista a = new Artista(nickname, nombre, apellido, email, imagen, fechaNac, siguiendo, seguidores, biografia, website, contraseña, true);
        try {
            t.begin();
            em.persist(a);
            t.commit();
        } catch (Exception e) {
            //si sale mal rollback
            t.rollback();
        }
    }

    public void SeguirUsuario(String nickname1, String nickname2) {
        Usuario seguidor = em.find(Usuario.class, nickname1);
        Usuario seguido = em.find(Usuario.class, nickname2);
        if (seguidor != null && seguido != null) { //Si  existen en la bd
            seguidor.getSiguiendo().add(seguido); //el que sigue
            seguido.getSeguidores().add(seguidor); //el seguido
            try {
                t.begin();
                em.merge(seguidor);
                em.merge(seguido);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }
    }

    public void DejarDeSeguirUsuario(String nickname1, String nickname2) {
        Usuario seguidor = em.find(Usuario.class, nickname1);
        Usuario seguido = em.find(Usuario.class, nickname2);
        if (seguidor != null && seguido != null) { //Si  existen en la bd
            seguidor.getSiguiendo().remove(seguido); //el que sigue
            seguido.getSeguidores().remove(seguidor); //el seguido
            try {
                t.begin();
                em.merge(seguidor);
                em.merge(seguido);
                t.commit();
            } catch (Exception e) {
                //si sale mal rollback
                t.rollback();
            }
        }
    }

    public Boolean EmailUsado(String email) {
        Long count = null;

        String jpql = "SELECT COUNT(c) FROM Cliente c WHERE c.email = :email";
        count = (Long) em.createQuery(jpql).setParameter("email", email).getSingleResult();

        String jpql2 = "SELECT COUNT(a) FROM Artista a WHERE a.email = :email";
        count = count + (Long) em.createQuery(jpql2).setParameter("email", email).getSingleResult();

        return count > 0;
    }

    public List<String> ObtenerNicknamesClientes() {
        List<String> nicknames;
        String jpql = "SELECT c.nickname FROM Cliente c";
        nicknames = em.createQuery(jpql, String.class).getResultList();
        return nicknames;
    }

    public Long ObtenerCuentaSeguidores(String nickname) {
        Artista artista = em.find(Artista.class, nickname);
        if (artista != null) {
            return (long) artista.getSeguidores().size();
        } else {
            return 0L;
        }
    }

    public void addTemafavoritos(Cliente c, Tema tema) {
        c.agregarTemaFavorito(tema);
        try {
            t.begin();
            em.merge(c);
            t.commit();
        } catch (Exception e) {
            //si sale mal rollback
            t.rollback();
        }
    }

    public void addListafavoritos(Cliente c, Lista lista) {
        Cliente cum = this.obtenerCliente(c.getNickname());

        if(cum!=null){
        cum.agregarListaFavorita(lista);
            t.begin();
            em.merge(cum);
            t.commit();
        }
    }

    public void addAlbumfavoritos(Cliente c, Album album) {
        c.agregarAlbumFavorito(album);
        try {
            t.begin();
            em.merge(c);
            t.commit();
        } catch (Exception e) {
            //si sale mal rollback
            t.rollback();
        }

    }

    public void EliminarTemafavoritos(Cliente c, Tema tema) {
        Tema temita = em.find(Tema.class, tema.getId());  // Pido el tema buscandolo por ID
        if (temita != null) {
            c.removerTemaFavorito(temita);  // Remover el tema de la lista
            t.begin();
            em.merge(c);  // Actualizar la lista
            t.commit();
        }
    }

    public void EliminarListafavoritos(Cliente c, Lista lista) {
        Lista listita = em.find(Lista.class, lista.getId());  // Pido el tema buscandolo por ID
        if (listita != null) {
            c.removerListaFavorita(listita);  // Remover el tema de la lista
            t.begin();
            em.merge(c);  // Actualizar la lista
            t.commit();
        }
    }

    public void EliminarAlbumfavoritos(Cliente c, Album album) {
        Album albuma = em.find(Album.class, album.getId());  // Pido el tema buscandolo por ID
        if (albuma != null) {
            c.removerAlbumFavorito(albuma);  // Remover el tema de la lista
            t.begin();
            em.merge(c);  // Actualizar la lista
            t.commit();
        }
    }

    public List<DtoLista> obtenerListasCliDATA(String nickname) {
        // JPQL para obtener los álbumes favoritos del cliente y los nicknames de sus artistas
        String jpql = "SELECT li FROM Cliente c JOIN c.listasFavoritas li WHERE c.nickname = :nickname";
        List<Lista> ListasFavoritos = em.createQuery(jpql, Lista.class)
                .setParameter("nickname", nickname)
                .getResultList();

        // Inicializa la lista para almacenar los DTOs
        List<DtoLista> listasDto = new ArrayList<>();

        // Itera sobre los álbumes obtenidos
        for (Lista lis : ListasFavoritos) {
            // Obtiene los datos necesarios
            String titulo = lis.getNombre();
            Cliente cli = this.obtenerCliente(nickname);

            String rutaImagen = lis.getRutaImagen();
            String artistaNickname;
            if (cli != null) {
                artistaNickname = cli.getNombre();
            } else {
                artistaNickname = "Desconocido";
            }
            // Crea un nuevo DtoAlbum y lo agrega a la lista
            listasDto.add(new DtoLista(titulo, rutaImagen, artistaNickname));
        }

        return listasDto;
    }

    public List<DtoAlbum> obtenerAlbumsCliDATA(String clienteNickname) {
        // JPQL para obtener los álbumes favoritos del cliente y los nicknames de sus artistas
        String jpql = "SELECT af FROM Cliente c JOIN c.albumsFavoritos af JOIN af.artista a WHERE c.nickname = :nickname";
        List<Album> albumsFavoritos = em.createQuery(jpql, Album.class)
                .setParameter("nickname", clienteNickname)
                .getResultList();

        // Inicializa la lista para almacenar los DTOs
        List<DtoAlbum> albumsDto = new ArrayList<>();

        // Itera sobre los álbumes obtenidos
        for (Album album : albumsFavoritos) {
            // Obtiene los datos necesarios
            String titulo = album.getTitulo();
            int anio = album.getAnio();
            String rutaImagen = album.getRutaImagen();
            String artistaNickname = album.getArtista() != null ? album.getArtista().getNickname() : "Desconocido";

            // Crea un nuevo DtoAlbum y lo agrega a la lista
            albumsDto.add(new DtoAlbum(titulo, anio, rutaImagen, artistaNickname));
        }

        return albumsDto;
    }

    public List<DtoTema> obtenerTemasCliDATA(String nickname) {
        // JPQL para obtener los temas favoritos del cliente
        String jpql = "SELECT t FROM Cliente c JOIN c.temasFavoritos t WHERE c.nickname = :nickname";

        // Ejecutar la consulta y obtener la lista de temas
        List<Tema> nombreTemas = em.createQuery(jpql, Tema.class)
                .setParameter("nickname", nickname)
                .getResultList();

        // Inicializa la lista para almacenar los DTOs
        List<DtoTema> nombreTemasdto = new ArrayList<>(); // Asegúrate de inicializarla
        String nombreAlbum;
        String nombreartista;
        // Itera sobre los temas obtenidos
        for (Tema tem : nombreTemas) {
            // Crea un nuevo DtoTema y lo agrega a la lista
            nombreAlbum = tem.getAlbum().getTitulo();
            nombreartista = tem.getAlbum().getArtista().getNickname();

            nombreTemasdto.add(new DtoTema(tem.getNombre(), tem.getDuracion(), tem.getEnlace(), nombreAlbum, nombreartista));
        }

        return nombreTemasdto; // Devuelve la lista de DTOs
    }

    public List<String> obtenerListasCli(String nickname) {
        List<String> nombresListas;
        String jpql = "SELECT l.nombre FROM Cliente c JOIN c.listasFavoritas l WHERE c.nickname = :nickname";
        nombresListas = em.createQuery(jpql, String.class).setParameter("nickname", nickname).getResultList();

        return nombresListas;
    }

    public List<String> obtenerAlbumsCli(String nickname) {
        List<String> nombresAlbums;
        String jpql = "SELECT a.titulo FROM Cliente c JOIN c.albumsFavoritos a WHERE c.nickname = :nickname";
        nombresAlbums = em.createQuery(jpql, String.class).setParameter("nickname", nickname).getResultList();

        return nombresAlbums;
    }

    public List<String> obtenerTemasCli(String nickname) {
        List<String> nombreTemas;
        String jpql = "SELECT t.nombre FROM Cliente c JOIN c.temasFavoritos t WHERE c.nickname = :nickname";
        nombreTemas = em.createQuery(jpql, String.class).setParameter("nickname", nickname).getResultList();

        return nombreTemas;
    }

    public boolean LoginCliente(String nickname, String contraseña) {
        try {
            String jpql = "SELECT COUNT(c) FROM Cliente c WHERE c.nickname = :nickname AND c.contraseña = :contraseña";
            Long count = em.createQuery(jpql, Long.class)
                    .setParameter("nickname", nickname)
                    .setParameter("contraseña", contraseña)
                    .getSingleResult();

            // Si el count es mayor que 0, significa que existe un cliente con ese nickname y contraseña
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;  // Retorna false en caso de que ocurra algún error
        }
    }

    public boolean LoginArtista(String nickname, String contraseña) {
        try {
            String jpql = "SELECT COUNT(a) FROM Artista a WHERE a.nickname = :nickname AND a.contraseña = :contraseña";
            Long count = em.createQuery(jpql, Long.class)
                    .setParameter("nickname", nickname)
                    .setParameter("contraseña", contraseña)
                    .getSingleResult();

            // Si el count es mayor que 0, significa que existe un cliente con ese nickname y contraseña
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;  // Retorna false en caso de que ocurra algún error
        }
    }

    public Boolean NicknameUsado(String nickname) {
        Long count = null;

        String jpql = "SELECT COUNT(c) FROM Cliente c WHERE c.nickname = :nickname";
        count = (Long) em.createQuery(jpql).setParameter("nickname", nickname).getSingleResult();

        String jpql2 = "SELECT COUNT(a) FROM Artista a WHERE a.nickname = :nickname";
        count = count + (Long) em.createQuery(jpql2).setParameter("nickname", nickname).getSingleResult();

        return count > 0;
    }

    public List<String> obtenerNicknamesSuscripciones() {
        List<String> nicknames;
        //String jpql = "SELECT s.clienteNickname FROM Suscripcion s";
        String jpql = "SELECT s.cliente.nickname FROM Suscripcion s"; //si tiene el cliente
        nicknames = em.createQuery(jpql, String.class).getResultList();
        return nicknames;
    }

    public List<String> obtenerRankingdeSeguidores() {
        List<String> resultados;
        try {
            String sql = "SELECT siguiendo_id FROM usuario_siguiendo GROUP BY siguiendo_id ORDER BY COUNT(*) DESC;";
            resultados = em.createNativeQuery(sql).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            resultados = new ArrayList<>();
        }
        return resultados;
    }

    public Suscripcion obtenerSuscripcion(String nickname) {
        em.clear();
        Suscripcion s = em.find(Suscripcion.class, nickname);
        if (s != null) {
            em.refresh(s);
        }
        return s;
    }

    public void ModificarSuscripcion(String nickname, String fecha, String estadoStr, String tipoStr) {
        EntityTransaction tx = null;
        Cliente c = obtenerCliente(nickname);
        try {
            // Iniciar la transacción
            tx = em.getTransaction();
            tx.begin();

            // Convertir los strings a los tipos enumerados
            Suscripcion.EstadoSuscripcion estado = Suscripcion.EstadoSuscripcion.valueOf(estadoStr);
            Suscripcion.TipoSuscripcion tipo = Suscripcion.TipoSuscripcion.valueOf(tipoStr);

            // Crear el formato de fecha correcto (si fuera necesario realizar algún parseo de fecha)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaFormato = LocalDate.parse(fecha, formatter);

            // Crear el query de actualización
            String jpql = "UPDATE Suscripcion s SET s.fecha = :fecha, s.estado = :estado, s.tipo = :tipo WHERE s.clienteNickname = :nickname";

            // Ejecutar el query
            Query query = em.createQuery(jpql);
            query.setParameter("fecha", fechaFormato.format(formatter)); // Enviar la fecha en el formato correcto (dd/MM/yyyy)
            query.setParameter("estado", estado);
            query.setParameter("tipo", tipo);
            query.setParameter("nickname", nickname);

            // Realizar la actualización
            int filasActualizadas = query.executeUpdate();

            // Cometer la transacción
            tx.commit();

            System.out.println("Filas actualizadas: " + filasActualizadas);

            //enviar mail de actualizacion.
            // Crear el cuerpo del correo
            String cuerpoCorreo = "\n"
                    + "\n "
                    + "\n Estimado/a " + nickname + ","
                    + "\n Su suscripcion en Espotify ha sido actualizada y se encuentra en estado " + tipoStr + "."
                    + "\n "
                    + "\n Detalles de la Suscripcion:"
                    + "\n "
                    + "\n Tipo: " + tipoStr + ""
                    + "\n Precio: U$S " + String.format("%.2f", obtenerPrecio(tipo)) + ""
                    + "\n Fecha de Actualizacion: " + fechaFormato + ""
                    + "\n "
                    + "\n Gracias por preferirnos."
                    + "\n Saludos,Espotify"
                    + "\n "
                    + "\n ";

            String asunto = "[Espotify] Actualizacion de su Suscripcion";

            // Enviar el correo
            EmailUtil.enviarCorreo(c.getEmail(), asunto, cuerpoCorreo);

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback(); // Hacer rollback si ocurre un error
            }
            e.printStackTrace();
        }
    }

    public void CrearSuscripcion(String nickname, String Tipo) {
        Cliente c = obtenerCliente(nickname);

        // Obtener la fecha actual en formato dd/MM/yyyy
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaActual.format(formatter);

        // Convertir el string a TipoSuscripcion
        Suscripcion.TipoSuscripcion tipoSuscripcion = Suscripcion.TipoSuscripcion.valueOf(Tipo.toUpperCase());

        Suscripcion s = new Suscripcion(EstadoSuscripcion.PENDIENTE, tipoSuscripcion, fechaFormateada, c);
        try {
            t.begin();
            em.persist(s);
            t.commit();
            // Crear el cuerpo del correo
            String cuerpoCorreo = "\n"
                    + "\n"
                    + "\n Estimado/a " + c.getNombre() + ","
                    + "\n Su suscripcion en Espotify ha sido creada y se encuentra en estado Pendiente."
                    + "\n"
                    + "\n Detalles de la Suscripcion:"
                    + "\n"
                    + "\n Tipo: " + tipoSuscripcion + ""
                    + "\n Precio: U$S " + String.format("%.2f", obtenerPrecio(tipoSuscripcion)) + ""
                    + "\n Fecha de creacion: " + fechaFormateada + ""
                    + "\n "
                    + "\n Gracias por preferirnos."
                    + "\n Saludos,Espotify"
                    + "\n "
                    + "\n ";

            String asunto = "[Espotify] Nueva Suscripcion";
            EmailUtil.enviarCorreo(c.getEmail(), asunto, cuerpoCorreo);
        } catch (Exception e) {
            //si sale mal rollback
            t.rollback();
        }
    }

    public List<RegistroAcceso> obtenerTodosLosRegistros() {
        List<RegistroAcceso> registros;
        String jpql = "SELECT r FROM RegistroAcceso r ORDER BY r.fechaAcceso DESC"; // Ordenar por fecha de acceso, del más reciente al más antiguo
        registros = em.createQuery(jpql, RegistroAcceso.class).getResultList();
        return registros;
    }

    public void crearRegistro(String ipUsuario, String urlAcceso, String browserUsuario, String soUsuario) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Logica.RegistroAcceso registro = new RegistroAcceso();
            registro.setIpUsuario(ipUsuario);
            registro.setUrlAcceso(urlAcceso);
            registro.setBrowserUsuario(browserUsuario);
            registro.setSoUsuario(soUsuario);

            // Obtener la fecha actual en formato dd/MM/yyyy
            LocalDate fechaActual = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fechaActual.format(formatter);

            registro.setFechaAcceso(fechaFormateada); // Registrar la fecha actual

            em.persist(registro); // Guardar en la base de datos
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private double obtenerPrecio(Suscripcion.TipoSuscripcion tipo) {
        double precio = 0;
        switch (tipo) {
            case SEMANAL:
                precio = 3.99;
                break;
            case MENSUAL:
                precio = 14.99;
                break;

            case ANUAL:
                precio = 159.99;
                break;
            default:
        }
        return precio;
    }

    public String obtenerEstadoSus(String nickname) {

        Suscripcion s = obtenerSuscripcion(nickname);
        if (s != null) {
            return s.getEstado().toString();
        }
        return null;
    }

    public Boolean ClienteTieneSuscripcion(String nickname) {
        Suscripcion s = obtenerSuscripcion(nickname);
        return s != null;
    }

    public DtoSuscripcion obtenerDTOSuscripcion(String nickname) {
        Suscripcion s = obtenerSuscripcion(nickname);
        if (s != null) {
            DtoSuscripcion DTOS = new DtoSuscripcion(s.getEstado().toString(), s.getTipo().toString(), s.getClienteNickname(), s.getFecha());
            return DTOS;
        } else {
            return null;
        }
    }

    public void guardarImagenDesdeWeb(byte[] imagenBytes, String nick) {
        String rutaDestino = null;

        if (imagenBytes == null || imagenBytes.length == 0) {
            System.out.println("No imagen.");
            return;
        }

        try {
            // Definir la ruta destino
            rutaDestino = CARPETA_IMAGEN + "FotoUsr_" + nick + ".jpg";

            // Crear directorio si no existe
            File directorio = new File(CARPETA_IMAGEN);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            // Crear archivo destino
            File archivoDestino = new File(rutaDestino);

            // Guardar el archivo desde el arreglo de bytes
            try (FileOutputStream outputStream = new FileOutputStream(archivoDestino)) {
                outputStream.write(imagenBytes);
            }
        } catch (IOException ex) {
            rutaDestino = null; // En caso de error, devolver null
            System.err.println("Error al guardar la imagen: " + ex.getMessage());
        }
    }

    public void guardarImagenDesdeWebLista(byte[] imagenBytes, String nick, String Lista) {
        String rutaDestino = null;

        if (imagenBytes == null || imagenBytes.length == 0) {
            System.out.println("No imagen.");
            return;
        }

        try {
            // Definir la ruta destino
            rutaDestino = CARPETA_IMAGEN + "FotoLista_" + nick + "_" + Lista + ".jpg";

            // Crear directorio si no existe
            File directorio = new File(CARPETA_IMAGEN);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            // Crear archivo destino
            File archivoDestino = new File(rutaDestino);

            // Guardar el archivo desde el arreglo de bytes
            try (FileOutputStream outputStream = new FileOutputStream(archivoDestino)) {
                outputStream.write(imagenBytes);
            }
        } catch (IOException ex) {
            rutaDestino = null; // En caso de error, devolver null
            System.err.println("Error al guardar la imagen: " + ex.getMessage());
        }
    }

    //CARGAR IMAGEN EN EL WEB.
    public byte[] cargarImagenCliWeb(String ruta) {
        File archivoImagen = new File(ruta); // Crear un archivo con la ruta especificada

        if (!archivoImagen.exists()) {
            System.out.println("La imagen no existe en la ruta especificada: " + ruta);
            return null;
        }

        try (FileInputStream inputStream = new FileInputStream(archivoImagen); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesLeidos;

            // Leer el archivo y escribir los datos en el ByteArrayOutputStream
            while ((bytesLeidos = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesLeidos);
            }

            // Retornar el contenido como un array de bytes
            return baos.toByteArray();
        } catch (IOException ex) {
            System.err.println("Error al cargar la imagen: " + ex.getMessage());
            return null;
        }
    }
    
    public byte[] obtenerMp3(String ruta){
        System.out.println("Ruta recibida en obtenerMp3: " + ruta);
        File archivoImagen = new File(ruta); // Crear un archivo con la ruta especificada

        if (!archivoImagen.exists()) {
            System.out.println("El audio no existe en la ruta especificada:" + ruta);
            return null;
        }

        try (FileInputStream inputStream = new FileInputStream(archivoImagen); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesLeidos;

            // Leer el archivo y escribir los datos en el ByteArrayOutputStream
            while ((bytesLeidos = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesLeidos);
            }

            // Retornar el contenido como un array de bytes
            return baos.toByteArray();
        } catch (IOException ex) {
            System.err.println("Error al cargar la imagen: " + ex.getMessage());
            return null;
        }
    }

}
