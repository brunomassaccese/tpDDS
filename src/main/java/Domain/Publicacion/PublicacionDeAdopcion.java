package Domain.Publicacion;

import Domain.Persona.Usuario;

import java.util.ArrayList;

public class PublicacionDeAdopcion extends Publicacion {
    public ArrayList<Usuario> usuariosInteresados;
    public ArrayList<String> preguntas;
    public ArrayList<String> respuestas;

    public PublicacionDeAdopcion(){
        this.usuariosInteresados = new ArrayList<>();
        this.preguntas = new ArrayList<>();
        this.respuestas = new ArrayList<>();
    }

    //ENTREGA 3 PUNTO 1
    public void agregar(ArrayList<String> lista, String agregar) { lista.add(agregar); }
    //ENTREGA 3 PUNTO 1
    public void enviar(){ //VA A ENVIARSE A SI MISMO A LA ORGANIZACION PERO ANTES VERIFICA PUNTO 1
        boolean verifica = this.verificarPreguntas();
        if (verifica){
            this.organizacion.agregarPublicacion(organizacion.publicacionesDeAdopcionPendientes,this);//SE ENVIA Y SE AGREGA A LA LISTA DE PENDIENTES DE LA ORGANIZACION
            System.out.println("La publicacion fue enviada con exito, espere a ser respondido");
        }
        else {
            System.out.println("La publicacion no pudo ser enviada, responda todas las preguntas y envie de nuevo, gracias");//NO SE ENVIA
        }
    }
    //ENTREGA 3 PUNTO 1
    public boolean verificarPreguntas(){ //VERIFICA Q TODOS ESTEN CONTESTADOS
        int cantidadDePreguntas = organizacion.cantidad(organizacion.preguntas);
        for(int i=0; i<cantidadDePreguntas ;i++){ //VERIFICAR QUE NINGUNA ESTE VACIA
            if(respuestas.get(i).equals("")){
                return false;
            }
        }
        return true;
    }
    //ENTREGA 3 PUNTO 3
    @Override
    public void agregarUsuarioInteresado(Usuario usuario) { //HAY Q VER ESTA PARTE LA ORGANIZACION NO LA ENVIA TODAVIA
        usuariosInteresados.add(usuario);
        System.out.println("Muchas Gracias usted");
        organizacion.notificar(this,usuario);
    }


}
