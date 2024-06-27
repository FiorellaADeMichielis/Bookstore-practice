package Files.Books;

public class BookForSale extends Book {
    private double priceBuy;
    public BookForSale(String name, String author, String category, int stock){
        super(name, author, category, stock);
        this.priceBuy = priceBuy;
    }
    @Override
    public double total(int amount){
        return priceBuy*amount;
    }
    @Override
    public void showDetails() {
        System.out.println(getName() +" - "+ getAuthor() +" - "+ getCategory() +" - $"+ priceBuy);
    }
    @Override
    public int reduceStockAndSetAmount(int amount){
        int stock = this.getStock();
        if(stock < amount){
            amount = stock;
            this.setStock(0);
            System.out.println("Not enough books available. Amount set to: "+ amount+"\n");
            return amount;
        }
        this.setStock(stock -= amount);
        return amount;
    }
}

