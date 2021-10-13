package Domain.controllers;

import Domain.entities.Mascota.Mascota;
import Domain.repositories.Repositorio;
import Domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MascotasController {
    private Repositorio<Mascota> repositorio;

    public MascotasController(){
        this.repositorio = FactoryRepositorio.get(Mascota.class);
    }

    public Response guardarMascota(Request request, Response response){
        asignarAtributos(request);
        response.redirect("/login"); //POST
        return response;
    }

    private void asignarAtributos(Request request){
        return;
    }


    /*
     Intentar resolver esta eliminacion con Ajax. O sea cuando se toca el botón Eliminar en el navegador, se mande
    una request tipo Ajax al back (se codea en el archivo de resources/public/js creando una funcion eliminarUsuario)
    */
    public Response eliminar(Request request, Response response) {

        return response;
    }
}
