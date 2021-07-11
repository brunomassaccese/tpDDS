package Domain.Mascota.Chapa;

import Domain.EstrategiaDeNotificacion.Notificacion;
import Domain.Mascota.Mascota;
import Domain.Persona.Rescatista;

public class ConChapaQR implements Chapa { //FALTARIA MOSTRAR LOS DATOS DEL RESCATISTA ASI LA PERSONA SE PUEDE COMUNICAR CON EL

    @Override
    public void notificar(Mascota mascota, Rescatista rescatista){ //TAMBIEN SE PODRIAN PONER EL ESTADO DE LA MASCOTA
        Notificacion notificacion = new Notificacion();
        notificacion.mensaje = "Queremos comunicarnos con usted, para decirle que su mascota fue encontrada por " + rescatista.nombre; //FALTARIAN PONER MAS DATOS DEL RESCATISTA
        notificacion.contacto = mascota
                                .duenio
                                .contactos.get(0)
                                .InformacionDeContacto;
        notificacion.ejecutarAviso();
    }
}
