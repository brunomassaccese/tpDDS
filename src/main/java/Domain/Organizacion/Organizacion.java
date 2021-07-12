package Domain.Organizacion;

import Domain.EstrategiaDeNotificacion.Notificacion;
import Domain.Mascota.Mascota;
import Domain.Mascota.Publicacion;
import Domain.Persona.Contacto;
import Domain.Persona.TipoDeDocumento;
import Domain.Persona.Usuario;
import Domain.Publicacion.PublicacionAdoptante;
import Domain.Publicacion.PublicacionMascotaPerdida;
import Domain.Publicacion.PublicacionMascotaEnAdopcion;

import java.time.LocalDateTime;
import java.util.List;

public class Organizacion {
    private List<String> caracteristicas = null;
    private List<Usuario> voluntarios = null;
    private List<String> preguntasAdoptantes = null;
    private List<PublicacionMascotaPerdida> publicacionesMascotaPerdidas = null;
    private List<PublicacionMascotaEnAdopcion> publicacionesMascotaEnAdopcion = null;
    private List<PublicacionAdoptante> publicacionesAdoptantes = null;

    //E2.P3
    public void generarVoluntario(String nombre, String apellido,
                                  LocalDateTime fechaNacimiento, String direccion,
                                  TipoDeDocumento dni, List <Contacto> contactos,
                                  String nombreUsuario, String password){
        Usuario nuevoVoluntario = new Usuario(nombre, apellido, fechaNacimiento, direccion, dni, contactos,
                nombreUsuario, password, "VOLUNTARIO");     //Agregar organización?

        this.voluntarios.add(nuevoVoluntario);
    }

    public void agregarCaracteristica(String nuevaCaracteristica){
        caracteristicas.add(nuevaCaracteristica);
    }

    public void agregarPreguntaAdoptantes(String nuevaPregunta){
        this.preguntasAdoptantes.add(nuevaPregunta);
    }

    public void eliminarPreguntaAdoptantes(String preguntaAEliminar){
        this.preguntasAdoptantes = (List<String>) this.preguntasAdoptantes.stream().filter(
                                                    pregunta -> pregunta != preguntaAEliminar);
    }

    public List<PublicacionMascotaPerdida> buscarMascota(){
        return this.publicacionesMascotaPerdidas;
    }

    public void agregarPublicacionMascotaPerdida(PublicacionMascotaPerdida nuevaPublicacion){
        publicacionesMascotaPerdidas.add(nuevaPublicacion);
    }

    public void agregarPublicacionMascotaEnAdopcion(PublicacionMascotaEnAdopcion nuevaPublicacion){
        publicacionesMascotaEnAdopcion.add(nuevaPublicacion);
    }

    //E3.P3
    public void notificarInteresadoEnAdopcion(Mascota mascota){
        String mensaje = "Hay un interesado en adoptar a " + mascota.getNombre();
        Contacto contactoDuenioDeMascota = mascota.getDuenio().obtenerContactoPorDefecto();
        Notificacion nuevaNotificacion = new Notificacion(contactoDuenioDeMascota.getFormaDeContacto());

        nuevaNotificacion.ejecutarAviso(contactoDuenioDeMascota, mensaje);
    }

    public void agregarPublicacionAdoptante(PublicacionAdoptante nuevaPublicacion){
        publicacionesAdoptantes.add(nuevaPublicacion);
    }

    public void aprobarAdoptante(PublicacionAdoptante publicacionAdoptante) {
        //TODO
    }

    public void solicitarPublicacionEnAdopcion(Mascota mascota, Usuario duenio, List<String> preguntas, List<String> respuestas) {
        Integer id = this.publicacionesMascotaPerdidas.size() + 1;
        PublicacionMascotaEnAdopcion nuevaPublicacion = new PublicacionMascotaEnAdopcion(duenio, mascota, id, preguntas, respuestas);
        this.agregarPublicacionMascotaEnAdopcion(nuevaPublicacion);
    }

    public void aprobarPublicacionMascotaEnAdopcion(Integer idPublicacion) {
        //this.publicacionesMascotaEnAdopcion = (List<PublicacionMascotaEnAdopcion>) this.publicacionesMascotaEnAdopcion.stream().map(publicacion -> publicacion.aprobar(idPublicacion));

        PublicacionMascotaEnAdopcion nuevaPublicacion = (PublicacionMascotaEnAdopcion) this.publicacionesMascotaEnAdopcion.stream().filter(publicacion -> publicacion.getId() == idPublicacion);
        this.publicacionesMascotaEnAdopcion.remove(nuevaPublicacion);
        nuevaPublicacion.aprobar();
        this.publicacionesMascotaEnAdopcion.add(nuevaPublicacion);
        //VER FORMA DE REFACTORIZAR ESTO
    }

    public void modificarPreguntaAdoptantes(String viejaPregunta, String nuevaPregunta) {
        this.eliminarPreguntaAdoptantes(viejaPregunta);
        this.agregarPreguntaAdoptantes(nuevaPregunta);
    }
}

/*

import java.util.ArrayList;

public class Organizacion {

    public String nombre;
    public ArrayList<String> preguntas;
    public ArrayList<Publicacion> publicacionesPendientes;
    public ArrayList<Publicacion> publicacionesAceptadas;

    public Organizacion(){
        this.preguntas = new ArrayList<>();
        this.publicacionesPendientes = new ArrayList<>();
        this.publicacionesAceptadas = new ArrayList<>();
    }

    public void agregarPublicacion(ArrayList<Publicacion> publicaciones, Publicacion publicacion){ publicaciones.add(publicacion); } //AGREGA A UNA DE LAS LISTAS SIRVE PARA EL PUNTO 1

    public void agregarPregunta(String pregunta) { preguntas.add(pregunta); } //LA ORGANIZACION PUEDE AGREGAR SUS PREGUNTAS PUNTO 2

    public void verTodasLasPreguntas(){ for (String s : preguntas) System.out.println(s); }

    public int cantidadDePreguntas(){ return preguntas.size(); }

    public void modificarPregunta(int lugar,String nuevaPregunta){ preguntas.set(lugar,nuevaPregunta); } // LA ORGANIZACION PUEDE MODIFICAR LA PREGUNTA PERO NO LA PUBLICACION OSEA LA PUBLICACION SE GUARDA CON LAS RESPUESTAS Y PREGUNTAS ANTERIORES NO VA MODIFICAR A LAS PREGUNTAS DE LAS PUBLICACIONES QUE FUERON CONTESTADAS ANTES PUNTO 2

    public void verPublicaciones(ArrayList<Publicacion> publicaciones){

        for (Publicacion publicacion : publicaciones) {

            System.out.println(publicacion.usuario.nombre);
            System.out.println(publicacion.mascota.nombre);

            for(int i=0;i<publicacion.cantidad(publicacion.preguntas) ;i++){
                System.out.println(i+1 + ")" + publicacion.preguntas.get(i));
                System.out.println(publicacion.respuestas.get(i));
            }
        }
    }

    //PUNTO 3 ACA HAY Q SEGUIR CON LA PARTE DE NOTIFICAR A LA PERSONA YO QUERIA MANDAR ESTE MENSAJE AL USUARIO
    //queria guardarlo como una lista de mensajes para el usuario no se si se puede
    public void notificar (Publicacion publicacion, Usuario usuarioInteresado){
        System.out.println("Nos comunicamos con usted para decirle que el usuario "+ usuarioInteresado.nombre + "esta interesado en adoptar a " + publicacion.mascota.nombre);
    }
}

*/