package Domain.Mascota;

public class Publicacion {
    public Integer idRescatista;
    public Boolean estadoDePublicacion = false;
    public Mascota mascotaEncontrada;
    //Fotos
}

/*
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.ArrayList;

public class Publicacion {
    public Boolean estado;
    public Usuario usuario; //seria el duenio de la mascota
    public Mascota mascota;
    public Organizacion organizacion;
    public ArrayList<String> preguntas; //CREE ESTO PARA Q SE GUARDE LAS PREGUNTAS PARA Q CUANDO LA ORGANIZACION MODIFIQUE ALGUNA PREGUNTA, ESTA NO SE VEA AFECTADA Y Q LA RESPUESTA NO TENGA SENTIDO //PUNTO 2
    public ArrayList<String> respuestas;
    public ArrayList<Usuario> usuariosInteresados; //LISTA DE INTERESADOS PUNTO 3

    public Publicacion(){ // LO PUNGO ASI PARA Q NO ME PONGA E ERROR NULL
        this.respuestas = new ArrayList<>();
        this.preguntas = new ArrayList<>();
        this.usuariosInteresados = new ArrayList<>();
        this.estado = false;
    }

    public void cambiarEstado(){
        estado = !estado;
    }

    public void agregarUsuarioInteresado(Usuario usuarioInteresado){//PUNTO 3 ACA SE AGREGA Y LE ENVIA LA ORDEN A LA ORGANIZACION PARA Q AVISE A LA PERSONA QUE INICIO LA PUBLICACION (DUENIO)
        this.usuariosInteresados.add(usuarioInteresado);
        this.organizacion.notificar(this,usuarioInteresado); // por el momento con esta funcion
    }

    public void agregar(ArrayList<String> lista, String preguntaOrespuesta){ lista.add(preguntaOrespuesta); }

    public int cantidad(ArrayList<String> lista){ return lista.size(); }

    public boolean verificarPreguntas(){ //VERIFICA Q TODOS ESTEN CONTESTADOS PUNTO 1

        for(int i=0; i<organizacion.preguntas.size() ;i++){ //verificar que ninguna este vacia
            if(respuestas.get(i).equals("")){
                return false;
            }
        }
        return true;
    }

    public void enviar(){//VA A ENVIARSE A SI MISMO A LA ORGANIZACION PERO ANTES VERIFICA PUNTO 1

        boolean verifica = this.verificarPreguntas();

        if (verifica){
            this.organizacion.agregarPublicacion(organizacion.publicacionesPendientes,this);//SE ENVIA Y SE AGREGA A LA LISTA DE PENDIENTES DE LA ORGANIZACION
            System.out.println("La publicacion fue enviada con exito, espere a ser respondido");
        }
        else {
            System.out.println("La publicacion no pudo ser enviada, responda todas las preguntas y envie de nuevo, gracias");//NO SE ENVIA
        }
    }

    public void mostrarPublicacionAUsuario(){
            System.out.println("Organizacion receptora" + this.organizacion.nombre);
            System.out.println("Mascota registrada para adoptar" + this.mascota.nombre);
    }

}
*/