package server;

import domain.controllers.UsuariosController;
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
        //Spark.get("/saludar", (req, res) -> "Hola" + req.queryParams("nombre") + " " + req.queryParams("apellido"));

        //Spark.get("/usuarios/:id", (req, res) -> req.params("id"));

        //Spark.get("/personas/:id/:nombre", (req, res) -> req.params("id"));

        //Spark.get("/bosques/*/*/*/:id", (req, res) -> req.params("id")+ ":" + req.splat()[2]);

        UsuariosController usuariosController = new UsuariosController();

        Spark.get("/saludar", usuariosController::saludar); //devuelve un simple String

        Spark.get("/usuarios", usuariosController::mostrarTodos, Router.engine); //devuelve una vista
        //Router.engine es la instancia que hice más arriba.

        Spark.get("/usuario/:id", usuariosController::mostrar, Router.engine);

        Spark.post("/usuario/:id", usuariosController::modificar);

        Spark.delete("/usuario/:id", usuariosController::eliminar);

    }
}
