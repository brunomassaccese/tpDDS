package Domain.Publicacion;

import Domain.Mascota.Chapa.Formulario;
import Domain.Mascota.Mascota;

import javax.persistence.*;

@Entity
@Table
public class PublicacionMascotaPerdida {
    @Id
    @GeneratedValue
    private int id;

    @Transient
    private Mascota mascotaPerdida;
    @Transient
    private Formulario formulario;
    @Transient
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