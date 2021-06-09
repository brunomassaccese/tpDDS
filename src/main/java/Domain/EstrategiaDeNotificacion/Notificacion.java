package Domain.EstrategiaDeNotificacion;

public class Notificacion{

    // Valor por defecto (comportamiento por defecto): NotificacionSMS
    private Strategy strategy = new NotificacionSMS();

    //PARA LA PRUEBA
    private InfoContacto contacto = new InfoContacto("42323","ahisd@hotmail.com");
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
