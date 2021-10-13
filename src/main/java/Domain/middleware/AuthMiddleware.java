package Domain.middleware;

import Domain.entities.Persona.Usuario;
import spark.Request;
import spark.Response;

public class AuthMiddleware {

    public Response verificarSesion(Request request, Response response){
        if(!request.session().isNew()){
            response.redirect("/login"); //redireccionar a otra pantalla, no a esa
        }
        return response;
    }
}
