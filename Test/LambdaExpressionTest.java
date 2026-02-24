
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LambdaExpressionTest {

    // ---------- FIRST NAME ----------
    @Test
    void givenFirstName_WhenValid_ShouldNotThrow() {
        assertDoesNotThrow(() -> LambdaExpression.validateFirstName("Devraj"));
    }

    @Test
    void givenFirstName_WhenInvalid_ShouldThrowCustomException() {
        UserRegistrationException ex = assertThrows(
                UserRegistrationException.class,
                () -> LambdaExpression.validateFirstName("devraj")
        );
        assertEquals(UserRegistrationException.Type.INVALID_FIRST_NAME, ex.getType());
    }

    // ---------- LAST NAME ----------
    @Test
    void givenLastName_WhenValid_ShouldNotThrow() {
        assertDoesNotThrow(() -> LambdaExpression.validateLastName("Goswami"));
    }

    @Test
    void givenLastName_WhenInvalid_ShouldThrowCustomException() {
        UserRegistrationException ex = assertThrows(
                UserRegistrationException.class,
                () -> LambdaExpression.validateLastName("go")
        );
        assertEquals(UserRegistrationException.Type.INVALID_LAST_NAME, ex.getType());
    }

    // ---------- EMAIL (Parameterized) ----------
    @ParameterizedTest
    @ValueSource(strings = {
            "abc@yahoo.com",
            "abc-100@yahoo.com",
            "abc.100@yahoo.com",
            "abc111@abc.com",
            "abc-100@abc.net",
            "abc.100@abc.com.au",
            "abc@1.com",
            "abc@gmail.com.com",
            "abc+100@gmail.com"
    })
    void givenEmail_WhenValid_ShouldNotThrow(String email) {
        assertDoesNotThrow(() -> LambdaExpression.validateEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc",
            "abc@.com.my",
            "abc123@gmail.a",
            "abc123@.com",
            "abc123@.com.com",
            ".abc@abc.com",
            "abc()*@gmail.com",
            "abc@%*.com",
            "abc..2002@gmail.com",
            "abc.@gmail.com",
            "abc@abc@gmail.com",
            "abc@gmail.com.1a",
            "abc@gmail.com.aa.au"
    })
    void givenEmail_WhenInvalid_ShouldThrowCustomException(String email) {
        UserRegistrationException ex = assertThrows(
                UserRegistrationException.class,
                () -> LambdaExpression.validateEmail(email)
        );
        assertEquals(UserRegistrationException.Type.INVALID_EMAIL, ex.getType());
    }

    // ---------- MOBILE ----------
    @Test
    void givenMobile_WhenValid_ShouldNotThrow() {
        assertDoesNotThrow(() -> LambdaExpression.validateMobile("91 9919819801"));
    }

    @Test
    void givenMobile_WhenInvalid_ShouldThrowCustomException() {
        UserRegistrationException ex = assertThrows(
                UserRegistrationException.class,
                () -> LambdaExpression.validateMobile("919919819801")
        );
        assertEquals(UserRegistrationException.Type.INVALID_MOBILE, ex.getType());
    }

    // ---------- PASSWORD ----------
    @Test
    void givenPassword_WhenValid_ShouldNotThrow() {
        assertDoesNotThrow(() -> LambdaExpression.validatePassword("Abcdefg1@"));
    }

    @Test
    void givenPassword_WhenInvalid_ShouldThrowCustomException() {
        UserRegistrationException ex = assertThrows(
                UserRegistrationException.class,
                () -> LambdaExpression.validatePassword("abcdefg1@") // no uppercase
        );
        assertEquals(UserRegistrationException.Type.INVALID_PASSWORD, ex.getType());
    }
}