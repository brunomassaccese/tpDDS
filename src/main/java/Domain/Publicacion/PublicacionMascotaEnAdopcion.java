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
    @Column
    private Boolean estadoDePublicacion;
    @ManyToOne
    @JoinColumn(name = "duenio_id")
    private Usuario duenio = null;
    @OneToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota = null;
    @OneToMany
    @JoinColumn(name = "publicacion_adopcion_id")
    private List<Pregunta> preguntas = null;
    @OneToMany
    @JoinColumn(name = "publicacion_adopcion_id")
    private List<Respuesta> respuestas = null;

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