package Domain.repositories.factories;

import Domain.entities.Organizacion.Caracteristica;
import Domain.entities.Persona.Usuario;
import Domain.repositories.RepositorioDeCaracteristicas;
import Domain.repositories.RepositorioDeUsuarios;
import Domain.repositories.daos.DAO;
import Domain.repositories.daos.DAOHibernate;
import Domain.repositories.daos.DAOMemoria;
import Domain.repositories.testMemoData.Data;
import config.Config;

public class FactoryRepositorioCaracteristicas {
    private static RepositorioDeCaracteristicas repo;

    static {
        repo = null;
    }

    public static RepositorioDeCaracteristicas get(){
        if(repo == null){
            if(Config.useDataBase){
                DAO<Caracteristica> dao = new DAOHibernate<>(Caracteristica.class);
                repo = new RepositorioDeCaracteristicas(dao);
            }
            else{
                repo = new RepositorioDeCaracteristicas(new DAOMemoria<>(Data.getData(Caracteristica.class)));
            }
        }
        return repo;
    }
}
