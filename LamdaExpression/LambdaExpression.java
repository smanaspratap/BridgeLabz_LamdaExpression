import java.util.Scanner;

@FunctionalInterface
interface Validate{
    boolean validate(String str);
}

public class LambdaExpression {
    public static void main(String[] args){
        Validate v1 = str ->
                str != null && str.length() >= 8;

        Validate v2 = str ->str.matches(".*[A-Z].*");

        try(Scanner sc= new Scanner(System.in)){
            System.out.println("enter your email");
            String str= sc.nextLine();

            if(v1.validate(str) && v2.validate(str)){
                System.out.println("correct");
            }else{
                System.out.println("incorrect");
            }
        }

    }
}