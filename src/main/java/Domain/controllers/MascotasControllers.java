package Domain.controllers;

import Domain.entities.Mascota.Mascota;
import Domain.repositories.Repositorio;
import Domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MascotasControllers {
    private Repositorio<Mascota> repositorio;
/*
    public MascotasController(){
        this.repositorio = FactoryRepositorio.get(Mascota.class);
    }

    public ModelAndView mostrarTodos(Request request, Response response) {

        Map<String, Object> parametros = new HashMap<>();
        List<Mascota> mascotas = this.repositorio.buscarTodos();
        parametros.put("mascotas", mascotas);
        return new ModelAndView(parametros, "mascotas.hbs");
    }

    public ModelAndView mostrar(Request request, Response response) {
        Mascota mascota = this.repositorio.buscar(Integer.valueOf(request.params("id")));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("mascotas", mascota);
        return new ModelAndView(parametros, "mascota.hbs");
    }

    public Response modificar(Request request, Response response) {
        Mascota mascota = this.repositorio.buscar(Integer.valueOf(request.params("id")));
        String nuevoNombre = request.queryParams("nombre");
        //cambiar el estado de perdido a encontrado
        response.redirect("/usuarios");
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
