package Domain.Persona;

import Domain.EstrategiaDeNotificacion.Strategy;
import Domain.Mascota.Mascota;
import Domain.Organizacion.Organizacion;
import Domain.Publicacion.PublicacionDeAdopcion;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario extends Persona implements Strategy {
    public ArrayList<Mascota> mascotas;

    public Usuario(){
        this.mascotas = new ArrayList<>();
        this.contactos = new ArrayList<>();
    }

    public void registrarMascota(Mascota mascota){ //VER RELACION CON ESTADO
        this.mascotas.add(mascota);
    }

    //ENTREGA 3 PUNTO 1
    public void generarPublicacionDeAdopcion(Organizacion organizacion, Mascota mascota){ //PUNTO 1 GENERA UNA PUBLICACION PARA ADOPCION
        PublicacionDeAdopcion publicacion = new PublicacionDeAdopcion(); //INICIALIZA LA PUBLICACION PUNTO 1
        publicacion.usuario = this;//ASIGNA PUNTO 1
        publicacion.organizacion = organizacion;
        publicacion.mascota = mascota;
        this.responderPreguntas(publicacion);//RESPONDE PREGUNTAS PUNTO 1
        publicacion.enviar();//ENVIA PASA A LA CLASE PUBLICACION PUNTO 1
    }
    //ENTREGA 3 PUNTO 1
    public void responderPreguntas(PublicacionDeAdopcion publicacion){ //PUNTO 1
        Organizacion organizacion = publicacion.organizacion; //PARA NO REPETIR
        int cantidad = organizacion.cantidad(organizacion.preguntas);
        Scanner respuesta = new Scanner (System.in); //PARA GUARDAR LAS RESPUESTAS
        System.out.println("Responda todas las preguntas");
        for(int i=0; i<cantidad ;i++){
            System.out.println(i+1 + ")" + organizacion.verPregunta(i)); //MUESTRA LA RESPUESTA DE LA ORGANIZACION
            publicacion.agregar(publicacion.preguntas, organizacion.verPregunta(i)); //GUARDA LA PREGUNTA EN LA PUBLICACION
            publicacion.agregar(publicacion.respuestas, respuesta.nextLine()); // GUARDA LA RESPUESTA EN LA PUBLICACION
        }
    }
    //ENTREGA 3 PUNTO 3
    public void buscarMascotaParaAdoptar(Organizacion organizacion){
        organizacion.verPublicaciones(organizacion.publicacionesDeAdopcionAceptadas);
        //FALTARIA UN MENU PARA ELEGIR A LA MASCOTA A LA CUAL ESTOY INTERESADO Y ELEGIR LA PUBLICACION EN LA CUAL ESTOY INTERESADO
    }

    public void interesado (int posicion, Organizacion organizacion){ //ESCOGE UNA PUBLICACION Y ESTA SE LE ENVIA A LA PUBLICACION LA CUAL LA AGREGARA A SU LISTA DE INTERESADOS
        organizacion.publicacionesDeAdopcionAceptadas.get(posicion).agregarUsuarioInteresado(this);
    }

    public void verDatos(){
        System.out.println("Nombre : " + this.nombre);
        System.out.println("Apellido : " + this.apellido);
        System.out.println("Direccion : " + this.direccion);
        this.verContactos();
    }

}
