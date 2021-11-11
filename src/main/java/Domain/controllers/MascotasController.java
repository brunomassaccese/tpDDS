package Domain.controllers;

import Domain.entities.EstrategiaDeNotificacion.NotificacionMail;
import Domain.entities.EstrategiaDeNotificacion.NotificacionSMS;
import Domain.entities.EstrategiaDeNotificacion.NotificacionWPP;
import Domain.entities.EstrategiaDeNotificacion.Strategy;
import Domain.entities.Mascota.Chapa.Chapa;
import Domain.entities.Mascota.Estado;
import Domain.entities.Mascota.Foto;
import Domain.entities.Mascota.Mascota;
import Domain.entities.Organizacion.Caracteristica;
import Domain.entities.Persona.Contacto;
import Domain.entities.Persona.Direccion;
import Domain.entities.Persona.TipoDeDocumento;
import Domain.entities.Persona.Usuario;
import Domain.entities.Publicacion.Comodidad;
import Domain.repositories.Repositorio;
import Domain.repositories.factories.FactoryRepositorio;
import Domain.repositories.testMemoData.DataMascota;
import Domain.repositories.testMemoData.DataUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.ArrayList;
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

        String tipo = null;
        String nombre = null;
        String apodo = null;
        LocalDate fechaDeNacimiento = null;
        String sexo = null;
        String descripcion = null;
        List<Foto> fotos = null;                           //TODO
        List<Caracteristica> caracteristicas = null;
        Usuario duenio = null;                             //TODO
        Chapa chapa = null;
        List<Comodidad> necesidades = null;

        if(request.queryParams("tipo") != null){
            tipo = request.queryParams("tipo");
        }

        if(request.queryParams("nombre") != null){
            nombre = request.queryParams("nombre");
        }

        if(request.queryParams("apodo") != null){
            apodo = request.queryParams("apodo");
        }

        if(request.queryParams("fechaDeNacimiento") != null && !request.queryParams("fechaDeNacimiento").isEmpty()){
            fechaDeNacimiento = LocalDate.parse(request.queryParams("fechaDeNacimiento"));
        }

        if(request.queryParams("sexo") != null){
            sexo = request.queryParams("sexo");
        }

        if(request.queryParams("descripcion") != null){
            descripcion = request.queryParams("descripcion");
        }

        if(request.queryParams("caracteristica1") != null){
            Caracteristica caracteristica1 = new Caracteristica(request.queryParams("caracteristica1"));
            caracteristicas.add(caracteristica1);
        }

        if(request.queryParams("caracteristica2") != null){
            Caracteristica caracteristica2 = new Caracteristica(request.queryParams("caracteristica2"));
            caracteristicas.add(caracteristica2);
        }

        if(request.queryParams("caracteristica3") != null){
            Caracteristica caracteristica3 = new Caracteristica(request.queryParams("caracteristica3"));
            caracteristicas.add(caracteristica3);
        }

        Mascota mascota = new Mascota(tipo, nombre, apodo, fechaDeNacimiento, sexo, null, descripcion,
                fotos, caracteristicas, chapa, duenio, necesidades);

        this.repositorio.agregar(mascota);

        DataMascota.agregarMascotaALista(mascota);
    }


    /*
     Intentar resolver esta eliminacion con Ajax. O sea cuando se toca el botón Eliminar en el navegador, se mande
    una request tipo Ajax al back (se codea en el archivo de resources/public/js creando una funcion eliminarUsuario)
    */
    public Response eliminar(Request request, Response response) {

        return response;
    }
}
