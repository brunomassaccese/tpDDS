package Domain.entities.Organizacion;

import javax.persistence.*;

@Entity
@Table
public class Caracteristica {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nombre")
    private String nombre;

    public Caracteristica(String nuevaCaracteristica) {
        this.nombre = nuevaCaracteristica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
