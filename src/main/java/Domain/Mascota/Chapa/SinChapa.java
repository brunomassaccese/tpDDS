package Domain.Mascota.Chapa;

import Domain.Mascota.Mascota;
import Domain.Persona.Rescatista;
import Domain.Publicacion.PublicacionMascotaPerdida;

public class SinChapa implements Chapa {

    @Override
    public void notificar(Mascota mascota, Rescatista rescatista) {
        this.generarPublicacion(mascota,rescatista); //GENERA UNA PUBLICACION DE MASCOTA PERDIDA
    }

    public void generarPublicacion(Mascota mascota, Rescatista rescatista){ //SE USA EL ESTADO DE LA MASCOTA PARA GENERAR LA PUBLICACION, YA QUE LA MASCOTA TENDRA EL ESTADO COMO PERDIDO
        PublicacionMascotaPerdida publicacion = new PublicacionMascotaPerdida();//FALTA AGREGAR UNA FOTO A LA PUBLICACION
        publicacion.direccion = mascota.estado.descripcion;
        publicacion.estadoDeMascota = mascota.estado.lugarEncontrado;
        publicacion.mascota = mascota;
        publicacion.rescatista = rescatista;
    }
}
