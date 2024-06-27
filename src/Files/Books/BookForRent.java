package Files.Books;

public class BookForRent extends Book {
    private double priceRent;
    private int rentalDays;
    private boolean available;
    public BookForRent(String name, String author, String category, int stock, double priceRent, int rentalDays){
        super(name, author, category, stock);
        this.priceRent = priceRent;
        this.rentalDays = rentalDays;
        this.available = true;
    }
    public boolean getAvailable(){
        return available;
    }
    @Override
    public double total(int amount){
        return priceRent*amount;
    }
    @Override
    public void showDetails(){
        System.out.println(getName() +" - "+ getAuthor() +" - "+ getCategory() + " - $"+priceRent+" - "+rentalDays);
    }

    @Override
    public int reduceStockAndSetAmount(int amount){
        int stock = this.getStock();
        if(stock < amount){
            amount = stock;
            this.setStock(0);
            this.available = false;
            System.out.println("Not enough books available. Amount set to: "+ amount+"\n");
            return amount;
        }
        this.setStock(stock -= amount);
        return amount;
    }
}
