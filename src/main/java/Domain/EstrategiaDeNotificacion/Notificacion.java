package Domain.EstrategiaDeNotificacion;

import Domain.Persona.Contacto;
import Domain.Persona.Persona;

public class Notificacion{

    // Valor por defecto (comportamiento por defecto): NotificacionSMS
    private Strategy strategy = new NotificacionSMS();

    //PARA LA PRUEBA
    //private InfoContacto contacto = new InfoContacto("42323","ahisd@hotmail.com");
    //private String mensaje = "Mensaje de prueba";

    public Notificacion(Strategy formaDeContacto) {
        strategy = formaDeContacto;
    }

    public void ejecutarAviso(Contacto destinatario, String mensaje) {
        Strategy.enviarAviso(destinatario, mensaje);
    }

    public void setStrategy(Strategy newStrategy) {
        this.strategy = newStrategy;
    }

    public Strategy getStrategy() {
        return this.strategy;
    }
}