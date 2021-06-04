package Domain.EstrategiaDeNotificacion;

public interface Strategy {
    public void enviarAviso(this.contacto, this.mensaje);
}
