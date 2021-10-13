package Domain.repositories.testMemoData;

import Domain.entities.Organizacion.Caracteristica;
import Domain.entities.Persona.Rol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataCaracteristicas {
    public static List<Caracteristica> caracteristicas = new ArrayList<>();

    public static List<EntidadPersistente> getList(){
        if(caracteristicas.size() == 0){
            Caracteristica pequeño = new Caracteristica("Pequeño");
            Caracteristica mediano = new Caracteristica("Mediano");
            Caracteristica grande = new Caracteristica("Grande");
            Caracteristica flaco = new Caracteristica("Flaco");
            Caracteristica gordo = new Caracteristica("Gordo");
            Caracteristica callejero = new Caracteristica("Callejero");
            Caracteristica raza = new Caracteristica("De raza");

            addAll(pequeño, mediano,grande, flaco,gordo,callejero,raza);
        }
        return (List<EntidadPersistente>)(List<?>)caracteristicas;
    }

    private static void addAll(Caracteristica... caracteristicas){
        Collections.addAll(DataCaracteristicas.caracteristicas, caracteristicas);
    }
}
