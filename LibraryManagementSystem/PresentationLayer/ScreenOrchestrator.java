package LibraryManagementSystem.PresentationLayer;

import LibraryManagementSystem.Models.Enums.InitialOptions;
import LibraryManagementSystem.Utilities.IOUtility;

public class ScreenOrchestrator {
    public static void startApp() {
        System.out.println("Welcome to Library Management System");
        System.out.println();
        login();
    }

    public static void login() {
        var loginUser = IOUtility.login();
        if (loginUser == null) {
            login();
        }
        
    }

    public static void startInitialFlow() {
        IOUtility.showOptions(InitialOptions.values());
        var input = IOUtility.getInputOptionValue(InitialOptions.values());
        switch (input) {
            case InitialOptions.Login:
                loginFlow();
                break;
            case InitialOptions.Signup:
                signupFlow();
                break;
            default:
                break;
        }
    }

    public static void loginFlow() {

    }

    public static void signupFlow() {

    }
}
