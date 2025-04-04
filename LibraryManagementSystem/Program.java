package LibraryManagementSystem;

public class Program {
    public static void main(String[] args) {
        LibraryManagementApplication kitaabGhar = new LibraryManagementApplication();
        kitaabGhar.startApp();
        kitaabGhar.login();
        kitaabGhar.chooseFlow();
        var branch = kitaabGhar.getBranch();
    }
}