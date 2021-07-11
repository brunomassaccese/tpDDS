package Domain.Organizacion;

import Domain.EstrategiaDeNotificacion.Notificacion;
import Domain.Persona.Usuario;
import Domain.Publicacion.Publicacion;
import Domain.Publicacion.PublicacionDeAdopcion;
import Domain.Publicacion.PublicacionMascotaPerdida;
import java.util.ArrayList;
import java.util.Scanner;

public class Organizacion {
    public ArrayList<String> caracteristicas;
    public String nombre;
    public String ubicacion;
    public ArrayList<String> preguntas;
    public ArrayList<Publicacion> publicacionesDeAdopcionPendientes;
    public ArrayList<Publicacion> publicacionesDeAdopcionAceptadas;
    public ArrayList<Publicacion> publicacionMascotasPerdidas;
    // PARA INICIALIZAR Y QUE NO DE NULL
    public Organizacion(){
        this.caracteristicas = new ArrayList<>();
        this.preguntas = new ArrayList<>();
        this.publicacionesDeAdopcionPendientes = new ArrayList<>();
        this.publicacionesDeAdopcionAceptadas = new ArrayList<>();
        this.publicacionMascotasPerdidas = new ArrayList<>();
    }

    public void agregarCaracteristica(String nuevaCaracteristica){
        caracteristicas.add(nuevaCaracteristica);
    }
    //ENTREGA 2 PUNTO 5
    public void verPublicaciones(ArrayList<Publicacion> publicaciones){ // SE PUEDEN VER LAS PUBLICACIONES DE LA MASCOTAS PERDIDAS
        for (Publicacion publicacion : publicaciones) {
            publicacion.verPublicacion();
        }
    }
    //ENTREGA 2 PUNTO 5
    public void elegirPublicacionDeMascotaPerdida(){ //SI ENCUENTRA LA MASCOTA PUEDE VER LOS DATOS SENSIBLES
        Scanner indicar = new Scanner(System.in);
        Scanner indicarLugar = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("\n Opciones");
            System.out.println("[1] Encontre a mi mascota ");
            System.out.println("[2] No encontre a mi mascota");
            opcion = indicar.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Indicar el lugar de la publicacion ");
                    this.publicacionMascotasPerdidas.get(indicarLugar.nextInt()).accederADatosSensibles(); // VER LOS DATOS SENSIBLES DE LA PUBLICACION
                    break;
                case  2:
                    System.out.println("Lo lamentamos :( ");
                    break;
            }
        }while (opcion!=1 || opcion!=2);
    }
    //ENTREGA 3 PUNTO 1
    public int cantidad(ArrayList<String> lista){ return lista.size(); }
    public String verPregunta(int lugar){ return preguntas.get(lugar); } //ENVIA LA PREGUNTA NO LA MUESTRA POR PANTALLA
    public void agregarPublicacion(ArrayList<Publicacion> publicaciones, Publicacion publicacion){ publicaciones.add(publicacion); } //AGREGA A UNA DE LAS LISTAS

    //ENTREGA 3 PUNTO 1 /////////PREGUNTAR QUIEN TIENE QUE ACEPTAR O RECHAZAR, ACA SOLO SE VISUALIZA FALTA UN MENU PARA ACEPTAR/////////////////
    public void verPublicacionesParaAprobar(){
        for (Publicacion publicacion : publicacionesDeAdopcionPendientes) { //SE VISUALIZA TODA LA INFORMACION DE LA PUBLICACION (INFORMACION, PREGUNTAS Y RESPUESTAS)
            publicacion.verPublicacion();
            for(int i=0;i<publicacion.cantidad(publicacion.preguntas) ;i++){
                System.out.println(i+1 + ")" + publicacion.preguntas.get(i));
                System.out.println(publicacion.respuestas.get(i));
            }
        }
    }
    //ENTREGA 3 PUNTO 2  ///////// FALTA UN MENU PARA APROBAR O RECHAZAR
    public void agregarPregunta(String pregunta) { preguntas.add(pregunta); } //LA ORGANIZACION PUEDE AGREGAR SUS PREGUNTAS
    public void verTodasLasPreguntas(){ for (String pregunta : preguntas) System.out.println(pregunta); }
    public void modificarPregunta(int lugar,String nuevaPregunta){ preguntas.set(lugar,nuevaPregunta); } //LA ORGANIZACION PUEDE MODIFICAR LA PREGUNTA PERO NO LA PUBLICACION OSEA LA PUBLICACION SE GUARDA CON LAS RESPUESTAS Y PREGUNTAS ANTERIORES NO VA MODIFICAR A LAS PREGUNTAS DE LAS PUBLICACIONES QUE FUERON CONTESTADAS ANTES
    //ENTREGA 3 PUNTO 3
    //ACA HAY Q SEGUIR CON LA PARTE DE NOTIFICAR A LA PERSONA YO QUERIA MANDAR ESTE MENSAJE AL USUARIO
    public void notificar (Publicacion publicacion, Usuario usuarioInteresado){
        Notificacion notificacion = new Notificacion();
        notificacion.mensaje = "Nos comunicamos con usted para decirle que el usuario "+ usuarioInteresado.nombre + "esta interesado en adoptar a " + publicacion.mascota.nombre;
        notificacion.contacto = publicacion.usuario
                                           .contactos.get(0)
                                           .InformacionDeContacto;
        notificacion.ejecutarAviso();
    }

}
