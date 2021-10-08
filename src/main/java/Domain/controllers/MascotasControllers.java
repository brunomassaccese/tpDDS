package Domain.controllers;

import Domain.entities.Persona.Rol;
import Domain.entities.Persona.Usuario;
import Domain.repositories.Repositorio;
import Domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MascotasController {
    private Repositorio<Usuario> repositorio;


    public MascotasController(){
        this.repositorio = FactoryRepositorio.get(Usuario.class); //esto me devuelve un repositorio
    }

    public ModelAndView mostrarTodos(Request request, Response response) {

        return new ModelAndView(parametros, "usuarios.hbs");
    }

    public ModelAndView mostrar(Request request, Response response) {

        return new ModelAndView(parametros, "usuario.hbs");
    }

    public Response modificar(Request request, Response response) {

        return response;
    }

    /*
     Intentar resolver esta eliminacion con Ajax. O sea cuando se toca el botón Eliminar en el navegador, se mande
    una request tipo Ajax al back (se codea en el archivo de resources/public/js creando una funcion eliminarUsuario)
    */
    public Response eliminar(Request request, Response response) {

        return response;
    }
}
