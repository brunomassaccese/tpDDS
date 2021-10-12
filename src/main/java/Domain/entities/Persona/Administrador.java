package Domain.entities.Persona;

import Domain.entities.Organizacion.Organizacion;
import Domain.entities.Publicacion.PublicacionAdoptante;
import Domain.entities.Organizacion.Caracteristica;
import Domain.entities.Organizacion.Pregunta;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("administrador")
public class Administrador extends Usuario {


    public Administrador(String nombre, String apellido, LocalDate fechaNacimiento, Direccion direccion, TipoDeDocumento dni, String documento, List<Contacto> contactos, String nombreUsuario, String password, String perfil) {
        super(nombre, apellido, fechaNacimiento, direccion, dni, documento, contactos, password, perfil);
    }

    public void agregarCarcateristicas(String nuevaCaracteristica) {
        new Caracteristica(nuevaCaracteristica);
    }

    //E3.P2
    public void agregarPregunta(Organizacion organizacion, Pregunta nuevaPregunta){
        organizacion.agregarPreguntaAdoptantes(nuevaPregunta);
    }

    //E3.P2
    public void EliminarPregunta(Organizacion organizacion, Pregunta preguntaAEliminar){
        organizacion.eliminarPreguntaAdoptantes(preguntaAEliminar);
    }

    //E3.P2
    public void modificarPregunta(Organizacion organizacion, Pregunta viejaPregunta, Pregunta nuevaPregunta){
        organizacion.modificarPreguntaAdoptantes(viejaPregunta, nuevaPregunta);
    }

    public void aprobarPublicacionAdoptante(Organizacion organizacion, PublicacionAdoptante publicacionAdoptante){
        organizacion.aprobarAdoptante(publicacionAdoptante);
    }

    public void aprobarPublicacionMascotaEnAdopcion(Organizacion organizacion, Timestamp timestamp){
        organizacion.aprobarPublicacionMascotaEnAdopcion(timestamp);
    }
}