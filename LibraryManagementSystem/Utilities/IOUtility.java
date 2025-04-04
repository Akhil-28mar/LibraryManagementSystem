package LibraryManagementSystem.Utilities;

import java.util.Scanner;
import LibraryManagementSystem.Models.LoginCredentialModel;

public class IOUtility {
    private static Scanner scanner;

    public static void showWelcomeMessage() {
        System.out.println("Welcome to Library Management System");
        System.out.println();
    }

    public static <T> T getInputOptionValue(T[] options) {
        showOptions(options);
        scanner = new Scanner(System.in);

        int response = scanner.nextInt();
        if (response < 0 || response >= options.length) {
            scanner.close();
            throw new IllegalArgumentException("Invalid input: " + response);
        }

        scanner.close();
        return options[response-1];
    }

    private static <T> void showOptions(T[] options) {
        System.out.println("Please select one of the following options: ");
        int optionNumber = 1;
        for (T option : options) {
            System.out.println(optionNumber + " " + option);
            optionNumber++;
        }
    }

    public static LoginCredentialModel getloginCredentials() {
        scanner = new Scanner(System.in);       
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        scanner.close();

        return new LoginCredentialModel(username, password);
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }
}
