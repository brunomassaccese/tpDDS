package Domain.repositories.factories;

import config.Config;
import Domain.entities.Persona.Usuario;
import Domain.repositories.RepositorioDeUsuarios;
import Domain.repositories.daos.DAO;
import Domain.repositories.daos.DAOHibernate;
import Domain.repositories.daos.DAOMemoria;
import Domain.repositories.testMemoData.Data;

public class FactoryRepositorioUsuarios {
    private static RepositorioDeUsuarios repo;

    static {
        repo = null;
    }

    public static RepositorioDeUsuarios get(){
        if(repo == null){
            if(Config.useDataBase){
                DAO<Usuario> dao = new DAOHibernate<>(Usuario.class);
                repo = new RepositorioDeUsuarios(dao);
            }
            else{
                repo = new RepositorioDeUsuarios(new DAOMemoria<>(Data.getData(Usuario.class)));
            }
        }
        return repo;
    }
}
