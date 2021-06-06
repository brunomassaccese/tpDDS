package Domain.EstrategiaDeNotificacion;

import com.sendgrid.*;
import java.io.IOException;

public class NotificaciónMail implements Strategy {

    public static final String emailOrigen = "Rescastistas";
    public static final String authToken = "476ebdad8135ba4b1e7385c30a389e0f";

    public static void enviarAviso(InfoContacto contacto, String mensaje){
        Email from = new Email(emailOrigen);
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email(contacto.email);
        Content content = new Content("text/plain", mensaje);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv(authToken));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}