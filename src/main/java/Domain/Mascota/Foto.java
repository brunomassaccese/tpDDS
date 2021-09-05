package Domain.Mascota;

import javax.persistence.*;

//@Entity
//@Table(name = "foto")
public class Foto  {
 //   @Id
  //  @GeneratedValue
    private int id;

   // @Column(name = "path")
    private String path;

    //@ManyToOne
    //@JoinColumn(name = "mascota_id", referencedColumnName = "id")
    private Mascota mascota;

    public Foto(String path) {
        this.standarizar(path);
        this.path = path;
    }

    private void standarizar(String path){
        //TODO
    }

}