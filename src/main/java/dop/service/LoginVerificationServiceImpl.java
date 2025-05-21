package dop.service;

import dop.domain.ContactType;
import dop.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class LoginVerificationServiceImpl implements LoginVerificationService {

    private static final Logger log = LoggerFactory.getLogger(LoginVerificationServiceImpl.class);

    @Override
    public void sendVerificationCode(User user) {
        var code = ThreadLocalRandom.current().nextInt(1000, 10000);
        switch (user.contactType()) {
            case ContactType.Phone phone -> phoneVerification(code, user.name(), phone);
            case ContactType.Email email -> emailVerification(code, user.name(), email);
        }
    }

    private static void emailVerification(int code, String name, ContactType.Email email) {
        log.info("sending the code {} to {} via email {}", code, name, email.address());
    }

    private static void phoneVerification(int code, String name, ContactType.Phone phone) {
        log.info("sending the code {} to {} via phone {}-{}", code, name, phone.countryCode(), phone.phoneNumber());
    }

}
