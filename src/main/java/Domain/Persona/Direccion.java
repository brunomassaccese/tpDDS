package Domain.Persona;

import javax.persistence.*;

@Entity
@Table
public class Direccion {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String calle;
    @Column
    private int altura;

}
