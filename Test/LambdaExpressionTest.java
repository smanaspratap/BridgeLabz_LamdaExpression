
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LambdaExpressionTest {

    // -------- UC1: First Name --------
    @Test
    void givenFirstName_WhenValid_ShouldReturnTrue() {
        assertTrue(LambdaExpression.FIRST_NAME.validate("Devraj"));
    }

    @Test
    void givenFirstName_WhenInvalid_ShouldReturnFalse() {
        assertFalse(LambdaExpression.FIRST_NAME.validate("devraj")); // no capital
        assertFalse(LambdaExpression.FIRST_NAME.validate("De"));     // < 3
        assertFalse(LambdaExpression.FIRST_NAME.validate("De1"));    // digit
        assertFalse(LambdaExpression.FIRST_NAME.validate(null));     // null
    }

    // -------- UC2: Last Name --------
    @Test
    void givenLastName_WhenValid_ShouldReturnTrue() {
        assertTrue(LambdaExpression.LAST_NAME.validate("Goswami"));
    }

    @Test
    void givenLastName_WhenInvalid_ShouldReturnFalse() {
        assertFalse(LambdaExpression.LAST_NAME.validate("goswami"));
        assertFalse(LambdaExpression.LAST_NAME.validate("Go"));
        assertFalse(LambdaExpression.LAST_NAME.validate("Go@"));
        assertFalse(LambdaExpression.LAST_NAME.validate(null));
    }

    // -------- UC9: Email (Parameterized) --------
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
    void givenEmail_WhenValid_ShouldReturnTrue(String email) {
        assertTrue(LambdaExpression.EMAIL.validate(email));
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
    void givenEmail_WhenInvalid_ShouldReturnFalse(String email) {
        assertFalse(LambdaExpression.EMAIL.validate(email));
    }

    // -------- UC4: Mobile --------
    @Test
    void givenMobile_WhenValid_ShouldReturnTrue() {
        assertTrue(LambdaExpression.MOBILE.validate("91 9919819801"));
    }

    @Test
    void givenMobile_WhenInvalid_ShouldReturnFalse() {
        assertFalse(LambdaExpression.MOBILE.validate("919919819801")); // no space
        assertFalse(LambdaExpression.MOBILE.validate("91 1234567890")); // starts not 6-9
        assertFalse(LambdaExpression.MOBILE.validate("91 99198"));      // too short
        assertFalse(LambdaExpression.MOBILE.validate(null));
    }

    // -------- UC5–UC8: Password (All rules) --------
    @Test
    void givenPassword_WhenValid_ShouldReturnTrue() {
        assertTrue(LambdaExpression.PASSWORD.validate("Abcdefg1@"));
    }

    @Test
    void givenPassword_WhenInvalid_ShouldReturnFalse() {
        assertFalse(LambdaExpression.PASSWORD.validate("Abc1@de"));     // <8
        assertFalse(LambdaExpression.PASSWORD.validate("abcdefg1@"));   // no uppercase
        assertFalse(LambdaExpression.PASSWORD.validate("Abcdefgh@"));   // no digit
        assertFalse(LambdaExpression.PASSWORD.validate("Abcdefg1"));    // no special
        assertFalse(LambdaExpression.PASSWORD.validate("Abcdefg1@@"));  // 2 specials
        assertFalse(LambdaExpression.PASSWORD.validate(null));
    }

    // -------- Optional: Validate All Fields Together --------
    @Test
    void givenAllFields_WhenValid_ShouldReturnTrue() {
        assertTrue(LambdaExpression.validateAll(
                "Devraj",
                "Goswami",
                "abc@yahoo.com",
                "91 9919819801",
                "Abcdefg1@"
        ));
    }

    @Test
    void givenAllFields_WhenAnyInvalid_ShouldReturnFalse() {
        assertFalse(LambdaExpression.validateAll(
                "devraj", // invalid first name
                "Goswami",
                "abc@yahoo.com",
                "91 9919819801",
                "Abcdefg1@"
        ));
    }
}