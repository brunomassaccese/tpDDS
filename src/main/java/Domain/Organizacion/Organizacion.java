package Domain.Organizacion;

import java.util.List;

public class Organizacion {
    private List<String> caracteristicas = null;

    public void agregarCaracteristica(String nuevaCaracteristica){
        caracteristicas.add(nuevaCaracteristica);
    }
}

/*
import java.util.ArrayList;

public class Organizacion {

    public String nombre;
    public ArrayList<String> preguntas;
    public ArrayList<Publicacion> publicacionesPendientes;
    public ArrayList<Publicacion> publicacionesAceptadas;

    public Organizacion(){
        this.preguntas = new ArrayList<>();
        this.publicacionesPendientes = new ArrayList<>();
        this.publicacionesAceptadas = new ArrayList<>();
    }

    public void agregarPublicacion(ArrayList<Publicacion> publicaciones, Publicacion publicacion){ publicaciones.add(publicacion); } //AGREGA A UNA DE LAS LISTAS SIRVE PARA EL PUNTO 1

    public void agregarPregunta(String pregunta) { preguntas.add(pregunta); } //LA ORGANIZACION PUEDE AGREGAR SUS PREGUNTAS PUNTO 2

    public void verTodasLasPreguntas(){ for (String s : preguntas) System.out.println(s); }

    public int cantidadDePreguntas(){ return preguntas.size(); }

    public void modificarPregunta(int lugar,String nuevaPregunta){ preguntas.set(lugar,nuevaPregunta); } // LA ORGANIZACION PUEDE MODIFICAR LA PREGUNTA PERO NO LA PUBLICACION OSEA LA PUBLICACION SE GUARDA CON LAS RESPUESTAS Y PREGUNTAS ANTERIORES NO VA MODIFICAR A LAS PREGUNTAS DE LAS PUBLICACIONES QUE FUERON CONTESTADAS ANTES PUNTO 2

    public void verPublicaciones(ArrayList<Publicacion> publicaciones){

        for (Publicacion publicacion : publicaciones) {

            System.out.println(publicacion.usuario.nombre);
            System.out.println(publicacion.mascota.nombre);

            for(int i=0;i<publicacion.cantidad(publicacion.preguntas) ;i++){
                System.out.println(i+1 + ")" + publicacion.preguntas.get(i));
                System.out.println(publicacion.respuestas.get(i));
            }
        }
    }

    //PUNTO 3 ACA HAY Q SEGUIR CON LA PARTE DE NOTIFICAR A LA PERSONA YO QUERIA MANDAR ESTE MENSAJE AL USUARIO
    //queria guardarlo como una lista de mensajes para el usuario no se si se puede
    public void notificar (Publicacion publicacion, Usuario usuarioInteresado){
        System.out.println("Nos comunicamos con usted para decirle que el usuario "+ usuarioInteresado.nombre + "esta interesado en adoptar a " + publicacion.mascota.nombre);
    }
}

*/