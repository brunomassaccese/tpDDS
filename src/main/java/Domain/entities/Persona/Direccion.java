package Domain.entities.Persona;

import javax.persistence.*;

@Entity
@Table
public class Direccion {

    public Direccion(String calle_rcv, int altura_rcv) {
        calle = calle_rcv;
        altura = altura_rcv;
    }

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String calle;

    @Column
    private int altura;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Persona usuario;

}
