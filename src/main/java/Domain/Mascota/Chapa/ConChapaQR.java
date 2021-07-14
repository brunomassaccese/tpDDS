package Domain.Mascota.Chapa;

import Domain.EstrategiaDeNotificacion.Notificacion;
import Domain.Mascota.Mascota;
import Domain.Persona.Contacto;

public class ConChapaQR implements Chapa {

    @Override
    public void notificar(Mascota mascota, Formulario formulario){ //TAMBIEN SE PODRIAN PONER EL ESTADO DE LA MASCOTA
        String mensaje = "Queremos comunicarnos con usted, para decirle que su mascota " + mascota.getNombre() + " fue encontrada por " + formulario.getNombre() + formulario.getApellido() + "podemos comunicarte con el por medio de este contacto : " + formulario.getContacto();
        Contacto contactoDuenioDeMascota = mascota.getDuenio()
                                                  .obtenerContactoPorDefecto();
        Notificacion nuevaNotificacion = new Notificacion(contactoDuenioDeMascota.getFormaDeContacto());
        nuevaNotificacion.ejecutarAviso(contactoDuenioDeMascota, mensaje);
    }
}
