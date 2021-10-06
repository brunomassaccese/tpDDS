package Domain.entities.EstrategiaDeNotificacion;

import Domain.entities.Persona.Contacto;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Table(name = "estrategia_contacto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Strategy {
    @Id
    @GeneratedValue
    private int id;

    public static void enviarAviso(Contacto contacto, String mensaje) throws IOException {

    }
}