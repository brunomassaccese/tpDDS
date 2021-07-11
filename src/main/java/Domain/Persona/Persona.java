package Domain.Persona;

import Domain.Organizacion.Organizacion;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Persona {
   public String nombre;
    public String apellido;
    public LocalDateTime fechaNacimiento;       //FALTA ASIGNAR
    public String direccion;
    public TipoDeDocumento dni;                 //FALTA ASIGNAR
    public ArrayList<Contacto> contactos;

    public Persona(){
     this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto){
        contactos.add(contacto);
    }

    // ENTREGA 2 PUNTO 5
    public void buscarMascota(Organizacion organizacion){ // BUSCA A LA MASCOTA EN LA ORGANIZACION
        organizacion.verPublicaciones(organizacion.publicacionMascotasPerdidas);
        organizacion.elegirPublicacionDeMascotaPerdida();
    }
    //ENTREGA 2 PUNTO 5
    public void verContactos(){
        for(Contacto contacto : contactos){
            contacto.verContacto();
        }
    }
}
