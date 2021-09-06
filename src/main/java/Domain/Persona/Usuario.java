package Domain.Persona;

import Domain.EstrategiaDeNotificacion.Notificacion;
import Domain.EstrategiaDeNotificacion.Strategy;
import Domain.Mascota.Mascota;
import Domain.Organizacion.Caracteristica;
import Domain.Organizacion.Organizacion;
import Domain.Organizacion.Pregunta;
import Domain.Organizacion.Respuesta;
import Domain.Publicacion.Comodidad;
import Domain.Publicacion.PublicacionAdoptante;
import Domain.Publicacion.PublicacionMascotaPerdida;

import java.time.LocalDate;
import java.util.List;

//@Entity
//@Table
public class Usuario extends Persona implements Strategy {
    //@Id
    //@GeneratedValue
    private int id;
    //@Transient
    private String nombreUsuario;

    //@Transient
    private String password;

    //@Transient
    //@OneToMany(mappedBy = "duenio", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Mascota> mascotas = null;

    //@Transient
    private String perfil = null;

    public Usuario(String nombre, String apellido, LocalDate fechaNacimiento, String direccion, TipoDeDocumento dni, List<Contacto> contactos, String nombreUsuario, String password, String perfil) {
        super(nombre, apellido, fechaNacimiento, direccion, dni, contactos);
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.perfil = perfil;
    }

    public void registrarMascota(Mascota mascota){
        this.mascotas.add(mascota);
    }

    //E2.P3
    public void aprobarPublicacion(PublicacionMascotaPerdida publicacion, Organizacion organizacion){
        if(this.perfil.equals("VOLUNTARIO"))
            organizacion.agregarPublicacionMascotaPerdida(publicacion);
    }

    public void contactarRescatista(PublicacionMascotaPerdida publicacion){
        Contacto contactoDestino = publicacion.getFormulario()
                                              .getContacto();
        //Contacto contactoDestino = publicacion.rescatista.obtenerContactoPorDefecto();
        String mensaje = "Se encontró la mascota " + publicacion.getMascotaPerdida()
                                                                .getChapa();
        Notificacion nuevaNotificacion = new Notificacion(contactoDestino.getFormaDeContacto());

        nuevaNotificacion.ejecutarAviso(contactoDestino, mensaje);
    }

    //E3.P1
    public void darEnAdopcion(Mascota miMascota, Organizacion organizacion, List<Pregunta> preguntas, List<Respuesta> respuestas){
        organizacion.solicitarPublicacionEnAdopcion(miMascota, this, preguntas, respuestas);
    }

    //E3.P4
    public void quieroAdoptar(List<Caracteristica> preferencias, List<Comodidad> comodidades, Organizacion organizacion){
        PublicacionAdoptante nuevaPublicacion = new PublicacionAdoptante(this, preferencias, comodidades);
        organizacion.agregarPublicacionAdoptante(nuevaPublicacion);
    }

}