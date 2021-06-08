package Domain.Mascota;

import Domain.Mascota.Foto;

import java.util.ArrayList;
import java.util.List;

public class Mascota implements Estado {

    private String tipo;
    private String nombre;
    private String apodo;
    private Integer edad;
    private String sexo;
    private Estado estado;
    private String descripcion;
    private List<Foto> fotos = null;
    private List<String> caracteristicas = null;
    private String chapa;

    public Mascota(String tipo, String nombre, String apodo, Integer edad, String sexo, Estado estado, String descripcion, List<Foto> fotos, List<String> caracteristicas, String chapa) {
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
    }

}
