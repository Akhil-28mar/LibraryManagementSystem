package LibraryManagementSystem.Utilities;

import java.util.Scanner;
import LibraryManagementSystem.Database.Users;
import LibraryManagementSystem.Models.Patron;

public class IOUtility {
    private static Scanner scanner;

    public static <T> T getInputOptionValue(T[] options) {
        scanner = new Scanner(System.in);

        int response = scanner.nextInt();
        if (response < 0 || response >= options.length) {
            scanner.close();
            throw new IllegalArgumentException("Invalid input: " + response);
        }

        scanner.close();
        return options[response-1];
    }

    public static <T> void showOptions(T[] options) {
        System.out.println("Please select one of the following options: ");
        int optionNumber = 1;
        for (T option : options) {
            System.out.println(optionNumber + " " + option);
            optionNumber++;
        }
    }

    public static Patron login() {
        scanner = new Scanner(System.in);       
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        scanner.close();

        var loginUser = Users.getloginUser(username, password);
        if (loginUser == null) {
            System.out.println("Invalid username or Password");
            return null;
        }
        return loginUser;
    }
}
