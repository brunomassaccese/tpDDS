package Domain.controllers;

import Domain.entities.Persona.Usuario;
import Domain.repositories.RepositorioDeUsuarios;
import Domain.repositories.factories.FactoryRepositorioUsuarios;
import Domain.repositories.testMemoData.DataUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminController {

    public UsuariosController(){
        this.repositorioDeMascotas = FactoryRepositorio.get(Mascota.class);
        this.repositorioCaracteristicas = FactoryRepositorio.get(Caracteristica.class);
    }

public ModelAndView inicio(Request request, Response response){
        return new ModelAndView(new HashMap<>(), "pantalla_administrador1.hbs");
    }

public ModelAndView mostrar(Request request, Response response) {
        
        Mascota mascota = this.repositorio.buscar(Integer.valueOf(request.params("id")));

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("mascotas", mascota);
        return new ModelAndView(parametros, "pantalla_administrador.hbs");
    }



    public Response eliminar(Request request, Response response) {
        Mascota mascota = this.repositorio.buscar(Integer.valueOf(request.params("id")));
        this.repositorio.eliminar(mascota);
        response.redirect("/login");
        return response;
    }

    public Response guardarMascota(Request request, Response response){
        //asignarAtributos(request);
        response.redirect("/login"); //POST
        return response;
    }

}
