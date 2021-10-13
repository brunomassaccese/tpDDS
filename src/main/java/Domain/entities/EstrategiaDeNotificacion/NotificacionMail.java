package Domain.entities.EstrategiaDeNotificacion;

import Domain.entities.Persona.Contacto;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.IOException;

@Entity
@DiscriminatorValue("mail")
public class NotificacionMail extends Strategy {

    public static final String emailOrigen = "Rescastistas";
    public static final String authToken = "476ebdad8135ba4b1e7385c30a389e0f";

    public static void enviarAviso(Contacto destinatario, String mensaje) throws IOException {
        Email from = new Email(emailOrigen);
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email(destinatario.getEmail());
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