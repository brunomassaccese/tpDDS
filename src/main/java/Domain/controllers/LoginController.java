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
    public static Map<String, Integer> idUsuariosConectados = new HashMap<String, Integer>();

    public ModelAndView inicio(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros,"login.hbs");
    }

    public Response login(Request request, Response response){
        String nombreDeUsuario = request.queryParams("usuario");
        String contrasenia     = request.queryParams("password");
        try{
            RepositorioDeUsuarios repoUsuarios = FactoryRepositorioUsuarios.get();

            if(repoUsuarios.existe(nombreDeUsuario, contrasenia)){ //ACA FALLA si no hay Base de Datos
                Usuario usuario = repoUsuarios.buscarUsuario(nombreDeUsuario, contrasenia);

                String perfil = usuario.getPerfil();

                request.session(true);
                idUsuariosConectados.put(request.session().id(), usuario.getId());

                if(perfil.equals("USUARIO")){
                    response.redirect("/registrarMascota");
                }
                else if(perfil.equals("ADMINISTRADOR")){
                    response.redirect("/adminInicio");
                }
                else{
                    response.redirect("/login");
                }

//                if(estaRegistrado(nombreDeUsuario, contrasenia)) {
//                    idUsuariosConectados.put(request.session().id(), obtenerIdDB(nombreDeUsuario));
//                    response.redirect("/registrarMascota");
//                }else{
//                    response.redirect("/login");
//                }
//
//                response.redirect("/registrarMascota"); //o cualquier otro
              }
            else{
                response.redirect("/login");
            }
        }
        catch (Exception e){
            //Funcionalidad del Try sólo disponible solo con persistencia en Base de Datos
            if(estaRegistrado(nombreDeUsuario, contrasenia)) {
                idUsuariosConectados.put(request.session().id(), obtenerIdDB(nombreDeUsuario));
                response.redirect("/login");
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

    public static Usuario obtenerUsuarioConectado(String idSesion){
        Integer id = 0;

        for (Map.Entry<String, Integer> entry : idUsuariosConectados.entrySet()) {
            if(entry.getKey().equals(idSesion)){
                id = entry .getValue();
            }
        }

        if(id != 0){
            RepositorioDeUsuarios repoUsuarios = FactoryRepositorioUsuarios.get();
            Usuario usuario = repoUsuarios.buscar(id);
            return usuario;
        }

        return null;
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

    public Integer obtenerIdDB(String usuario){
        int id = -1;
        for(int i=0; i < DataUsuario.usuarios.size(); i++){
            if(DataUsuario.usuarios.get(i).nombre.equals(usuario)){
                id = DataUsuario.usuarios.get(i).getId();
            }
        }
        if(id == -1){ System.out.println("No se encontro ID del usuario "+usuario); }
        return id;
    }


}

//package Domain.controllers;
//
//import Domain.entities.Persona.Usuario;
//import Domain.repositories.RepositorioDeUsuarios;
//import Domain.repositories.factories.FactoryRepositorioUsuarios;
//import spark.ModelAndView;
//import spark.Request;
//import spark.Response;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class LoginController {
//
//    public ModelAndView inicio(Request request, Response response){
//        Map<String, Object> parametros = new HashMap<>();
//        return new ModelAndView(parametros,"login.hbs");
//    }
//
//    public Response login(Request request, Response response){
//        try{
//            RepositorioDeUsuarios repoUsuarios = FactoryRepositorioUsuarios.get();
//
//            String nombreDeUsuario = request.queryParams("usuario");
//            String contrasenia     = request.queryParams("password");
//
//            if(repoUsuarios.existe(nombreDeUsuario, contrasenia)){
//                Usuario usuario = repoUsuarios.buscarUsuario(nombreDeUsuario, contrasenia);
//
//                request.session(true);
//                request.session().attribute("id", usuario.getId());
//
//                response.redirect("/darEnAdopcion");
//            }
//            else{
//                response.redirect("/login");
//            }
//        }
//        catch (Exception e){
//            //Funcionalidad disponible solo con persistencia en Base de Datos
//            response.redirect("/registrarMascota");
//        }
//        finally {
//            return response;
//        }
//    }
//
//    public Response logout(Request request, Response response){
//        request.session().invalidate();
//        response.redirect("/");
//        return response;
//    }
//}
