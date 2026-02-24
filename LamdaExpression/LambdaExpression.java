import java.util.Scanner;

@FunctionalInterface
interface Validate{
    boolean validate(String str);
}

public class LambdaExpression {
    public static void main(String[] args){
        Validate v1 = str ->
                str != null && str.length() >= 8;

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