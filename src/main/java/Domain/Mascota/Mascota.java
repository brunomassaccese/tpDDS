package Domain.Mascota;

import Domain.Mascota.Chapa.Chapa;
import Domain.Organizacion.Caracteristica;
import Domain.Persona.Usuario;
import Domain.Publicacion.Comodidad;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apodo")
    private String apodo;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "sexo")
    private String sexo;
    @Enumerated
    private Estado estado;

    @Column(name = "descripcion")
    private String descripcion;
    @Column
    private String chapita;

    @OneToMany(mappedBy = "mascota", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Foto> fotos = null;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Caracteristica> caracteristicas = null;

    @Transient
    private Chapa chapa;

    @ManyToOne
    @JoinColumn(name = "duenio_id", referencedColumnName = "id")
    private Usuario duenio = null;

    @Column(name = "tipo")
    private String tipo;

    @OneToMany(mappedBy = "id", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY) //encontrame como "id" en la Clase Comodidad
    private List<Comodidad> necesidades = null;


    public Mascota(String tipo, String nombre, String apodo, Integer edad, String sexo, Estado estado, String descripcion, List<Foto> fotos, List<Caracteristica> caracteristicas, Chapa chapa, Usuario duenio, List<Comodidad> necesidades) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
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