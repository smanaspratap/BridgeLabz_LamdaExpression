public class LambdaExpression {

    @FunctionalInterface
    public interface Validate {
        boolean validate(String str);
    }

    // UC1: First Name (Cap + min 3)
    public static final Validate FIRST_NAME =
            name -> name != null && name.matches("^[A-Z][a-zA-Z]{2,}$");

    // UC2: Last Name (Cap + min 3)
    public static final Validate LAST_NAME =
            name -> name != null && name.matches("^[A-Z][a-zA-Z]{2,}$");

    // UC9: Email (valid + invalid list)
    public static final Validate EMAIL =
            email -> email != null &&
                    email.matches("^[A-Za-z0-9]+([._+-][A-Za-z0-9]+)*@[A-Za-z0-9]+(-[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}){1,2}$");

    // UC4: Mobile (91 9919819801)
    public static final Validate MOBILE =
            mobile -> mobile != null && mobile.matches("^[0-9]{2}\\s[6-9][0-9]{9}$");

    // UC5: Min 8 chars
    public static final Validate PASS_UC5_MIN8 =
            p -> p != null && p.length() >= 8;

    // UC6: At least 1 uppercase
    public static final Validate PASS_UC6_UPPER =
            p -> p != null && p.matches(".*[A-Z].*");

    // UC7: At least 1 digit
    public static final Validate PASS_UC7_DIGIT =
            p -> p != null && p.matches(".*[0-9].*");

    // UC8: Exactly 1 special character
    public static final Validate PASS_UC8_ONE_SPECIAL =
            p -> p != null && p.matches("^[A-Za-z0-9]*[!@#$%^&*()\\-+][A-Za-z0-9]*$");

    // Combined Password (UC5–UC8): ALL must pass
    public static final Validate PASSWORD_ALL =
            p -> PASS_UC5_MIN8.validate(p)
                    && PASS_UC6_UPPER.validate(p)
                    && PASS_UC7_DIGIT.validate(p)
                    && PASS_UC8_ONE_SPECIAL.validate(p);
}