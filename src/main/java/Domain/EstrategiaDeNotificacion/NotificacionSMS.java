package Domain.EstrategiaDeNotificacion;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class NotificacionSMS implements Strategy{
    public static final String accountSID = "AC33121f4c303cfee95e60773c42dd36ab";
    public static final String authToken = "476ebdad8135ba4b1e7385c30a389e0f";
    public static final String numeroOrigen = "+18325166562";

    public static void enviarAviso(InfoContacto contacto, String mensaje) {
        Twilio.init(accountSID, authToken);

        Message message = Message.creator(new PhoneNumber(contacto.telefono), new PhoneNumber(numeroOrigen),
                            mensaje).create();

        System.out.println(message.getSid());
    }

}
