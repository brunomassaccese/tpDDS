package Domain.Mascota.Chapa;

import Domain.Mascota.Mascota;
import Domain.Persona.Rescatista;

public interface Chapa {
    default void notificar(Mascota mascotaEncontrada, Rescatista rescatista){
    }
}
