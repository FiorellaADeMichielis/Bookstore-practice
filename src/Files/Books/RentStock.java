package Files.Books;
import java.util.ArrayList;
import java.util.List;

public class RentStock extends Stock{
    private List<BookForRent> rentStock = new ArrayList<>();
    public void addToRentStock(BookForRent bookForRent) {
        rentStock.add(bookForRent);
    }

    public List<BookForRent> getRentStock() {
        return rentStock;
    }
    @Override
    public List<Book> searchBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        //searches for a book with a matching author in the list of books available for rent
        for (BookForRent bookForRent : getRentStock()) {
            //if the book is found
            if (bookForRent.getAuthor().equalsIgnoreCase(author)) {
                result.add(bookForRent);
            }
        }
        return result;
    }
@Override
    public List<Book> searchBookByName(String name) {
        List<Book> result = new ArrayList<>();
        //searches for a book with a matching name in the list of books available for rent
        for (BookForRent bookForRent : getRentStock()) {
            //if the book is found
            if (bookForRent.getName().equalsIgnoreCase(name)) {
                result.add(bookForRent);
            }
        }
        return result;
    }
@Override
    public List<Book> searchBookByCategory(String category) {
        List<Book> result = new ArrayList<>();
        //searches for a book with a matching category in the list of books available for rent
        for (BookForRent bookForRent : getRentStock()) {
            //if the book is found
            if (bookForRent.getCategory().equalsIgnoreCase(category)) {
                result.add(bookForRent);
            }
        }
        return result;
    }

    @Override
    public List<Book> searchSpecificBook(String name, String author, String category) {
        List<Book> result = new ArrayList<>();
        //searches for a specific book in the list of books available for rent
        for (BookForRent bookForRent : getRentStock()) {
            //if the book is found
            if (bookForRent.getName().equalsIgnoreCase(name) && bookForRent.getAuthor().equalsIgnoreCase(author) && bookForRent.getCategory().equalsIgnoreCase(category)) {
                result.add(bookForRent);
            }
        }
        return result;
    }



}
