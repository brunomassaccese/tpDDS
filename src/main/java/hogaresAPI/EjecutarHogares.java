package hogaresAPI;

import hogaresAPI.entities.Hogar;
import hogaresAPI.entities.ListadoHogares;
import io.jsonwebtoken.io.IOException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class EjecutarHogares {

    public static void main(String[] args) throws IOException, java.io.IOException {

        int offset = 1; //hardcodeado
        int total;
        ServicioHogares servicioHogares = ServicioHogares.instancia();
        List<Hogar> listaHogaresTemp = java.util.Arrays.asList();

        /*
        do {
            ListadoHogares listadoDeHogares = servicioHogares.listadoDeHogares(offset);
            offset++;
            total = listadoDeHogares.total;
            listaHogaresTemp = Stream.concat(listaHogaresTemp.stream(), listadoDeHogares.hogares.stream())
                    .collect(Collectors.toList());
        } while ((offset * 10) <= total);
        */

        ListadoHogares listadoDeHogares = servicioHogares.listadoDeHogares(offset);
        total = listadoDeHogares.total;

        int cantGETs;
        if ((total % 10) > 0) //tal vez vienen 43 hogares, tengo que hacer 5 GET
            cantGETs = (total / 10) + 1;
        else
            cantGETs = (total / 10);

        for (int i = 1; i <= cantGETs; i++) {
            listadoDeHogares = servicioHogares.listadoDeHogares(i);
            listaHogaresTemp = Stream.concat(listaHogaresTemp.stream(), listadoDeHogares.hogares.stream())
                                       .collect(Collectors.toList());
        }


        for (Hogar unHogar : listaHogaresTemp) { //se puede hacer con un foreach()
            System.out.println(unHogar.nombre);
        }
    }
}