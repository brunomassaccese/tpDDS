package Domain.Mascota;

import Domain.Mascota.Foto;
import Domain.Persona.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Mascota implements Estado {

    private String tipo;

    public String getNombre() {
        return nombre;
    }

    public String getChapa() {
        return chapa;
    }

    private String nombre;
    private String apodo;
    private Integer edad;
    private String sexo;
    private Estado estado;
    private String descripcion;
    private List<Foto> fotos = null;
    private List<String> caracteristicas = null;
    private String chapa;

    public Usuario getDuenio() {
        return duenio;
    }

    private Usuario duenio = null;

    public Mascota(String tipo, String nombre, String apodo, Integer edad, String sexo, Estado estado, String descripcion, List<Foto> fotos, List<String> caracteristicas, String chapa, Usuario duenio) {
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


}