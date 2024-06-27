package Files.Books;

import java.util.ArrayList;
import java.util.List;

public abstract class Stock {
    private List<Book> stock = new ArrayList<>();
    public abstract List<Book> searchBookByName(String name);
    public abstract List<Book> searchBookByAuthor(String author);
    public abstract List<Book> searchBookByCategory(String category);
    public abstract List<Book> searchSpecificBook(String name, String author, String category);


}
