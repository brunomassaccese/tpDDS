package Domain.repositories.testMemoData;

import Domain.entities.Persona.Usuario;
import Domain.entities.Persona.Rol;
import Domain.repositories.Repositorio;
import Domain.repositories.factories.FactoryRepositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataUsuario {
    private static List<Usuario> usuarios = new ArrayList<>();

    public static List<EntidadPersistente> getList(){
        if(usuarios.size() == 0) {
            Repositorio<Rol> repoRol = FactoryRepositorio.get(Rol.class);

            Usuario lucas = new Usuario();


            Usuario eze = new Usuario();


            Usuario gaston = new Usuario();


            Usuario ezeS = new Usuario();


            addAll(lucas, eze, gaston, ezeS);
        }
        return (List<EntidadPersistente>)(List<?>) usuarios;
    }

    private static void addAll(Usuario ... usuarios){
        Collections.addAll(DataUsuario.usuarios, usuarios);
    }
}
