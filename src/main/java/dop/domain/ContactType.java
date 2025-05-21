package dop.domain;

/*
 * Desde la interfaz aplico el control sobre mis entidades de dominio
 * (Nota: Puedes separar los records de esta interfaz).
 */
public sealed interface ContactType permits ContactType.Email, ContactType.Phone {

    record Email(String address) implements ContactType {
        /*
         * Podemos acceder a los Java Record Components a traves de un Constructor Compacto, y ejecutar alguna validación.
         */
        public Email {
            if (!address.contains("@")) {
                throw new IllegalArgumentException("Email address contains invalid characters");
            }
        }
    }

    record Phone(String countryCode, String phoneNumber) implements ContactType {
        public Phone {
            if (countryCode.isEmpty()) {
                throw new IllegalArgumentException("Country code cannot be empty");
            }
        }

    }


}
