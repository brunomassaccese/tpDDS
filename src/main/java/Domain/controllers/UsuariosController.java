package Domain.controllers;

import Domain.entities.Mascota.Mascota;
import Domain.entities.Persona.Rol;
import Domain.entities.Persona.Usuario;
import Domain.repositories.Repositorio;
import Domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuariosController {
    private Repositorio<Usuario> repositorio;
    private Repositorio<Rol> repositorioDeRoles;
    private Repositorio<Mascota> repositorioDeMascotas;

    public UsuariosController(){
        this.repositorio = FactoryRepositorio.get(Usuario.class); //esto me devuelve un repositorio
        this.repositorioDeRoles = FactoryRepositorio.get(Rol.class);
        this.repositorioDeMascotas = FactoryRepositorio.get(Mascota.class);
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        /*
         Lo siguiente es para recuperar usuarios que están cargados en memoria y devolverlos en una vista.
        */
        Map<String, Object> parametros = new HashMap<>(); //parametros que le voy a mandar a la vista
        List<Usuario> usuarios = this.repositorio.buscarTodos(); //recupero el listado de usuarios del repositorio
        parametros.put("usuarios", usuarios); //meteme en la clave usuarios a todo el listado de usuarios.
                                              // "usuarios" es lo que tomo en la vista
        return new ModelAndView(parametros, "usuarios.hbs");
    }

    public ModelAndView mostrar(Request request, Response response) {
        //Tomar el parámetro ID y verificar que sea algo válido, y despues
        // chequear que exista el usuario
        Usuario usuario = this.repositorio.buscar(Integer.valueOf(request.params("id"))); /*params() recibe algo y
                                                                                        devuelve un string.
                                                                                        Despues instancio un Integer con eso */
        List<Rol> roles = this.repositorioDeRoles.buscarTodos();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("usuarios", usuario);
        parametros.put("roles", roles);
        return new ModelAndView(parametros, "usuario.hbs");
    }

    public Response modificar(Request request, Response response) {
        //este método me puede devoler una ModelAndView o me puede redireccionar con una Response
        Usuario usuario = this.repositorio.buscar(Integer.valueOf(request.params("id")));

        //chequear que sean nombres válidos y levanto el campo name mediante una queryParam
        String nuevoNombre = request.queryParams("nombre"); //coincide con "name" del input (línea 43 usuario.hbs)
        usuario.nombre = nuevoNombre;
        response.redirect("/usuarios");
        return response;
    }

    /*
     Intentar resolver esta eliminacion con Ajax. O sea cuando se toca el botón Eliminar en el navegador, se mande
    una request tipo Ajax al back (se codea en el archivo de resources/public/js creando una funcion eliminarUsuario)
    */
    public Response eliminar(Request request, Response response) {
        Usuario usuario = this.repositorio.buscar(Integer.valueOf(request.params("id")));
        this.repositorio.eliminar(usuario);
        response.redirect("/usuarios");
        return response;
    }

    public ModelAndView saludar(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "busquedaPersonalizada.hbs");
    }

    public ModelAndView darEnAdopcion(Request request, Response response) {
        //buscar mascotas de este usuario
        //si tiene mascotas cargar los datos y las fotos
        //si no tiene mostrar mensaje indicandolo

        /*Mascota mascota = this.repositorioDeMascotas.buscar(Integer.valueOf(request.params("id")));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("mascotas", mascota);
        return new ModelAndView(parametros, "darEnAdopcion.hbs");*/
        return new ModelAndView(new HashMap<>(), "darEnAdopcion.hbs");
    }

}
