package Domain.Persona;

import java.time.LocalDateTime;
import java.util.List;

public class Rescatista extends Persona{
    public Rescatista(String nombre, String apellido, LocalDateTime fechaNacimiento, String direccion, TipoDeDocumento dni, List<Contacto> contactos) {
        super(nombre, apellido, fechaNacimiento, direccion, dni, contactos);
    }
}
