package Domain.entities.Organizacion;

import javax.persistence.*;

@Entity
@Table
public class Pregunta {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
