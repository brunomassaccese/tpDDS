package Domain.Persona;

import Domain.EstrategiaDeNotificacion.Notificacion;
import Domain.EstrategiaDeNotificacion.Strategy;
import Domain.Mascota.Mascota;
import Domain.Organizacion.Organizacion;
import Domain.Publicacion.PublicacionAdoptante;
import Domain.Publicacion.PublicacionMascotaPerdida;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

public class Usuario extends Persona implements Strategy {

    private String nombreUsuario;


    private String password;

    @OneToMany(mappedBy = "duenio", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Mascota> mascotas = null;


    private String perfil = null;

    public Usuario(String nombre, String apellido, LocalDateTime fechaNacimiento, String direccion, TipoDeDocumento dni, List<Contacto> contactos, String nombreUsuario, String password, String perfil) {
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
    public void darEnAdopcion(Mascota miMascota, Organizacion organizacion, List<String> preguntas, List<String> respuestas){
        organizacion.solicitarPublicacionEnAdopcion(miMascota, this, preguntas, respuestas);
    }

    //E3.P4
    public void quieroAdoptar(List<String> preferencias, Organizacion organizacion){
        PublicacionAdoptante nuevaPublicacion = new PublicacionAdoptante(preferencias);
        organizacion.agregarPublicacionAdoptante(nuevaPublicacion);
    }

}