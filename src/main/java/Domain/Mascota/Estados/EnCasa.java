package Domain.Mascota.Estados;

import Domain.Mascota.Mascota;

import java.util.ArrayList;

public class EnCasa extends Estado{

    public EnCasa(){
        this.fotos = new ArrayList<>();
        this.lugarEncontrado = null;
        this.descripcion = null;
    }

    @Override
    public void registrar(){ //ACA ME PARECIO QUE UN USUARIO PODRIA CREAR UNA NUEVA MASCOTA Y QUE LO REGISTRE

    }

    @Override
    public void cambiarEstado(Mascota mascota){
        mascota.estado = new Perdido();
    }
}
