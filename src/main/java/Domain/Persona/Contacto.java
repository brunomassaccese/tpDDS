package Domain.Persona;

import Domain.EstrategiaDeNotificacion.Strategy;

import javax.persistence.*;

@Entity
@Table(name = "contacto")
public class Contacto {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "forma_de_contacto_id")
    private Strategy formaDeContacto = null;

    @Column(name = "nombre")
    private String nombre = null;

    @Column(name = "apellido")
    private String apellido = null;

    @Column(name = "telefono")
    private String telefono = null;

    @Column(name = "email")
    private String email = null;

    @Column(name = "contactoPorDefecto")
    private boolean contactoPorDefecto;

    @ManyToOne
    @JoinColumn(name="persona_id", referencedColumnName = "id")
    private Persona idPersona;

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