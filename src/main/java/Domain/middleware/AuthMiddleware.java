package Domain.middleware;

import spark.Request;
import spark.Response;

public class AuthMiddleware {

    public Response verificarSesion(Request request, Response response){
        if(!request.session().isNew()){
            response.redirect("registrarUsuario");
        }
        return response;
    }
}
