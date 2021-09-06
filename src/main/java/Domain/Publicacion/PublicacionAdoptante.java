package Domain.Publicacion;

import Domain.Organizacion.Caracteristica;
import Domain.Persona.Persona;
import Domain.Persona.Usuario;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publicacion_adoptante")
public class PublicacionAdoptante {
    @Id
    @GeneratedValue
    private int id;

    @Transient
    private List<Caracteristica> preferencias = null;

    @Transient
    private List<Caracteristica> preferecnias = null;
    @Transient
    private List<Comodidad> comodidades = null;

    @Transient
    private Usuario adoptante = null;

    @Transient
    private Boolean estadoDePublicacion = null;

    public PublicacionAdoptante(Usuario adoptante, List<Caracteristica> preferecnias, List<Comodidad> comodidades) {
        this.adoptante = adoptante;
        this.preferencias.addAll(preferecnias);
        this.comodidades.addAll(comodidades);
        this.estadoDePublicacion = false;
    }

    public Boolean getEstadoDePublicacion() {
        return estadoDePublicacion;
    }

    public void setEstadoDePublicacion(Boolean estadoDePublicacion) {
        this.estadoDePublicacion = estadoDePublicacion;

    }

    public List<Caracteristica> getPreferecnias() {
        return preferecnias;
    }

    public void setPreferecnias(List<Caracteristica> preferecnias) {
        this.preferecnias = preferecnias;

    public Usuario getAdoptante() {
        return adoptante;
    }

    public List<Comodidad> getComodidades() {
        return comodidades;
    }
}