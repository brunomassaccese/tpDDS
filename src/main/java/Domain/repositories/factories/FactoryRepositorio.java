package Domain.repositories.factories;

import config.Config;
import Domain.repositories.Repositorio;
import Domain.repositories.daos.*;
import Domain.repositories.testMemoData.Data;

import java.util.HashMap;

public class FactoryRepositorio {
    private static HashMap<String, Repositorio> repos;

    static {
        repos = new HashMap<>();
    }

    public static <T> Repositorio<T> get(Class<T> type){
        Repositorio<T> repo;
        if(repos.containsKey(type.getName())){  //se fija si la clase ya está cargada en el HashMap
            repo = repos.get(type.getName());
        }
        else{
            if(Config.useDataBase){ //si esta configurado el uso de la DB
                DAO<T> dao = new DAOHibernate<>(type);
                repo = new Repositorio<>(dao);
            }
            else{ //si sólo quiero trabajar en memoria
                repo = new Repositorio<>(new DAOMemoria<>(Data.getData(type)));
            }
            repos.put(type.toString(), repo);
        }
        return repo;
    }
}
