package LibraryManagementSystem.Models;

public class LoginCredentialModel {
    public String username;
    public String password;

    public LoginCredentialModel(String username, String password) {
        this.password = password;
        this.username = username;
    }
}
