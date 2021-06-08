package Domain.Persona;

import Domain.EstrategiaDeNotificacion.Strategy;
import Domain.Mascota.Mascota;

import java.util.List;

public class Usuario extends Persona implements Strategy {
    public String nombre;
    //Lista con permisos

    private List<Mascota> mascotas = null;

    public void registrarMascota(Mascota mascota){
        this.mascotas.add(mascota);
    }

}


