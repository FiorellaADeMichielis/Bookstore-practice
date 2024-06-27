package Files.PaymentMethods;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cash extends Payment {
    @Override
    public void method(double price){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the amount of cash you are going to pay with");
        try{
            double cash = input.nextDouble();
            if(cash >= price){
                System.out.println("You've paid with $" + String.format("%.2f", cash)+ " in cash.\nYour change is $" + (cash - price));
            }else{
                System.out.println("Insufficient amount.");
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input" + e);
        }


    }
}
