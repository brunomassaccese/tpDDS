package Domain.repositories;

import Domain.repositories.daos.DAO;

import java.util.List;

public class Repositorio<T> {
    protected DAO<T> dao;

    public Repositorio(DAO<T> dao) { //dao es una Clase de algún objeto que quiero persistir
        this.dao = dao;
    }

    public void setDao(DAO<T> dao) {
        this.dao = dao;
    }

    public void agregar(Object unObjeto){
        this.dao.agregar(unObjeto);
    }

    public void modificar(Object unObjeto){
        this.dao.modificar(unObjeto);
    }

    public void eliminar(Object unObjeto){
        this.dao.eliminar(unObjeto);
    }

    public List<T> buscarTodos(){
        return this.dao.buscarTodos();
    }

    public T buscar(int id){
        return this.dao.buscar(id);
    }
}
