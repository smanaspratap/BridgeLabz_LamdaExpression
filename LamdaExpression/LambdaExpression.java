import java.util.Scanner;

@FunctionalInterface
interface Validate{
    boolean validate(String str);
}

public class LambdaExpression {
    public static void main(String[] args){
        Validate v1 = str ->str.matches("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+$");
        System.out.println(v1.validate("abc@bl.in"));          // true
        System.out.println(v1.validate("abc.xyz@bl.co.in"));   // true
        System.out.println(v1.validate("abc..xyz@bl.co.in"));  // false
        System.out.println(v1.validate("abc@.in"));
        try(Scanner sc= new Scanner(System.in)){
            System.out.println("enter your email");
            String str= sc.nextLine();

            if(v1.validate(str)){
                System.out.println("correct");
            }else{
                System.out.println("incorrect");
            }
        }

    }
}