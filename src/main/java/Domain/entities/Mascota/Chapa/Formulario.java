package Domain.entities.Mascota.Chapa;

import Domain.entities.Mascota.Foto;
import Domain.entities.Persona.Contacto;
import Domain.entities.Persona.TipoDeDocumento;

import java.time.LocalDateTime;
import java.util.List;

public class Formulario {

    private String nombre;
    private String apellido;
    private LocalDateTime fechaNacimiento;
    private TipoDeDocumento dni;
    private String direccion;
    private Contacto contacto;
    private List<Foto> fotos;
    private String estadoDeLaMascota;
    private String lugarDondeSeEncontro;

    public Formulario(String nombre, String apellido, String direccion, String estadoDeLaMascota, String lugarDondeSeEncontro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.estadoDeLaMascota = estadoDeLaMascota;
        this.lugarDondeSeEncontro = lugarDondeSeEncontro;
    }

    public void mostrarDatos(){
        System.out.println("Encontrado por: " + this.nombre);
        System.out.println("Fue encontrado en: " + this.lugarDondeSeEncontro);
        System.out.println("La mascota fue encontrada : " + this.estadoDeLaMascota);
        this.verFotos();
    }

    public void verDatosSensibles(){
        System.out.println("Nombre completo del rescatista: " + this.nombre + this.apellido);
        System.out.println("Direccion del rescatista : " + this.direccion);
        System.out.println("Contacto : " + this.contacto);
    }

    public void verFotos(){
        for (Foto foto : fotos){
            System.out.println(foto);
        }
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

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoDeDocumento getDni() {
        return dni;
    }

    public void setDni(TipoDeDocumento dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        direccion = direccion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public String getEstadoDeLaMascota() {
        return estadoDeLaMascota;
    }

    public void setEstadoDeLaMascota(String estadoDeLaMascota) {
        this.estadoDeLaMascota = estadoDeLaMascota;
    }

    public String getLugarDondeSeEncontro() {
        return lugarDondeSeEncontro;
    }

    public void setLugarDondeSeEncontro(String lugarDondeSeEncontro) {
        this.lugarDondeSeEncontro = lugarDondeSeEncontro;
    }

}
