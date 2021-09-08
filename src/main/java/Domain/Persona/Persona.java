package Domain.Persona;

import Domain.Mascota.Chapa.Formulario;
import Domain.Mascota.Mascota;
import Domain.Organizacion.Organizacion;
import Domain.Publicacion.PublicacionMascotaPerdida;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Persona {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "apellido")
    public  String apellido;

    @Column(name = "fechaDeNacimiento", columnDefinition = "DATE")
    public LocalDate fechaNacimiento;

    @OneToOne
    public Direccion direccion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoDocumento")
    public TipoDeDocumento tipoDeDocumento;

    @Column(name = "documento")
    public String documento;

    @OneToMany(mappedBy = "idPersona", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    public List<Contacto> contactos;

    public Persona(String nombre, String apellido, LocalDate fechaNacimiento, Direccion direccion, TipoDeDocumento tipoDocumento, String documento, List<Contacto> contactos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.tipoDeDocumento = tipoDocumento;
        this.documento = documento;
        this.contactos = contactos;
    }

    public Contacto obtenerContactoPorDefecto(){
        return (Contacto) this.contactos.stream().filter(contacto -> contacto.isContactoPorDefecto());
        //VER CASTEO
    }

    //E2.P5
    public List<PublicacionMascotaPerdida> buscarMascotaPerdida(Organizacion organizacion){
        return organizacion.buscarMascota();
    }

    public String getNombre() { return this.nombre; }

    public void notificarMascotaEncontrada(Mascota mascota) throws IOException {
        Formulario nuevoFormulario = this.llenarFormulario();
        mascota.getChapa().notificar(mascota, nuevoFormulario);
    }

    public Formulario llenarFormulario(){ // SE PUEDE LLENAR AUTOMATICAMENTE O SE PUEDE LLENAR CON UN SCANNER
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresar nombre : ");
        String nombre = entrada.nextLine();
        System.out.println("Ingresar apellido : ");
        String apellido = entrada.nextLine();
        System.out.println("Ingresar direccion : ");
        String direccion = entrada.nextLine();
        System.out.println("Ingresar estado de la mascota : ");
        String estadoDeLaMascota = entrada.nextLine();
        System.out.println("Ingresar el lugar en donde encontro a la mascota : ");
        String lugarDondeSeEncontro = entrada.nextLine();
        Formulario formulario = new Formulario(nombre,apellido,direccion,estadoDeLaMascota,lugarDondeSeEncontro);
        System.out.println("Ingresar un foto de la mascota : ");//FALTA COMO INGRESAR LA FOTO
        System.out.println("Ingresar un contacto para comunicarse con usted: "); // FALTA COMO INGRESAR EL CONTACTO EN ESTE CASO SOLO INGRESA EL CONTACTO POR DEFECTO
        formulario.setContacto(this.obtenerContactoPorDefecto());
        return formulario;
    }
}