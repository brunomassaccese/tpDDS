package Domain.Mascota;

import Domain.Mascota.Chapa.Chapa;
import Domain.Persona.Usuario;

import java.util.List;

public class Mascota implements Estado {

    private String nombre;
    private String apodo;
    private Integer edad;
    private String sexo;
    private Estado estado;
    private String descripcion;
    private List<Foto> fotos = null;
    private List<String> caracteristicas = null;
    private Chapa chapa;
    private Usuario duenio = null;
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