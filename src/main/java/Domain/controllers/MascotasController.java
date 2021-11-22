package Domain.controllers;

import Domain.entities.EstrategiaDeNotificacion.NotificacionMail;
import Domain.entities.EstrategiaDeNotificacion.NotificacionSMS;
import Domain.entities.EstrategiaDeNotificacion.NotificacionWPP;
import Domain.entities.EstrategiaDeNotificacion.Strategy;
import Domain.entities.Mascota.Chapa.Chapa;
import Domain.entities.Mascota.Estado;
import Domain.entities.Mascota.Foto;
import Domain.entities.Mascota.Mascota;
import Domain.entities.Organizacion.Caracteristica;
import Domain.entities.Persona.Contacto;
import Domain.entities.Persona.Direccion;
import Domain.entities.Persona.TipoDeDocumento;
import Domain.entities.Persona.Usuario;
import Domain.entities.Publicacion.Comodidad;
import Domain.repositories.Repositorio;
import Domain.repositories.RepositorioDeCaracteristicas;
import Domain.repositories.RepositorioDeUsuarios;
import Domain.repositories.factories.FactoryRepositorio;
import Domain.repositories.factories.FactoryRepositorioCaracteristicas;
import Domain.repositories.factories.FactoryRepositorioUsuarios;
import Domain.repositories.testMemoData.DataMascota;
import Domain.repositories.testMemoData.DataUsuario;
import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import org.bouncycastle.util.encoders.Base64;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MascotasController {
    private Repositorio<Mascota> repositorio;

    RepositorioDeCaracteristicas repoCaracteristicas = FactoryRepositorioCaracteristicas.get();

    public MascotasController(){
        this.repositorio = FactoryRepositorio.get(Mascota.class);
    }

    public Response guardarMascota(Request request, Response response) throws IOException, SQLException {
        String rutaDeRedireccion = null;
        rutaDeRedireccion = asignarAtributos(request);
        response.redirect(rutaDeRedireccion); //POST
        return response;
    }

    private String asignarAtributos(Request request) throws IOException, SQLException {
        String tipo = null;
        String nombre = null;
        String apodo = null;
        LocalDate fechaDeNacimiento = null;
        String sexo = null;
        String descripcion = null;
        List<Foto> fotos = new ArrayList<>();                           //TODO
        List<Caracteristica> caracteristicas = null;
        List<Caracteristica> caracteristicasBD = null;
        Usuario duenio = null;
        Chapa chapa = null;
        List<Comodidad> necesidades = null;
        String idSpark = null;

        apodo = request.queryParams("apodo");

        idSpark = request.session().id();

        duenio = LoginController.obtenerUsuarioConectado(idSpark);


        if(duenio != null){
            RepositorioDeCaracteristicas repoCaracteristicas = FactoryRepositorioCaracteristicas.get();

            if(request.queryParams("tipo") != null){
                tipo = request.queryParams("tipo");
            }

            if(request.queryParams("nombre") != null){
                nombre = request.queryParams("nombre");
            }

            if(request.queryParams("apodo") != null){
                apodo = request.queryParams("apodo");
            }

            if(request.queryParams("image_1") != null){

                byte[] img = request.queryParams("image_1").getBytes();
                //Blob blobImg = new SerialBlob(img);
                Foto foto1 = new Foto(img);
                fotos.add(foto1);
            }


            if(request.queryParams("fechaDeNacimiento") != null && !request.queryParams("fechaDeNacimiento").isEmpty()){
                fechaDeNacimiento = LocalDate.parse(request.queryParams("fechaDeNacimiento"));
            }

            if(request.queryParams("sexo") != null){
                sexo = request.queryParams("sexo");
            }

            if(request.queryParams("descripcion") != null){
                descripcion = request.queryParams("descripcion");
            }

            String aux = request.queryParams("caracteristica1");

            if(request.queryParams("caracteristica1") != null){
                Caracteristica caracteristica1 = repoCaracteristicas.buscarCaracteristica(request.queryParams("caracteristica1"));
                caracteristicas.add(caracteristica1);
            }

            if(request.queryParams("caracteristica2") != null){
                Caracteristica caracteristica2 = repoCaracteristicas.buscarCaracteristica(request.queryParams("caracteristica2"));
                caracteristicas.add(caracteristica2);
            }

            if(request.queryParams("caracteristica3") != null){
                Caracteristica caracteristica3 = repoCaracteristicas.buscarCaracteristica(request.queryParams("caracteristica3"));
                caracteristicas.add(caracteristica3);
            }

            Mascota mascota = new Mascota(tipo, nombre, apodo, fechaDeNacimiento, sexo, Estado.ENCONTRADO, descripcion,
                    fotos, caracteristicas, chapa, duenio, necesidades);

            this.repositorio.agregar(mascota);

            DataMascota.agregarMascotaALista(mascota);

            return "/MisMascotas";
        }
        else{
            return "/login";
        }
    }


    /*
     Intentar resolver esta eliminacion con Ajax. O sea cuando se toca el botón Eliminar en el navegador, se mande
    una request tipo Ajax al back (se codea en el archivo de resources/public/js creando una funcion eliminarUsuario)
    */
    public Response eliminar(Request request, Response response) {

        return response;
    }
}
