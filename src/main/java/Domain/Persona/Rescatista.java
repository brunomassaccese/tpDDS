package Domain.Persona;

import hogaresAPI.EjecutarHogares;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Rescatista extends Persona {

    public Rescatista (String nombreRec, String apellidoRec, LocalDate fechaNac,
                       String direccionRec, TipoDeDocumento dniRec, List<Contacto> listaContactos){
        nombre = nombreRec;
        apellido = apellidoRec;
        fechaNacimiento = fechaNac;
        direccion = direccionRec;
        dni = dniRec;
        contactos = listaContactos;
    }


    public void buscarHogarTransito() throws IOException {
        EjecutarHogares.solicitarHogares();
    }

}
