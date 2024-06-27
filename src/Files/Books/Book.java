package Files.Books;

//
 abstract public class Book {
    private String name;
    private String author;
    private String category;
    private int stock;


        /*public Book(String name, String author, String category, boolean available){
            this.name = name;
            this.author = author;
            this.category = category;
            this.available = true;
        }*/
        public Book(String name, String author, String category, int stock){
            this.name = name;
            this.author = author;
            this.category = category;
            this.stock = stock;
        }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }
    public int getStock(){
            return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public abstract void showDetails();
    public abstract double total(int amount);
    public abstract int reduceStockAndSetAmount(int amount);
}
