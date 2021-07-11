package Domain.Persona;

import Domain.Organizacion.Organizacion;
import Domain.Mascota.Mascota;
//import com.sun.xml.internal.bind.v2.TODO;

public class Administrador extends Usuario {

    public void agregarCarcateristicas(Organizacion organizacion, String nuevaCaracteristica) {
        organizacion.agregarCaracteristica(nuevaCaracteristica);
    }
}