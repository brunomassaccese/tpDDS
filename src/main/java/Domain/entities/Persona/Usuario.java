package Domain.entities.Persona;

import Domain.entities.EstrategiaDeNotificacion.Notificacion;
import Domain.entities.Organizacion.Organizacion;
import Domain.entities.Publicacion.Comodidad;
import Domain.entities.Publicacion.PublicacionAdoptante;
import Domain.entities.Mascota.Mascota;
import Domain.entities.Organizacion.Caracteristica;
import Domain.entities.Organizacion.Pregunta;
import Domain.entities.Organizacion.Respuesta;
import Domain.entities.Publicacion.PublicacionMascotaPerdida;
import Domain.repositories.testMemoData.EntidadPersistente;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("usuario")
public class Usuario extends Persona {

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Rol rol;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "duenio", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Mascota> mascotas = null;

    @Column(name = "perfil")
    private String perfil = null;

    public Usuario(String nombreUsuario, String apellido, LocalDate fechaNacimiento, Direccion direccion, TipoDeDocumento tipoDeDocumento, String documento, List<Contacto> contactos, String password, String perfil) {
        super(nombreUsuario, apellido, fechaNacimiento, direccion, tipoDeDocumento, documento, contactos);
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

    public void contactarRescatista(PublicacionMascotaPerdida publicacion) throws IOException {
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

    public String getPassword(){ //Mala seguridad :(
        return this.password;
    }
}