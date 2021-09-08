package Domain.Mascota;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

//VERIFICAR SI HAY QUE PERSISTIR TODO
public enum Estado {
    PERDIDO,
    ADOPTADO,
    ENCONTRADO
}
