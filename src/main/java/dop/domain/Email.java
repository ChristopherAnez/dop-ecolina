package dop.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Esto es un Record Java Class ...
 */
record Email(String address) implements ContactType {

    private static final Logger log = LoggerFactory.getLogger(Email.class);

    /*
     * Podemos acceder a los Java Record Components a traves de un Constructor Compacto, y ejecutar alguna validación.
     */

    Email {
        if (!address.contains("@")) {
            log.error("Email address contains invalid characters");
            throw new IllegalArgumentException("Email address contains invalid characters");
        }
    }


}


