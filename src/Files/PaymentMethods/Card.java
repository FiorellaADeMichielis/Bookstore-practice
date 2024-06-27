package Files.PaymentMethods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Card extends Payment {
    @Override
    public void method(double price){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the last 3 numbers in the back of your card");
        try{
            int code= input.nextInt();
            if(code >= 99){
                System.out.println("You've paid: "+ (price));
            }else{
                System.out.println("Wrong information provided");
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input" + e);
        }
    }
}
