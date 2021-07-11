package Domain.Mascota.Estados;

import Domain.Mascota.Foto;
import Domain.Mascota.Mascota;

import java.util.ArrayList;

public abstract class Estado {

    public ArrayList<Foto> fotos;
    public String lugarEncontrado;
    public String descripcion;

    public void registrar(){
    }

    public void cambiarEstado(Mascota mascota){
    }
}
