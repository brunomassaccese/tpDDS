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

public class LoginController {
    public static List<String> idUsuariosConectados = new ArrayList<>();

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
                //idUsuariosConectados.add(request.session().id());

                response.redirect("/registrarMascota"); //o cualquier otro
            }
            else{
                response.redirect("/login");
            }
        }
        catch (Exception e){
            //Funcionalidad del Try sólo disponible solo con persistencia en Base de Datos
            if(estaRegistrado(nombreDeUsuario, contrasenia)) {
                idUsuariosConectados.add(request.session().id());
                response.redirect("/registrarMascota");
            }else{
                response.redirect("/login");
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
        return ((usuarioRegistrado(nombreDeUsuario)) && (coincideContraseña(nombreDeUsuario, contrasenia)));
    }

    public Boolean usuarioRegistrado(String nombreDeUsuario){
        return (DataUsuario.mapUsuariosClaves.containsKey(nombreDeUsuario));
    }

    public Boolean coincideContraseña(String nombreDeUsuario, String contrasenia){
        return (DataUsuario.mapUsuariosClaves.get(nombreDeUsuario).equals(contrasenia));
    }

}
