package Domain.entities.Persona;

import javax.persistence.*;

@Entity
@Table
public class Permiso {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre;
    @Column
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
