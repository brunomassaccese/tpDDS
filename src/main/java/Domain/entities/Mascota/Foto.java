package Domain.entities.Mascota;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.File;
import java.io.FileOutputStream;
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
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "mascota_id", referencedColumnName = "id")
    private Mascota mascota;

    public Foto(byte[] image) {
        this.standarizar(image);
        //this.path = path;
        this.image = image;
    }

    private void standarizar(byte[] image){
        //TODO
    }

}