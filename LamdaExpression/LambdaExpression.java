import java.util.Scanner;

@FunctionalInterface
interface Validate{
    boolean validate(String str);
}

public class LambdaExpression {
    public static void main(String[] args){
        Validate v1 = str -> str.matches("^[A-Za-z0-9]+([._+-][A-Za-z0-9]+)*@[A-Za-z0-9]+(-[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}){1,2}$");

        // A) VALID emails
        System.out.println(v1.validate("abc@yahoo.com"));          // true
        System.out.println(v1.validate("abc-100@yahoo.com"));      // true
        System.out.println(v1.validate("abc.100@yahoo.com"));      // true
        System.out.println(v1.validate("abc111@abc.com"));         // true
        System.out.println(v1.validate("abc-100@abc.net"));        // true
        System.out.println(v1.validate("abc.100@abc.com.au"));     // true
        System.out.println(v1.validate("abc@1.com"));              // true
        System.out.println(v1.validate("abc@gmail.com.com"));      // true
        System.out.println(v1.validate("abc+100@gmail.com"));      // true

        // B) INVALID emails
        System.out.println(v1.validate("abc"));                    // false
        System.out.println(v1.validate("abc@.com.my"));            // false
        System.out.println(v1.validate("abc123@gmail.a"));         // false
        System.out.println(v1.validate("abc123@.com"));            // false
        System.out.println(v1.validate("abc123@.com.com"));        // false
        System.out.println(v1.validate(".abc@abc.com"));           // false
        System.out.println(v1.validate("abc()*@gmail.com"));       // false
        System.out.println(v1.validate("abc@%*.com"));             // false
        System.out.println(v1.validate("abc..2002@gmail.com"));    // false
        System.out.println(v1.validate("abc.@gmail.com"));         // false
        System.out.println(v1.validate("abc@abc@gmail.com"));      // false
        System.out.println(v1.validate("abc@gmail.com.1a"));       // false
        System.out.println(v1.validate("abc@gmail.com.aa.au"));    // fals
    }

}