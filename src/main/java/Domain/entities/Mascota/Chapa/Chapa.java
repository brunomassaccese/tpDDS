package Domain.entities.Mascota.Chapa;

import Domain.entities.Mascota.Mascota;

import java.io.IOException;

public interface Chapa {
    default void notificar(Mascota mascotaEncontrada, Formulario formulario) throws IOException {
    }
}
