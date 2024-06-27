package Files.Books;
import java.util.ArrayList;
import java.util.List;
public class SaleStock extends Stock{
    private List<BookForSale> saleStock = new ArrayList<>();

    public List<BookForSale> getSaleStock() {
        return saleStock;
    }

    public List<Book> searchBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        //searches for a book with a matching author in the list of books available for sale
        for (BookForSale bookForSale : getSaleStock()) {
            //if the book is found
            if (bookForSale.getAuthor().equalsIgnoreCase(author)) {
                result.add(bookForSale);
            }
        }
        return result;
    }
    @Override
    public List<Book> searchBookByName(String name) {
        List<Book> result = new ArrayList<>();
        //searches for books with a matching author in the list of books available for sale
        for (BookForSale bookForSale : getSaleStock()) {
            //if the book is found
            if (bookForSale.getName().equalsIgnoreCase(name)) {
                result.add(bookForSale);
            }
        }
        return result;
    }
    @Override
    public List<Book> searchBookByCategory(String category) {
        List<Book> result = new ArrayList<>();
        //searches for books with a matching category in the list of books available for sale
        for (BookForSale bookForSale : getSaleStock()) {
            //if the book is found
            if (bookForSale.getCategory().equalsIgnoreCase(category)) {
                result.add(bookForSale);
            }
        }
        return result;
    }
    @Override
    public List<Book> searchSpecificBook(String name, String author, String category) {
        List<Book> result = new ArrayList<>();
        //searches for a specific book in the list of books available for sale
        for (BookForSale bookForSale : getSaleStock()) {
            //if the book is found
            if (bookForSale.getName().equalsIgnoreCase(name) && bookForSale.getAuthor().equalsIgnoreCase(author) && bookForSale.getCategory().equalsIgnoreCase(category)) {
                result.add(bookForSale);
            }
        }
        return result;
    }

}
