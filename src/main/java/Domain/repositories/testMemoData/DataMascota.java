package Domain.repositories.testMemoData;

import Domain.entities.Mascota.Chapa.Chapa;
import Domain.entities.Mascota.Chapa.SinChapa;
import Domain.entities.Mascota.Estado;
import Domain.entities.Mascota.Foto;
import Domain.entities.Mascota.Mascota;
import Domain.entities.Organizacion.Caracteristica;
import Domain.entities.Publicacion.Comodidad;
import Domain.repositories.testMemoData.EntidadPersistente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Domain.repositories.testMemoData.DataUsuario;

public class DataMascota {
    private static List<Mascota> mascotas = new ArrayList<>();

    public static List<EntidadPersistente> getList(){
        if(mascotas.size() == 0){
            List<Foto> fotosMascota1 = new ArrayList<>(); //agregar fotos de ejemplo
            List<Caracteristica> caracteristicasMascota1 = new ArrayList<>();
            Chapa chapaMascota1 = new SinChapa();
            List<Comodidad> comodidadesMascota1 = new ArrayList<>();

            Mascota mascota1 = new Mascota("perro", "Firulais", "Firu",
                    4, "macho", Estado.ADOPTADO, "asadfa", fotosMascota1, caracteristicasMascota1,
                    chapaMascota1, DataUsuario.usuarios.get(0), comodidadesMascota1);
            DataUsuario.usuarios.get(0).registrarMascota(mascota1);

            List<Foto> fotosMascota2 = new ArrayList<>(); //agregar fotos de ejemplo
            List<Caracteristica> caracteristicasMascota2 = new ArrayList<>();
            Chapa chapaMascota2 = new SinChapa();
            List<Comodidad> comodidadesMascota2 = new ArrayList<>();

            Mascota mascota2 = new Mascota("gato", "Ramon", "Ramon",
                    4, "macho", Estado.ENCONTRADO, "asadfa", fotosMascota2, caracteristicasMascota2,
                    chapaMascota2, DataUsuario.usuarios.get(1), comodidadesMascota2);
            DataUsuario.usuarios.get(1).registrarMascota(mascota2);


            addAll(mascota1, mascota2);
        }
        return (List<EntidadPersistente>)(List<?>)mascotas;
    }

    private static void addAll(Mascota... mascotas){
        Collections.addAll(DataMascota.mascotas, mascotas);
    }
}
