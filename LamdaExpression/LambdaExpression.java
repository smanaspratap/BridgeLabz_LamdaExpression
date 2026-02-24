import java.util.Scanner;

@FunctionalInterface
interface Validate{
    boolean validate(String str);
}

public class LambdaExpression {
    public static void main(String[] args){
        Validate v1 = (str) -> str!=null && str.matches("^[A-Z][a-zA-Z]{2,}$");

        try(Scanner sc= new Scanner(System.in)){
            System.out.println("enter name");
            String str= sc.nextLine().trim();

            if(v1.validate(str)){
                System.out.println("correct");
            }else{
                System.out.println("incorrect");
            }
        }

    }
}