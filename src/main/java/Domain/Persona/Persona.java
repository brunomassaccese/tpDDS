package Domain.Persona;

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

}
