package LibraryManagementSystem.PresentationLayer;

import LibraryManagementSystem.Utilities.IOUtility;

public class ScreenOrchestrator {

    public  void login() {
        var loginUser = IOUtility.getloginCredentials();
        if (loginUser == null) {
            login();
        }
    }
}
