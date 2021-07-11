package Domain.Mascota.Estados;

import Domain.Mascota.Foto;
import Domain.Mascota.Mascota;
import java.util.ArrayList;
import java.util.Scanner;

public class Perdido extends Estado {

    public Perdido(){
        this.fotos = new ArrayList<>();
    }

    public void agregar(Foto foto) {
        fotos.add(foto);
    }

    //Foto fotoDelAnimal = new Foto();
    Scanner descripcionDelAnimal = new Scanner(System.in);
    Scanner lugarDondeEncontroAlAnimal = new Scanner(System.in);

    @Override
    public void registrar() {
        System.out.println("Ingrese una foto del animal");//FALTA COMO AGREGAR UNA FOTO
        //this.agregar(fotoDelAnimal);
        System.out.println("Ingrese la descripcion del animal ");
        this.descripcion = descripcionDelAnimal.nextLine();
        System.out.println("Ingrese el lugar donde encontro al animal ");
        this.lugarEncontrado = lugarDondeEncontroAlAnimal.nextLine();
    }

    @Override
    public void cambiarEstado(Mascota mascota){
        mascota.estado = new EnCasa();
    }
}
