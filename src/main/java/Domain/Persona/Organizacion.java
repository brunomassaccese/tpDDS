package Domain.Persona;

import Domain.Mascota.Publicacion;

public class Organizacion {
    public String nombre;
    public String ubicacion;


    public void generarVoluntario(){ //podria ser que sea un usuario normal y que al momento de usar el metodo aprobar publicacion se verifique que tenga los permisos de un voluntario
        //TODO
    }
    public void aprobarPublicacion(Usuario user, Publicacion publicacion){
        //if(user.permisos=voluntario)
        publicacion.estadoDePublicacion = true;
        //else
          //ERROR  no tiene permisos
    }
}
