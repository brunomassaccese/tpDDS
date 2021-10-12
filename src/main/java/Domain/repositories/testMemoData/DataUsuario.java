package Domain.repositories.testMemoData;

import Domain.entities.EstrategiaDeNotificacion.NotificacionMail;
import Domain.entities.Persona.*;
import Domain.repositories.Repositorio;
import Domain.repositories.factories.FactoryRepositorio;

import java.time.LocalDate;
import java.util.*;

public class DataUsuario {
    public static List<Usuario> usuarios = new ArrayList<>();
    public static Map<String, String> mapUsuariosClaves = new HashMap<String, String>();

    public static List<EntidadPersistente> getList(){

        NotificacionMail noti1 = new NotificacionMail();
        Direccion dire1 = new Direccion("Conde", 90);
        List<Contacto> listaContactos1 = new ArrayList<>();;
        Contacto contacto1 = new Contacto(noti1, "mario", "lorenzo", "3252-1451", "mario@hotmail.com", true);
        listaContactos1.add(contacto1);

        NotificacionMail noti2 = new NotificacionMail();
        Direccion dire2 = new Direccion("Maure", 3300); //hacer Constructor xq no tiene
        List<Contacto> listaContactos2 = new ArrayList<>();;
        Contacto contacto2 = new Contacto(noti1, "claudio", "leal", "4352-7421", "claudio@hotmail.com", true);
        listaContactos2.add(contacto2);

        Usuario mario = new Usuario("Mario", "Lorenzo", LocalDate.of(1990, 11, 13),
                dire1, TipoDeDocumento.DNI, "30120670",
                listaContactos1, "ab1", "PDR");


        Usuario claudio = new Usuario("Claudio", "Leal", LocalDate.of(1980, 03, 30),
                dire2, TipoDeDocumento.DNI, "40320020", listaContactos2, "ab2", "CLeal");

        if(usuarios.size() == 0) {
            addAll(mario, claudio);
            mapUsuariosClaves.put(mario.getNombre(), mario.getPassword());
            mapUsuariosClaves.put(claudio.getNombre(), claudio.getPassword());
        }
        return (List<EntidadPersistente>)(List<?>) usuarios;
    }

    private static void addAll(Usuario ... usuarios){
        Collections.addAll(DataUsuario.usuarios, usuarios);
    }
}
