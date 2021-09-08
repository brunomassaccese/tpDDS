package Domain.Mascota.Chapa;

import Domain.Mascota.Mascota;

import java.io.IOException;

public interface Chapa {
    default void notificar(Mascota mascotaEncontrada, Formulario formulario) throws IOException {
    }
}
