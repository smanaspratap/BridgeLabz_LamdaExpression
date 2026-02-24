import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LambdaExpressionTest {

    // ----------- VALID EMAILS (should PASS) -----------
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

    // ----------- INVALID EMAILS (should FAIL) -----------
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
}