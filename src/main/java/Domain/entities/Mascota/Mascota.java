package Domain.entities.Mascota;

import Domain.entities.Mascota.Chapa.Chapa;
import Domain.entities.Organizacion.Caracteristica;
import Domain.entities.Persona.Usuario;
import Domain.entities.Publicacion.Comodidad;
import Domain.repositories.testMemoData.EntidadPersistente;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota extends EntidadPersistente {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nombre")
    private String nombre;              //hecho

    @Column(name = "apodo")
    private String apodo;               //hecho

    @Column(name = "fechaDeNacimiento", columnDefinition = "DATE")
    public LocalDate fechaNacimiento;                               //hecho

    @Column(name = "sexo")
    private String sexo;                                            //hecho
    @Enumerated
    private Estado estado;

    @Column(name = "descripcion")
    private String descripcion;                                     //hecho
    @Column
    private String chapita;

    @OneToMany(mappedBy = "mascota", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Foto> fotos = null;                                //hecho

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Caracteristica> caracteristicas = null;            //hecho

    @Transient
    private Chapa chapa;

    @ManyToOne
    @JoinColumn(name = "duenio_id", referencedColumnName = "id")
    private Usuario duenio = null;

    @Column(name = "tipo")
    private String tipo;                //hecho

    @OneToMany(mappedBy = "id", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY) //encontrame como "id" en la Clase Comodidad
    private List<Comodidad> necesidades = null;


    public Mascota(String tipo, String nombre, String apodo, LocalDate fechaNacimiento, String sexo, Estado estado, String descripcion, List<Foto> fotos, List<Caracteristica> caracteristicas, Chapa chapa, Usuario duenio, List<Comodidad> necesidades) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.caracteristicas.addAll(caracteristicas);
        this.chapa = chapa;
        this.duenio = duenio;
        this.necesidades.addAll(necesidades);
    }


    public String getNombre() {
        return nombre;
    }

    public Chapa getChapa() {
        return chapa;
    }

    public Usuario getDuenio() {
        return duenio;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public List<Comodidad> getNecesidades() {
        return necesidades;
    }
}