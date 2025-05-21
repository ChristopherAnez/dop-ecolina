package dop.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

record Phone(String countryCode, String phoneNumber) implements ContactType {

    private static final Logger log = LoggerFactory.getLogger(Phone.class);

    Phone {
        if (countryCode.isEmpty()) {
            log.error("Country code is empty");
            throw new IllegalArgumentException("Country code cannot be empty");
        }
    }

}
