package Domain.Organizacion;

import java.util.List;

public class Organizacion {
    private List<String> caracteristicas = null;

    public void agregarCaracteristica(String nuevaCaracteristica){
        caracteristicas.add(nuevaCaracteristica);
    }
}
