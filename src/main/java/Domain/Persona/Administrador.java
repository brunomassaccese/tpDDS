package Domain.Persona;

import Domain.Mascota.Caracteristica;
import Domain.Mascota.Mascota;
import com.sun.xml.internal.bind.v2.TODO;

public class Administrador extends Usuario {

    public void agregarCarcateristicas(Caracteristica caracteristica, String nuevaCaracteristica) {

        caracteristica.agregarCaracteristica(nuevaCaracteristica);
    }
}