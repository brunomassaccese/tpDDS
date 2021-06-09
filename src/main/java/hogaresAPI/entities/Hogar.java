package hogaresAPI.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hogar {

    public String nombre;
    public String id;
    public Ubicacion ubicacion;
    public String telefono;
    public Admision admision;
    public int capacidad;

    @SerializedName("lugares_disponibles")
    public int lugaresDisponibles;
    public Boolean patio;
    public List<String> caracteristicas;

}
