package Domain.Mascota;

import Domain.Mascota.Chapa.Chapa;
import Domain.Persona.Usuario;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota implements Estado {

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
    @Transient
//    @OneToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "estado_id")
    private Estado estado;

    @Column(name = "descripcion")
    private String descripcion;
    @Transient
    //   @OneToMany(mappedBy = "mascota", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Foto> fotos = null;
    @Transient
//    @OneToMany(mappedBy = "mascota", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<String> caracteristicas = null;
    @Transient
//    @OneToOne(cascade = {CascadeType.ALL})
    //   @JoinColumn(name = "chapa_id")
    private Chapa chapa;
    @Transient
    //  @ManyToOne
    // @JoinColumn(name = "duenio_id", referencedColumnName = "id")
    private Usuario duenio = null;

    @Column(name = "tipo")
    private String tipo;


    public Mascota(String tipo, String nombre, String apodo, Integer edad, String sexo, Estado estado, String descripcion, List<Foto> fotos, List<String> caracteristicas, Chapa chapa, Usuario duenio) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        this.sexo = sexo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.caracteristicas = caracteristicas;
        this.chapa = chapa;
        this.duenio = duenio;
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
}