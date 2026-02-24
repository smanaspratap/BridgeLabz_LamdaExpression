

public class LambdaExpression {

    @FunctionalInterface
    public interface Validate {
        boolean validate(String str);
    }

    // UC1
    public static final Validate FIRST_NAME =
            name -> name != null && name.matches("^[A-Z][a-zA-Z]{2,}$");

    // UC2
    public static final Validate LAST_NAME =
            name -> name != null && name.matches("^[A-Z][a-zA-Z]{2,}$");

    // UC9 Email (your valid/invalid list)
    public static final Validate EMAIL =
            email -> email != null &&
                    email.matches("^[A-Za-z0-9]+([._+-][A-Za-z0-9]+)*@[A-Za-z0-9]+(-[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}){1,2}$");

    // UC4
    public static final Validate MOBILE =
            mobile -> mobile != null && mobile.matches("^[0-9]{2}\\s[6-9][0-9]{9}$");

    // UC5–UC8
    public static final Validate PASS_UC5_MIN8 = p -> p != null && p.length() >= 8;
    public static final Validate PASS_UC6_UPPER = p -> p != null && p.matches(".*[A-Z].*");
    public static final Validate PASS_UC7_DIGIT = p -> p != null && p.matches(".*[0-9].*");
    public static final Validate PASS_UC8_ONE_SPECIAL =
            p -> p != null && p.matches("^[A-Za-z0-9]*[!@#$%^&*()\\-+][A-Za-z0-9]*$");

    public static final Validate PASSWORD_ALL =
            p -> PASS_UC5_MIN8.validate(p)
                    && PASS_UC6_UPPER.validate(p)
                    && PASS_UC7_DIGIT.validate(p)
                    && PASS_UC8_ONE_SPECIAL.validate(p);

    // ---------- Throwing methods ----------
    public static void validateFirstName(String firstName) throws UserRegistrationException {
        if (!FIRST_NAME.validate(firstName)) {
            throw new UserRegistrationException(
                    UserRegistrationException.Type.INVALID_FIRST_NAME,
                    "Invalid First Name"
            );
        }
    }

    public static void validateLastName(String lastName) throws UserRegistrationException {
        if (!LAST_NAME.validate(lastName)) {
            throw new UserRegistrationException(
                    UserRegistrationException.Type.INVALID_LAST_NAME,
                    "Invalid Last Name"
            );
        }
    }

    public static void validateEmail(String email) throws UserRegistrationException {
        if (!EMAIL.validate(email)) {
            throw new UserRegistrationException(
                    UserRegistrationException.Type.INVALID_EMAIL,
                    "Invalid Email"
            );
        }
    }

    public static void validateMobile(String mobile) throws UserRegistrationException {
        if (!MOBILE.validate(mobile)) {
            throw new UserRegistrationException(
                    UserRegistrationException.Type.INVALID_MOBILE,
                    "Invalid Mobile"
            );
        }
    }

    public static void validatePassword(String password) throws UserRegistrationException {
        if (!PASSWORD_ALL.validate(password)) {
            throw new UserRegistrationException(
                    UserRegistrationException.Type.INVALID_PASSWORD,
                    "Invalid Password"
            );
        }
    }
}