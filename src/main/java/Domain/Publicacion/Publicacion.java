package Domain.Publicacion;

import Domain.Mascota.Mascota;
import Domain.Organizacion.Organizacion;
import Domain.Persona.Usuario;
import jdk.internal.jimage.ImageReaderFactory;

import java.util.ArrayList;

public class Publicacion {
    public Boolean estado;
    public Usuario usuario;//SERIA EL DUENIO DE LA MASCOTA
    public Mascota mascota;
    public Organizacion organizacion;//DIRIGIDA A ESTA ORGANIZACION
    public ArrayList<String> preguntas;
    public ArrayList<String> respuestas;

    //ENTREGA 2 PUNTO 5
    public void verPublicacion() {
        System.out.println("El nombre del duenio actual es :" + usuario.nombre + "," + usuario.apellido);
        System.out.println("El nombre de la mascota es :" + mascota.nombre);
        System.out.println("La mascota es : " + mascota.tipo);
        System.out.println("La mascota es : " + mascota.sexo);
        System.out.println(mascota.descripcion);
        System.out.println(mascota.fotos);
    }
    //SOLO PARA PUBLICACION DE MASCOTAS PERDIDAS
    public void accederADatosSensibles() { }
    public int cantidad(ArrayList<String> lista){ return lista.size(); }

    public void agregarUsuarioInteresado(Usuario usuario) {
    }
}
