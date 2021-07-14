package Domain.Publicacion;

import Domain.Mascota.Chapa.Formulario;
import Domain.Mascota.Mascota;

public class PublicacionMascotaPerdida {

    private Mascota mascotaPerdida;
    private Formulario formulario;
    private Boolean estadoDePublicacion;

    public PublicacionMascotaPerdida(Mascota mascotaPerdida, Formulario formulario) {
        this.estadoDePublicacion = false;
        this.mascotaPerdida = mascotaPerdida;
        this.formulario = formulario;
    }

    public void verDatos(){
        formulario.mostrarDatos();
    }

    public void verDatosSensibles(){
        formulario.verDatosSensibles();
    }

    public Mascota getMascotaPerdida() {
        return mascotaPerdida;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setMascotaPerdida(Mascota mascotaPerdida) {
        this.mascotaPerdida = mascotaPerdida;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }
}