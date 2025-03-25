package LibraryManagementSystem.Database;

import java.util.List;
import LibraryManagementSystem.Models.Patron;

public class Users {
    public static List<Patron> UserList;

    public static Patron getloginUser(String username, String password) {
        var patron = UserList.stream()
                             .filter(user -> user.username == username && user.password == password)
                             .findFirst()
                             .orElse(null); ;
        return patron;
    }
}
