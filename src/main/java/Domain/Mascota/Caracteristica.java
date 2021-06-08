package Domain.Mascota;

import java.util.List;

public class Caracteristica {

    private List<String> caracteristicas = null;

    public void agregarCaracteristica(String nuevaCaracteristica){
        caracteristicas.add(nuevaCaracteristica);
    }
}
