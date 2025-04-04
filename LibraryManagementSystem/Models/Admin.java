package LibraryManagementSystem.Models;

public class Admin extends Patron {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private Admin(String phoneNumber, String name, String age) {
        super(phoneNumber, name, age);
    }

    public Admin(String phoneNumber, String name, String age, String password, String username) {
        this.username = username;
        this.password = password;
        this(phoneNumber, name, age);
    }

    public String changePassword(String newPassword) {
        password = newPassword;
        return newPassword;
    }
}
