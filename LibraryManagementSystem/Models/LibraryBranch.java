package LibraryManagementSystem.Models;

import java.util.HashMap;
import java.util.List;

public class LibraryBranch {
    private String branchName;
    public String getBranchName() {
        return branchName;
    }

    private String location;
    private List<Book> books;
    private HashMap<Patron, List<Book>> lendedBookMap;
    private HashMap<Patron, List<Book>> reservedBookMap;

    public LibraryBranch(String branchName, String location, List<Book> books) {
        this.books = books;
        this.branchName = branchName;
        this.location = location;
        lendedBookMap = new HashMap<>();
        reservedBookMap = new HashMap<>();
    }
    

}
