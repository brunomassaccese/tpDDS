package hogaresAPI.entities;

import java.math.BigDecimal;
import com.google.gson.annotations.SerializedName;

public class Ubicacion {

    public String direccion;

    @SerializedName("lat")
    public BigDecimal latitud;

    @SerializedName("long") //reemplaza longitud x long
    public BigDecimal longitud;
}
