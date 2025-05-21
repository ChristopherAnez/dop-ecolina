package dop;

import dop.domain.ContactType;
import dop.domain.User;
import dop.service.LoginVerificationService;
import dop.service.LoginVerificationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppDemo {

    private static final Logger log = LoggerFactory.getLogger(AppDemo.class);

    public static void main(String[] args) {

        var christopher = new User("Christopher", new ContactType.Email("coanezp@gmail.com"));
        var valentina = new User("Valentina", new ContactType.Phone("+58", "4143603151"));

        // Instancia directa de la implementación del servicio
        LoginVerificationService verificationService = new LoginVerificationServiceImpl();

        // Uso de la instancia del servicio
        verificationService.sendVerificationCode(christopher);
        verificationService.sendVerificationCode(valentina);

        log.info("completed");
    }
}
