package Domain.Publicacion;

import Domain.Mascota.Foto;
import Domain.Persona.Rescatista;
import java.util.ArrayList;

public class PublicacionMascotaPerdida extends Publicacion{
    public String direccion; //DIRECCION DONDE LA MASCOTA FUE ENCONTRADA
    public String estadoDeMascota; //EL ESTADO EN EL CUAL SE ENCONTRO A LA MASCOTA
    public ArrayList<Foto> fotoDeMascota;
    public Rescatista rescatista;

    public PublicacionMascotaPerdida(){
        this.fotoDeMascota = new ArrayList<>();
    }

    @Override //ENTREGA 2 PUNTO 5
    public void verPublicacion(){
        System.out.println("Foto de la mascota : " +  fotoDeMascota);
        System.out.println("Direccion donde fue encontrada : " + direccion);
        System.out.println(estadoDeMascota);
    }

    @Override //ENTREGA 2 PUNTO 5
    public void accederADatosSensibles(){ //se accede a los datos sencibles del rescatista punto 5 entrega 2
        System.out.println("Nombre del Rescatista : " +  rescatista.nombre);
        System.out.println("Nombre del Rescatista : " +  rescatista.apellido);
        System.out.println("Los contactos del rescatista son : ");
        this.rescatista.verContactos();
    }


}
