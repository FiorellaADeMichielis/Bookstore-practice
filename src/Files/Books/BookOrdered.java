package Files.Books;
public class BookOrdered {
    private Book book;

    private int amount;

    public BookOrdered(Book book, int amount){
        this.book = book;
        this.amount = amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public int getAmount() {
        return amount;
    }
    public double totalPrice(){
        return book.total(amount);
    }
}
