package Domain.Persona;

import Domain.EstrategiaDeNotificacion.Strategy;
import Domain.Mascota.Mascota;
import Domain.Mascota.Publicacion;
import Domain.Organizacion.Organizacion;
import Domain.Publicacion.PublicacionAdoptante;
import Domain.Publicacion.PublicacionMascotaEnAdopcion;
import Domain.Publicacion.PublicacionMascotaPerdida;
import Domain.EstrategiaDeNotificacion.Notificacion;

import java.nio.MappedByteBuffer;
import java.time.LocalDateTime;
import java.util.List;

public class Usuario extends Persona implements Strategy {
    private String nombreUsuario;
    private String password;
    private List<Mascota> mascotas = null;
    private String perfil = null;

    public Usuario(String nombre, String apellido, LocalDateTime fechaNacimiento, String direccion, TipoDeDocumento dni, List<Contacto> contactos, String nombreUsuario, String password, String perfil) {
        super(nombre, apellido, fechaNacimiento, direccion, dni, contactos);
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.perfil = perfil;
    }


    public void registrarMascota(Mascota mascota){
        this.mascotas.add(mascota);
    }

    //E2.P3
    public void aprobarPublicacion(PublicacionMascotaPerdida publicacion, Organizacion organizacion){
        if(this.perfil=="VOLUNTARIO")
            organizacion.agregarPublicacionMascotaPerdida(publicacion);
    }

    public void contactarRescatista(PublicacionMascotaPerdida publicacion){
        Contacto contactoDestino = publicacion.rescatista.obtenerContactoPorDefecto();
        String mensaje = "Se encontró la mascota " + publicacion.mascotaPerdida.getChapa();
        Notificacion nuevaNotificacion = new Notificacion(contactoDestino.getFormaDeContacto());

        nuevaNotificacion.ejecutarAviso(contactoDestino, mensaje);

    }

    //E3.P1
    public void darEnAdopcion(Mascota miMascota, Organizacion organizacion, List<String> preguntas, List<String> respuestas){
        organizacion.solicitarPublicacionEnAdopcion(miMascota, this, preguntas, respuestas);
    }

    //E3.P4
    public void quieroAdoptar(List<String> preferencias, Organizacion organizacion){
        PublicacionAdoptante nuevaPublicacion = new PublicacionAdoptante(preferencias);
        organizacion.agregarPublicacionAdoptante(nuevaPublicacion);
    }

}

/*

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    public String nombre;

    public void generarPublicacionDeAdopcion(Organizacion organizacion,Mascota mascota){ //PUNTO 1 GENERA UNA PUBLICACION

        Publicacion publicacion = new Publicacion(); //INICIALIZA LA PUBLICACION PUNTO 1
        publicacion.usuario = this; //ASIGNA PUNTO 1
        publicacion.organizacion = organizacion;
        publicacion.mascota = mascota;

        this.responderPreguntas(publicacion);//RESPONDE PREGUNTAS PUNTO 1
        publicacion.enviar();//ENVIA PASA A LA CLASE PUBLICACION PUNTO 1
    }

    public void responderPreguntas(Publicacion publicacion){ //PUNTO 1

        ArrayList<String> preguntasDeLaOrganizacion = publicacion.organizacion.preguntas; //PARA NO REPETIR
        int cantidad = publicacion.organizacion.cantidadDePreguntas();
        Scanner respuesta = new Scanner (System.in); //PARA GUARDAR LAS RESPUESTAS
        System.out.println("Responda todas las preguntas");

        for(int i=0; i<cantidad ;i++){
            System.out.println(i+1 + ")" + preguntasDeLaOrganizacion.get(i)); //MUESTRA LA RESPUESTA DE LA ORGANIZACION
            publicacion.agregar(publicacion.preguntas, preguntasDeLaOrganizacion.get(i)); //GUARDA LA PREGUNTA EN LA PUBLICACION
            publicacion.agregar(publicacion.respuestas,respuesta.nextLine()); // GUARDA LA RESPUESTA EN LA PUBLICACION
        }
    }

    public void verPublicaciones(Organizacion organizacion){ //PUNTO 3 UN USUARIO PUEDE VER LAS PUBLICACION DE UNA ORGANIZACION Y SI VE UNA EN LA CUAL ESTA INTERESADO PUEDE ESCOGERLA

        organizacion.verPublicaciones(organizacion.publicacionesAceptadas);
        Scanner indicar = new Scanner(System.in);
        Scanner indicarLugar = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("\n Opciones");
            System.out.println("[1] Interesado en una publicacion");
            System.out.println("[2] No interesado en ninguna publicacion");
            opcion = indicar.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Indicar el lugar de la publicacion");
                    this.interesado(indicarLugar.nextInt(), organizacion);
                    break;
                case  2:
                    System.out.println("Gracias vuelva pronto");
                    break;
            }
        }while (opcion!=1 || opcion!=2);
    }

    public void interesado (int posicion, Organizacion organizacion){ // PUNTO 3 ESCOGE UNA PUBLICACION Y ESTA SE LE ENVIA A LA PUBLICACION LA CUAL LA AGREGARA A SU LISTA DE INTERESADOS
        System.out.println("Muchas Gracias");
        organizacion.publicacionesAceptadas.get(posicion).agregarUsuarioInteresado(this);
    }

}
*/