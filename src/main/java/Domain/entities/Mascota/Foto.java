package Domain.entities.Mascota;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "foto")
public class Foto  {
    @Id
    @GeneratedValue
    private int id;

    //@Column(name = "path")
    //private String path;
    @Column(name = "image")
    private Blob image = null;

    @ManyToOne
    @JoinColumn(name = "mascota_id", referencedColumnName = "id")
    private Mascota mascota;

    public Foto(Blob image) {
        this.standarizar(image);
        //this.path = path;
        this.image = image;

    }

    private void standarizar(Blob image){
        //TODO
    }

}