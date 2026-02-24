
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

    // UC9 Email rule (passes your valid list, fails invalid list)
    public static final Validate EMAIL =
            email -> email != null &&
                    email.matches("^[A-Za-z0-9]+([._+-][A-Za-z0-9]+)*@[A-Za-z0-9]+(-[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}){1,2}$");

    // UC4: Mobile (91 9919819801)
    public static final Validate MOBILE =
            mobile -> mobile != null && mobile.matches("^[0-9]{2}\\s[6-9][0-9]{9}$");

    // UC5–UC8 Password rules combined (ALL must pass)
    public static final Validate PASSWORD =
            p -> p != null
                    && p.length() >= 8                 // UC5
                    && p.matches(".*[A-Z].*")          // UC6
                    && p.matches(".*[0-9].*")          // UC7
                    && p.matches("^[A-Za-z0-9]*[!@#$%^&*()\\-+][A-Za-z0-9]*$"); // UC8 exactly 1 special

    // Optional: Validate all fields together (returns true only if all are valid)
    public static boolean validateAll(String first, String last, String email, String mobile, String password) {
        return FIRST_NAME.validate(first)
                && LAST_NAME.validate(last)
                && EMAIL.validate(email)
                && MOBILE.validate(mobile)
                && PASSWORD.validate(password);
    }
}