package Domain.Publicacion;

import java.util.List;

public class PublicacionAdoptante {
    private List<String> preferecnias = null;
    private Boolean estadoDePublicacion = null;

    public PublicacionAdoptante(List<String> preferecnias) {
        this.preferecnias = preferecnias;
        this.estadoDePublicacion = false;
    }
}
