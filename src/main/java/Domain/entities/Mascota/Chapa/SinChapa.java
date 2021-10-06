package Domain.entities.Mascota.Chapa;

import Domain.entities.Organizacion.Organizacion;
import Domain.entities.Publicacion.PublicacionMascotaPerdida;
import Domain.entities.Mascota.Mascota;

public class SinChapa implements Chapa {

    @Override
    public void notificar(Mascota mascota,Formulario formulario) {
        PublicacionMascotaPerdida publicacion = new PublicacionMascotaPerdida(mascota,formulario); //GENERA UNA PUBLICACION DE MASCOTA PERDIDA
        this.enviarPublicacion(publicacion, formulario);
    }

    private void enviarPublicacion(PublicacionMascotaPerdida publicacion, Formulario formulario) {
        Organizacion organizacion = this.asignarOrganizacion(formulario.getDireccion());
        organizacion.agregarPublicacionMascotaPerdida(publicacion);
    }

    private Organizacion asignarOrganizacion(String direccion) { //HAY QUE HACER ESTO PERO NO SE COMO
        //TODO
        return new Organizacion();
    }
}
