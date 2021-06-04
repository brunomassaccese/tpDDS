package Domain.EstrategiaDeNotificacion;

public class Notificacion{

    // Valor por defecto (comportamiento por defecto): NotificacionSMS
    private Strategy strategy = new NotificacionSMS();

    //PARA LA PRUEBA (ver)
    private InfoContacto contacto = new InfoContacto();
    private String mensaje = "Mensaje de prueba";

    public void ejecutarAviso() {
        this.strategy.enviarAviso(this.contacto, this.mensaje);
    }
    public void setStrategy(Strategy newStrategy) {
        this.strategy = newStrategy;
    }
    public Strategy getStrategy() {
        return this.strategy;
    }
}