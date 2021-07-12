package Domain.Publicacion;

import Domain.Mascota.Mascota;
import Domain.Persona.Usuario;

import java.util.List;

public class PublicacionMascotaEnAdopcion {

    public Integer id;
    private Boolean estadoDePublicacion = null;
    private Usuario duenio = null;
    private Mascota mascota = null;
    private List<String> preguntas = null;
    private List<String> respuestas = null;

    public Integer getId() {
        return this.id;
    }

    public PublicacionMascotaEnAdopcion(Usuario duenio, Mascota mascota, Integer id, List<String> preguntas, List<String> respuestas) {
        this.duenio = duenio;
        this.mascota = mascota;
        this.estadoDePublicacion = false;
        this.id = id;
        this.preguntas.addAll(preguntas);
        this.respuestas.addAll(respuestas);
    }

    public void aprobar() {
            this.estadoDePublicacion = true;
    }

}
