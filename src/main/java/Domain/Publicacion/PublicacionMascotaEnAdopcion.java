package Domain.Publicacion;

import Domain.Mascota.Mascota;
import Domain.Organizacion.Pregunta;
import Domain.Organizacion.Respuesta;
import Domain.Persona.Usuario;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
@Entity
@Table
public class PublicacionMascotaEnAdopcion {
    @Id
    @GeneratedValue
    private int id;
    @Transient
    public Timestamp timestamp;
    @Transient
    private Boolean estadoDePublicacion = null;
    @Transient
    private Usuario duenio = null;
    @Transient
    private Mascota mascota = null;
    @Transient
    private List<Pregunta> preguntas = null;
    @Transient
    private List<Respuesta> respuestas = null;
    @Transient
    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public PublicacionMascotaEnAdopcion(Usuario duenio, Mascota mascota, Timestamp timestamp, List<Pregunta> preguntas, List<Respuesta> respuestas) {
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