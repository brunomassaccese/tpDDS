package Domain.entities.Publicacion;

import javax.persistence.*;

@Entity
@Table(name = "comodidad")
public class Comodidad {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String comodidad;

    public String getComodidad() {
        return comodidad;
    }

    public void setComodidad(String comodidad) {
        this.comodidad = comodidad;
    }

}
