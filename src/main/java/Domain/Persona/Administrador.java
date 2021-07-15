package Domain.Persona;

import Domain.Organizacion.Organizacion;
import Domain.Publicacion.PublicacionAdoptante;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Administrador extends Usuario {


    public Administrador(String nombre, String apellido, LocalDateTime fechaNacimiento, String direccion, TipoDeDocumento dni, List<Contacto> contactos, String nombreUsuario, String password, String perfil) {
        super(nombre, apellido, fechaNacimiento, direccion, dni, contactos, nombreUsuario, password, perfil);
    }

    public void agregarCarcateristicas(Organizacion organizacion, String nuevaCaracteristica) {
        organizacion.agregarCaracteristica(nuevaCaracteristica);
    }

    //E3.P2
    public void agregarPregunta(Organizacion organizacion, String nuevaPregunta){
        organizacion.agregarPreguntaAdoptantes(nuevaPregunta);
    }

    //E3.P2
    public void EliminarPregunta(Organizacion organizacion, String preguntaAEliminar){
        organizacion.eliminarPreguntaAdoptantes(preguntaAEliminar);
    }

    //E3.P2
    public void modificarPregunta(Organizacion organizacion, String viejaPregunta, String nuevaPregunta){
        organizacion.modificarPreguntaAdoptantes(viejaPregunta, nuevaPregunta);
    }

    public void aprobarPublicacionAdoptante(Organizacion organizacion, PublicacionAdoptante publicacionAdoptante){
        organizacion.aprobarAdoptante(publicacionAdoptante);
    }

    public void aprobarPublicacionMascotaEnAdopcion(Organizacion organizacion, Timestamp timestamp){
        organizacion.aprobarPublicacionMascotaEnAdopcion(timestamp);
    }
}