package Domain.Publicacion;

import Domain.Organizacion.Caracteristica;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publicacion_adoptante")
public class PublicacionAdoptante {
    @Id
    @GeneratedValue
    private int id;
    @Transient
    private List<Caracteristica> preferecnias = null;
    @Column
    private Boolean estadoDePublicacion = null;

    public PublicacionAdoptante(List<Caracteristica> preferecnias) {
        this.preferecnias = preferecnias;
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
    }
}