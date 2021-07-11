package Domain.Persona;

import Domain.EstrategiaDeNotificacion.InfoContacto;

public class Contacto {
    public InfoContacto InformacionDeContacto;

    public Contacto(InfoContacto contacto){ this.InformacionDeContacto = contacto; }

    public Contacto(String telefono, String mail) {
        this.InformacionDeContacto = new InfoContacto(telefono,mail);
    }

    public void verContacto(){ InformacionDeContacto.mostrarInfo(); }
}
