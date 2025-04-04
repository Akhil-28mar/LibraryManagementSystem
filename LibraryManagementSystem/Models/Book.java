package LibraryManagementSystem.Models;

public class Book {
    private int quantity;
    private int lendingQuantity;
    private String bookName;

    public Book(String bookName, int quantity) {
        this.bookName = bookName;
        this.quantity = quantity;
        this.lendingQuantity = quantity;
    }
}
