package Domain.entities.Mascota.Chapa;

import Domain.entities.EstrategiaDeNotificacion.Notificacion;
import Domain.entities.Mascota.Mascota;
import Domain.entities.Persona.Contacto;

import java.io.IOException;

public class ConChapaQR implements Chapa {

    @Override
    public void notificar(Mascota mascota, Formulario formulario) throws IOException { //TAMBIEN SE PODRIAN PONER EL ESTADO DE LA MASCOTA
        String mensaje = "Queremos comunicarnos con usted, para decirle que su mascota " + mascota.getNombre() + " fue encontrada por " + formulario.getNombre() + formulario.getApellido() + "podemos comunicarte con el por medio de este contacto : " + formulario.getContacto();
        Contacto contactoDuenioDeMascota = mascota.getDuenio()
                                                  .obtenerContactoPorDefecto();
        Notificacion nuevaNotificacion = new Notificacion(contactoDuenioDeMascota.getFormaDeContacto());
        nuevaNotificacion.ejecutarAviso(contactoDuenioDeMascota, mensaje);
    }
}
