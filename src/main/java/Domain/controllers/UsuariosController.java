package Domain.controllers;

import Domain.entities.EstrategiaDeNotificacion.NotificacionMail;
import Domain.entities.EstrategiaDeNotificacion.NotificacionSMS;
import Domain.entities.EstrategiaDeNotificacion.NotificacionWPP;
import Domain.entities.EstrategiaDeNotificacion.Strategy;
import Domain.entities.Mascota.Mascota;
import Domain.entities.Organizacion.Caracteristica;
import Domain.entities.Persona.Rol;
import Domain.entities.Persona.Usuario;
import Domain.entities.Persona.*;
import Domain.repositories.Repositorio;
import Domain.repositories.factories.FactoryRepositorio;
import Domain.repositories.testMemoData.DataUsuario;
import Domain.repositories.testMemoData.EntidadPersistente;
import Domain.controllers.LoginController;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.jws.WebParam;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuariosController {
    private Repositorio<Usuario> repositorio;
    private Repositorio<Rol> repositorioDeRoles;
    private Repositorio<Mascota> repositorioDeMascotas;
    private Repositorio<Caracteristica> repositorioCaracteristicas;
    private LoginController loginController;

    public UsuariosController(){
        this.repositorio = FactoryRepositorio.get(Usuario.class); //esto me devuelve un repositorio
        this.repositorioDeRoles = FactoryRepositorio.get(Rol.class);
        this.repositorioDeMascotas = FactoryRepositorio.get(Mascota.class);
        this.repositorioCaracteristicas = FactoryRepositorio.get(Caracteristica.class);
    }

    public ModelAndView inicio(Request request, Response response){
        return new ModelAndView(new HashMap<>(), "index.hbs");
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

    public ModelAndView darEnAdopcion(Request request, Response response) {
/*
        if (tieneMascota(Usuario usuario)){
            //cargar los datos y las fotos
        }else{
            //mostrar mensaje indicandolo
        }
*/

        /*Mascota mascota = this.repositorioDeMascotas.buscar(Integer.valueOf(request.params("id")));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("mascotas", mascota);
        return new ModelAndView(parametros, "darEnAdopcion.hbs");*/
        return new ModelAndView(new HashMap<>(), "darEnAdopcion.hbs");
    }

    public ModelAndView registrarUsuario(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "registrarUsuario.hbs");

    }

    public ModelAndView registrarMascota(Request request, Response response){
        return new ModelAndView(new HashMap<>(), "registrarMascota.hbs");
    }


    public ModelAndView mostrarCaracteristicas(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        if((loginController.idUsuariosConectados.contains(request.session().id())) == true){
            List<Caracteristica> caracteristicas = this.repositorioCaracteristicas.buscarTodos();
            parametros.put("caracteristicas", caracteristicas);
            return new ModelAndView(parametros, "registrarMascota.hbs");
        }else{
         return new ModelAndView(parametros, "login.hbs");
        }
    }

    public Response guardarUsuario(Request request, Response response){
        asignarAtributos(request);
        response.redirect("/login"); //POST
        return response;
    }


    private void asignarAtributos(Request request){
        String nombre = null;
        String apellido = null;
        LocalDate fechaDeNacimiento = null;
        TipoDeDocumento tipoDocumento = null;
        String documento = null;
        String perfil = null;
        String password = null;
        Direccion direccion = null;
        String calleDireccion = null;
        int alturaDireccion;
        Contacto contacto = null;
        List<Contacto> listaContactos = new ArrayList<>();
        Strategy formaDecontacto = null;
        String nombreContacto = null;
        String apellidoContacto = null;
        String telefonoContacto = null;
        String emailContacto = null;

        if(request.queryParams("nombre") != null){
            nombre = request.queryParams("nombre");
        }

        if(request.queryParams("apellido") != null){
            apellido = request.queryParams("apellido");
        }

        if(request.queryParams("fechaDeNacimiento") != null && !request.queryParams("fechaDeNacimiento").isEmpty()){
            fechaDeNacimiento = LocalDate.parse(request.queryParams("fechaDeNacimiento"));
        }

        if((request.queryParams("tipoDocumento") != null) && request.queryParams("documento") != null){
            switch(request.queryParams("tipoDocumento")){
                case "DNI":
                    tipoDocumento = TipoDeDocumento.DNI;
                    break;
                case "CEDULA":
                    tipoDocumento = TipoDeDocumento.CEDULA;
                    break;
                case "PASAPORTE":
                    tipoDocumento = TipoDeDocumento.PASAPORTE;
                    break;
            }
            documento = request.queryParams("documento");
        }

        if(request.queryParams("perfil") != null){
            perfil = request.queryParams("perfil");
        }

        if(request.queryParams("password") != null){
            password = request.queryParams("password");
        }

        if(request.queryParams("calleDireccion") != null && request.queryParams("alturaDireccion") != null){
            calleDireccion = request.queryParams("calleDireccion");
            alturaDireccion = new Integer(request.queryParams("alturaDireccion"));
            direccion = new Direccion(calleDireccion, alturaDireccion);
        }

        if(request.queryParams("formaDeContacto") != null && request.queryParams("nombreContacto") != null &&
                request.queryParams("apellidoContacto") != null && request.queryParams("telefonoContacto") != null &&
                request.queryParams("emailContacto") != null){
            nombreContacto =  request.queryParams("nombreContacto");
            apellidoContacto = request.queryParams("apellidoContacto");
            telefonoContacto = request.queryParams("telefonoContacto");
            emailContacto = request.queryParams("emailContacto");
            switch(request.queryParams("formaDeContacto")){
                case "SMS":
                    formaDecontacto = new NotificacionSMS();
                    break;
                case "Email":
                    formaDecontacto = new NotificacionMail();
                    break;
                case "WhatsApp":
                    formaDecontacto = new NotificacionWPP();
                    break;
            }
            contacto = new Contacto(formaDecontacto, nombreContacto, apellidoContacto,
                    telefonoContacto, emailContacto, true);
            listaContactos.add(contacto);

        }


        Usuario usuario = new Usuario(nombre, apellido, fechaDeNacimiento, direccion, tipoDocumento, documento,
                listaContactos, password, perfil);

        this.repositorio.agregar(usuario);

        DataUsuario.agregarUsuarioALista(usuario); //en memoria

    }
}
