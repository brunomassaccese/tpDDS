package Domain.Organizacion;

import Domain.EstrategiaDeNotificacion.Notificacion;
import Domain.Mascota.Mascota;
import Domain.Persona.Contacto;
import Domain.Persona.TipoDeDocumento;
import Domain.Persona.Usuario;
import Domain.Publicacion.PublicacionAdoptante;
import Domain.Publicacion.PublicacionMascotaEnAdopcion;
import Domain.Publicacion.PublicacionMascotaPerdida;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table
public class Organizacion {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombre;
    @Transient
    private List<String> caracteristicas = null;
    @Transient
    private List<Usuario> voluntarios = null;
    @Transient
    private List<String> preguntasAdoptantes = null;
    @Transient
    private List<PublicacionMascotaPerdida> publicacionesMascotaPerdidas = null;
    @Transient
    private List<PublicacionMascotaEnAdopcion> publicacionesMascotaEnAdopcion = null;
    @Transient
    private List<PublicacionAdoptante> publicacionesAdoptantes = null;

    //E2.P3
    public void generarVoluntario(String nombre, String apellido,
                                  LocalDate fechaNacimiento, String direccion,
                                  TipoDeDocumento dni, List <Contacto> contactos,
                                  String nombreUsuario, String password){
        Usuario nuevoVoluntario = new Usuario(nombre, apellido, fechaNacimiento, direccion, dni, contactos, nombreUsuario, password, "VOLUNTARIO");     //Agregar organización?

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
        Timestamp newTimestamp = new Timestamp(System.currentTimeMillis());
        PublicacionMascotaEnAdopcion nuevaPublicacion = new PublicacionMascotaEnAdopcion(duenio, mascota, newTimestamp, preguntas, respuestas);
        this.agregarPublicacionMascotaEnAdopcion(nuevaPublicacion);
    }

    public void aprobarPublicacionMascotaEnAdopcion(Timestamp timestamp) {

        for(int i = 0; i < publicacionesMascotaEnAdopcion.size(); i++){
            PublicacionMascotaEnAdopcion publi = publicacionesMascotaEnAdopcion.get(i);
            if(publicacionesMascotaEnAdopcion.get(i).estado() == false && publi.getTimestamp() == timestamp) {
                publi.aprobar();
                publicacionesMascotaEnAdopcion.remove(i);
                publicacionesMascotaEnAdopcion.add(i, publi);
            }
        }

        PublicacionMascotaEnAdopcion nuevaPublicacion = (PublicacionMascotaEnAdopcion) this.publicacionesMascotaEnAdopcion.stream().filter(publicacion -> publicacion.getTimestamp() == timestamp);
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
