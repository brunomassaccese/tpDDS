package server;

import Domain.controllers.LoginController;
import Domain.controllers.UsuariosController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;
import Domain.middleware.AuthMiddleware;

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
        LoginController loginController     = new LoginController();
        AuthMiddleware authMiddleware       = new AuthMiddleware();

        Spark.get("/", loginController::inicio, Router.engine);

        Spark.get("/login", loginController::inicio, Router.engine); //cuando toco el botón desde la vista

        Spark.before("/", authMiddleware::verificarSesion); //si ya tenes iniciada sesion te redirecciona

        Spark.post("/login", loginController::login);

        //Spark.get("/usuarios", usuariosController::mostrarTodos, Router.engine);

        //Spark.get("/usuario/:id", usuariosController::mostrar, Router.engine);

        //Spark.post("/usuario/:id", usuariosController::modificar);

        //Spark.delete("/usuario/:id", usuariosController::eliminar);

        Spark.get("/darEnAdopcion", usuariosController::darEnAdopcion, Router.engine); //devuelve un simple String

        Spark.get("/registrarUsuario", usuariosController::registrarUsuario, Router.engine);

        Spark.get("/registrarMascota", usuariosController::registrarMascota, Router.engine);

        Spark.get("/index", usuariosController::inicio, Router.engine);

    }
}
