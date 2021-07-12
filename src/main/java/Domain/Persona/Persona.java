package Domain.Persona;

import Domain.Publicacion.PublicacionMascotaPerdida;

import Domain.Organizacion.Organizacion;
import Domain.EstrategiaDeNotificacion.Notificacion;

import java.time.LocalDateTime;
import java.util.List;

public class Persona {
    public String nombre;
    public  String apellido;
    //Lista de mascotas
    public LocalDateTime fechaNacimiento;
    public String direccion;
    public TipoDeDocumento dni;
    public List <Contacto> contactos;

    public Persona(String nombre, String apellido, LocalDateTime fechaNacimiento, String direccion, TipoDeDocumento dni, List<Contacto> contactos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.dni = dni;
        this.contactos = contactos;
    }

    public Contacto obtenerContactoPorDefecto(){
        return (Contacto) this.contactos.stream().filter(contacto -> contacto.isContactoPorDefecto());
        //VER CASTEO
    }

    //E2.P5
    public List<PublicacionMascotaPerdida> buscarMascotaPerdida(Organizacion organizacion){
        return organizacion.buscarMascota();
    }

}
