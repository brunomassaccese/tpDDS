package Domain.Persona;

import Domain.Organizacion.Caracteristica;
import Domain.Organizacion.Organizacion;
import Domain.Organizacion.Pregunta;
import Domain.Publicacion.PublicacionAdoptante;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("administrador")
public class Administrador extends Usuario {


    public Administrador(String nombre, String apellido, LocalDate fechaNacimiento, Direccion direccion, TipoDeDocumento dni, String documento, List<Contacto> contactos, String nombreUsuario, String password, String perfil) {
        super(nombre, apellido, fechaNacimiento, direccion, dni, documento, contactos, nombreUsuario, password, perfil);
    }

    public void agregarCarcateristicas(Organizacion organizacion, Caracteristica nuevaCaracteristica) {
        organizacion.agregarCaracteristica(nuevaCaracteristica);
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