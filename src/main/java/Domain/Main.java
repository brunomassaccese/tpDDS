package Domain;

import Domain.Persona.Rescatista;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) throws IOException {

        Rescatista resc1 = new Rescatista("Juan", "Perez",
                           LocalDate.of(1990, Month.JULY, 20),
                "San Martin 4030", null, null);
        resc1.buscarHogarTransito();
    }

}
