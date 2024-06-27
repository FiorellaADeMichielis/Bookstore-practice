package Files;
import Files.PaymentMethods.*;
import Files.Books.BookOrdered;
import java.util.ArrayList;
import java.util.List;
public class Order {
    private List<BookOrdered> shoppingCart = new ArrayList<>();
    private Payment i;



    public void addToShoppingCart(BookOrdered bookOrdered){
        shoppingCart.add(bookOrdered);
    }
    public double totalPrice(){
        double total = 0;
        for(BookOrdered bookOrdered : shoppingCart){
            total +=bookOrdered.totalPrice();
        }
        return total;
    }
    public void ProcessPayment(Payment payment){
        i = payment;
        payment.method(totalPrice());
    }
}
