package Domain.controllers;

import Domain.entities.Persona.Usuario;
import Domain.repositories.RepositorioDeUsuarios;
import Domain.repositories.factories.FactoryRepositorioUsuarios;
import Domain.repositories.testMemoData.DataUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginController {

    public ModelAndView inicio(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros,"login.hbs");
    }

    public Response login(Request request, Response response){
        String nombreDeUsuario = request.queryParams("nombreDeUsuario");
        String contrasenia     = request.queryParams("contrasenia");
        try{
            RepositorioDeUsuarios repoUsuarios = FactoryRepositorioUsuarios.get();

            if(repoUsuarios.existe(nombreDeUsuario, contrasenia)){ //ACA FALLA si no hay Base de Datos
                Usuario usuario = repoUsuarios.buscarUsuario(nombreDeUsuario, contrasenia);

                request.session(true);
                request.session().attribute("userName", usuario.getNombre());

                response.redirect("/registrarMascota"); //o cualquier otro
            }
            else{
                response.redirect("/");
            }
        }
        catch (Exception e){
            //Funcionalidad del Try sólo disponible solo con persistencia en Base de Datos
            if(estaRegistrado(nombreDeUsuario, contrasenia)) {
                response.redirect("/registrarMascota");
            }else{
                response.redirect("/registrarUsuario");
            }
        }
        finally {
            return response;
        }
    }

    public Response logout(Request request, Response response){
        request.session().invalidate();
        response.redirect("/");
        return response;
    }

    public Boolean estaRegistrado(String nombreDeUsuario, String contrasenia){
        return ((DataUsuario.mapUsuariosClaves.containsKey(nombreDeUsuario) == true) &
                        (DataUsuario.mapUsuariosClaves.get(nombreDeUsuario).equals(contrasenia)));
    }

}
