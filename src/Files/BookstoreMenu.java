package Files;
import Files.Books.*;
import Files.PaymentMethods.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookstoreMenu {
    public static void main(String[] args){
        RentStock rentStock = new RentStock();
        SaleStock saleStock = new SaleStock();
        BookForRent rent1 = new BookForRent("The Grass is Always Greener", "Jeffrey Archer","Modern Times", 30, 2000.00, 0 );
        BookForRent rent2 = new BookForRent("The Speckled Band","Arthur Conan Doyle","Crime", 40, 2300.00, 0);
        BookForRent rent3 = new BookForRent("The Five Orange Pips","Arthur Conan Doyle","Crime",25, 3000.00, 0);
        BookForRent rent4 = new BookForRent("The Signalman","Charles Dickens","Suspense", 10, 3100.00, 0);
        BookForRent rent5 = new BookForRent("The Pit and the Pendulum","Edgar Allan Poe","Suspense", 5, 4000, 0);
        rentStock.addToRentStock(rent1);
        rentStock.addToRentStock(rent2);
        rentStock.addToRentStock(rent3);
        rentStock.addToRentStock(rent4);
        rentStock.addToRentStock(rent5);
        clientMenu(rentStock, saleStock);
    }

    public static void clientMenu(RentStock rentStock, SaleStock saleStock){
        Scanner read = new Scanner(System.in);
        int input;
        do{
            try{
                System.out.println("\t\t\t Welcome to the bookstore \n1. Rent books\n2.Buy books\n");
                input = read.nextInt();
                switch(input){
                    case 1:
                        rentOrder(rentStock);
                        break;
                    case 2:
                        saleOrder(saleStock);
                        break;
                    default:
                        System.out.println("Please enter a valid option");
                        break;
                }
            }catch(InputMismatchException exception) {
                System.out.println("That was not a number >:( \nRedirecting to main menu...\n");
                read.next();
                input = 0;
            }
        }while (input >= 0);
    }

    public static void saleOrder (SaleStock saleStock) {
        Scanner read = new Scanner(System.in);
        int input;
        try {
            searchBooks(saleStock);
            System.out.println("\n1.Search for other books\n\nEnter any other number to add books to your order");
            input = read.nextInt();
            read.nextLine();
            while (input == 1) {
                searchBooks(saleStock);
            }
            placeOrder(saleStock);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, redirecting to the main menu...\n");
            read.next();
            input = read.nextInt();
        }
    }

    public static void searchBooks(Stock stock)throws InputMismatchException{
        int input;
        Scanner read = new Scanner(System.in);
        System.out.println("Search books by: \n 1. name\n2.Author\n3.Category\n4.Look for a specific book\n");
        input =read.nextInt();
        read.nextLine();
        String name, author, category;
        List<Book> result;
        do{
            switch (input) {
                case 1:
                    System.out.println("Name:");
                    name = read.nextLine();
                    result = stock.searchBookByName(name);
                    showBooks(result);
                    return;

                case 2:
                    System.out.println("Author:");
                    author = read.nextLine();
                    result = stock.searchBookByAuthor(author);
                    showBooks(result);
                    return;
                case 3:
                    System.out.println("Category:");
                    category = read.nextLine();
                    result = stock.searchBookByCategory(category);
                    showBooks(result);
                   return;
                case 4:
                    System.out.println("Name:");
                    name = read.nextLine();
                    System.out.println("Author:");
                    author = read.nextLine();
                    System.out.println("Category: ");
                    category = read.nextLine();
                    result = stock.searchSpecificBook(name, author, category);
                    showBooks(result);
                    return;
                default:
                    System.out.println("Sorry, enter a valid option\n");
                    input = read.nextInt();
                    return;
            }
        }while( input < 5 && input > 0);
    }
    public static void placeOrder(Stock stock) throws InputMismatchException {
        Scanner read = new Scanner(System.in);
        Order client = new Order();
        String name, author, category;
        Book book;
        int amount, input;
        boolean option=true;
        while (option){
            System.out.println("Please enter the book you are looking for:\nName:\n");
            name = read.nextLine();
            System.out.println("Author:\n");
            author =read.nextLine();
            System.out.println("Category:\n");
            category = read.nextLine();
            if(stock.searchSpecificBook(name, author, category) != null){
                book = stock.searchSpecificBook(name, author, category).getFirst();
                System.out.println("Enter the amount of copies you want to buy:\n");
                amount =read.nextInt();
                BookOrdered bookOrdered = new BookOrdered(book, book.reduceStockAndSetAmount(amount));
                client.addToShoppingCart(bookOrdered);
                System.out.println(bookOrdered.getBook().getName() +" by " + bookOrdered.getBook().getAuthor() + " added to your cart\nEnter 1 to add another book to your order\n");
                input = read.nextInt();
                option = (input == 1);
            }else{
                System.out.println("You can't order a book we don't have :(");
                option = false;
            }
        }
        processPayment(client);
    }
    public static void processPayment(Order client) throws InputMismatchException{
        Scanner read = new Scanner(System.in);
        Payment payment = null;
        boolean option = true;
        int input;
        System.out.println("Please choose a payment method:\n1.Card\n2.Cash\n");
        while (option){
            input = read.nextInt();
            read.nextLine();
            switch(input){
                case 1:
                    payment = new Card();
                    client.ProcessPayment(payment);
                    option = false;
                    break;
                case 2:
                    payment = new Cash();
                    client.ProcessPayment(payment);
                    option = false;
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    input = read.nextInt();
                    read.nextLine();
            }
        }

    }
    public static void showBooks(List<Book> result){
        if(!result.isEmpty()) {
            System.out.println("Books that match your request\n------------------------------\n");
            for (Book book : result){
                book.showDetails();
            }
        }else{
            System.out.println("Sorry, none of our books match your request :( \n");
        }
    }
    public static void rentOrder(RentStock rentStock) {
        Scanner read = new Scanner(System.in);
        int input;
        do {
            try {
                searchBooks(rentStock);
                System.out.println("\n1.Search for other books\n\nEnter any other number to add books to your order");
                input = read.nextInt();
                read.nextLine();
                while (input == 1) {
                    searchBooks(rentStock);
                }
                placeOrder(rentStock);
            } catch (InputMismatchException e) {
                System.out.println("That was not a number >:( \nRedirecting to the menu...\n");
                read.next();
                input = 0;
            }
        } while (input >= 0);
    }



}
