package server;

import Domain.controllers.UsuariosController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        UsuariosController usuariosController = new UsuariosController();

        Spark.get("/usuarios", usuariosController::mostrarTodos, Router.engine); //devuelve una vista
        //Router.engine es la instancia que hice más arriba.

        Spark.get("/usuario/:id", usuariosController::mostrar, Router.engine);

        Spark.post("/usuario/:id", usuariosController::modificar);

        Spark.delete("/usuario/:id", usuariosController::eliminar);

        Spark.get("/darEnAdopcion", usuariosController::darEnAdopcion, Router.engine); //devuelve un simple String

    }
}
