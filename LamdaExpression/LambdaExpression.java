import java.util.Scanner;

@FunctionalInterface
interface Validate{
    boolean validate(String str);
}

public class LambdaExpression {
    public static void main(String[] args){
        Validate v1 = mobile ->
                mobile != null && mobile.matches("^[0-9]{2}\\s[6-9][0-9]{9}$");

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