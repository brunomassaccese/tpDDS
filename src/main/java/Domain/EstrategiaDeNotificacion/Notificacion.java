package Domain.EstrategiaDeNotificacion;

public class Notificacion{

    // Valor por defecto (comportamiento por defecto): NotificacionSMS
    private Strategy strategy = new NotificacionSMS();

    //PARA LA PRUEBA
    public InfoContacto contacto = new InfoContacto("42323","ahisd@hotmail.com"); // LO CAMBIE A PUBLIC CONTACTO Y MENSAJE CAMBIA ALGO
    public String mensaje = "Mensaje de prueba";

    public void ejecutarAviso() {// ME DA UN ERROR NO SE POR QUE? PERO CUANDO LO CAMBIO A Strategy.enviarAviso(this.contacto, this.mensaje); ME DA BIEN
        this.strategy.enviarAviso(this.contacto, this.mensaje);
    }
    public void setStrategy(Strategy newStrategy) {
        this.strategy = newStrategy;
    }
    public Strategy getStrategy() {
        return this.strategy;
    }
}
