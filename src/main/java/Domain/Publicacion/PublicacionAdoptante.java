package Domain.Publicacion;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class PublicacionAdoptante {
    @Id
    @GeneratedValue
    private int id;
    @Transient
    private List<Preferencia> preferecnias = null;
    @Transient
    private Boolean estadoDePublicacion = null;

    public PublicacionAdoptante(List<Preferencia> preferecnias) {
        this.preferecnias = preferecnias;
        this.estadoDePublicacion = false;
    }

    public Boolean getEstadoDePublicacion() {
        return estadoDePublicacion;
    }

    public void setEstadoDePublicacion(Boolean estadoDePublicacion) {
        this.estadoDePublicacion = estadoDePublicacion;

    }

    public List<Preferencia> getPreferecnias() {
        return preferecnias;
    }

    public void setPreferecnias(List<Preferencia> preferecnias) {
        this.preferecnias = preferecnias;
    }
}