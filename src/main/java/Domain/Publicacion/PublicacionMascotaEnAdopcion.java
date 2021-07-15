package Domain.Publicacion;

import Domain.Mascota.Mascota;
import Domain.Persona.Usuario;

import java.sql.Timestamp;
import java.util.List;

public class PublicacionMascotaEnAdopcion {

    public Timestamp timestamp;
    private Boolean estadoDePublicacion = null;
    private Usuario duenio = null;
    private Mascota mascota = null;
    private List<String> preguntas = null;
    private List<String> respuestas = null;

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public PublicacionMascotaEnAdopcion(Usuario duenio, Mascota mascota, Timestamp timestamp, List<String> preguntas, List<String> respuestas) {
        this.duenio = duenio;
        this.mascota = mascota;
        this.estadoDePublicacion = false;
        this.timestamp = timestamp;
        this.preguntas.addAll(preguntas);
        this.respuestas.addAll(respuestas);
    }

    public boolean estado(){
        return this.estadoDePublicacion;
    }
    public void aprobar() {
        this.estadoDePublicacion = true;
    }

}