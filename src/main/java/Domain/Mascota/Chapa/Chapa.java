package Domain.Mascota.Chapa;

import Domain.Mascota.Mascota;

public interface Chapa {
    default void notificar(Mascota mascotaEncontrada, Formulario formulario){
    }
}
