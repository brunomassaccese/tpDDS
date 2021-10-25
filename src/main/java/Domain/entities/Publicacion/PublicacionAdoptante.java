package Domain.entities.Publicacion;

import Domain.entities.Organizacion.Caracteristica;
import Domain.entities.Persona.Usuario;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publicacion_adoptante")
public class PublicacionAdoptante {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private List<Caracteristica> preferencias = null;
    @OneToMany
    private List<Comodidad> comodidades = null;

    @ManyToOne
    @JoinColumn(name = "adoptante_id", referencedColumnName = "id")
    //@JoinColumn(name = "adoptante_id")
    private Usuario adoptante = null;

    @Column
    private Boolean estadoDePublicacion = null;

    public PublicacionAdoptante(Usuario adoptante, List<Caracteristica> preferencias, List<Comodidad> comodidades) {
        this.adoptante = adoptante;
        this.preferencias.addAll(preferencias);
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
        return preferencias;
    }

    public void setPreferecnias(List<Caracteristica> preferecnias) {
        this.preferencias = preferecnias;
    }

    public List<Caracteristica> getPreferencias() {
        return preferencias;
    }

    public Usuario getAdoptante() {
        return adoptante;
    }

    public List<Comodidad> getComodidades() {
        return comodidades;
    }
}