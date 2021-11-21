package Domain.repositories;

import Domain.entities.Organizacion.Caracteristica;
import Domain.entities.Persona.Usuario;
import Domain.repositories.daos.DAO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeCaracteristicas extends Repositorio<Caracteristica> {

    public RepositorioDeCaracteristicas(DAO<Caracteristica> dao) {
        super(dao);
    }

    public Caracteristica buscarCaracteristica(String nombreDeCaracteristica){
        return this.dao.buscar(condicionNombreDeCaracteristica(nombreDeCaracteristica));
    }

    private BusquedaCondicional condicionNombreDeCaracteristica(String nombreDeCaracteristica){
        CriteriaBuilder criteriaBuilder = criteriaBuilder();
        CriteriaQuery<Caracteristica> caracteristicaQuery = criteriaBuilder.createQuery(Caracteristica.class);
        Root<Caracteristica> condicionRaiz = caracteristicaQuery.from(Caracteristica.class);

        Predicate CondicionNombreDeCaracteristica = criteriaBuilder.equal(condicionRaiz.get("nombre"), nombreDeCaracteristica);
        //Predicate condicionContrasenia = criteriaBuilder.equal(condicionRaiz.get("password"), contrasenia);

        //Predicate condicionExisteUsuario = criteriaBuilder.and(condicionNombreDeUsuario, condicionContrasenia);

        caracteristicaQuery.where(CondicionNombreDeCaracteristica);

        return new BusquedaCondicional(null, caracteristicaQuery);
    }
}
