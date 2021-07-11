package Domain.Mascota;

import Domain.Mascota.Chapa.Chapa;
import Domain.Mascota.Estados.Estado;
import Domain.Mascota.Estados.Perdido;
import Domain.Persona.Rescatista;
import Domain.Persona.Usuario;

import java.util.ArrayList;

public class Mascota {
    public Usuario duenio;
    public String tipo;
    public String nombre;
    public String apodo;
    public Integer edad;
    public String sexo;
    public Estado estado;
    public String descripcion;
    public ArrayList<Foto> fotos;
    public ArrayList<String> caracteristicas;
    public Chapa chapa;

    public Mascota() {
        this.estado = new Perdido();
        this.caracteristicas = new ArrayList<>();
        this.fotos = new ArrayList<>();
    }
    //ENTREGA 2 PUNTO 1
    //AVISA QUE FUE ENCONTRADO NADA MAS
    public void notificar(Rescatista rescatista){
        chapa.notificar(this,rescatista);
    }

    public void registrar(){
        estado.registrar();
    }
}
