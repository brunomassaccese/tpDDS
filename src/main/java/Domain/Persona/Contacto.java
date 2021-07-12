package Domain.Persona;

import Domain.EstrategiaDeNotificacion.Strategy;

public class Contacto {
    private Strategy formaDeContacto = null;
    private String nombre = null;
    private String apellido = null;
    private String telefono = null;
    private String email = null;
    private  boolean contactoPorDefecto;

    public Contacto(Strategy formaDeContacto, String nombre, String apellido, String telefono, String email, boolean contactoPorDefecto) {
        this.formaDeContacto = formaDeContacto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.contactoPorDefecto = contactoPorDefecto;
    }

    public Strategy getFormaDeContacto() {
        return this.formaDeContacto;
    }

    public void setFormaDeContacto(Strategy formaDeContacto) {
        this.formaDeContacto = formaDeContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isContactoPorDefecto() {
        return contactoPorDefecto;
    }

    public void setContactoPorDefecto(boolean contactoPorDefecto) {
        this.contactoPorDefecto = contactoPorDefecto;
    }
}
