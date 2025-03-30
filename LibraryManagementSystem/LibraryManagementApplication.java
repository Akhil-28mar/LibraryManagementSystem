package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import LibraryManagementSystem.Models.Admin;
import LibraryManagementSystem.Models.LibraryBranch;
import LibraryManagementSystem.Models.Patron;
import LibraryManagementSystem.Models.Enums.CommonOperations;
import LibraryManagementSystem.Models.Enums.InitialFlows;
import LibraryManagementSystem.Utilities.IOUtility;

public class LibraryManagementApplication {
    public List<LibraryBranch> branches;
    public List<Admin> admins;
    private List<Patron> patrons;
    public Admin currentUser;

    public LibraryManagementApplication() {
        seedData();
    }

    public void startApp() {
        IOUtility.showWelcomeMessage();
    }

    public void login() {
        var credentials = IOUtility.getloginCredentials();
        var admin = getLoginAdmin(credentials.username, credentials.password);

        if(admin == null) { 
            IOUtility.showMessage("Invalid Credentials, Please try again");
            login();
        }
        currentUser = admin;
        IOUtility.showMessage("Welcome " + admin.getName());
    }

    public void chooseFlow() {
        var flow = IOUtility.getInputOptionValue(InitialFlows.values());
        switch (flow) {
            case AdminManagement:
                manageAdmins();
                break;
        
            default:
                break;
        }
    }

    private void manageAdmins() {
        var operation = IOUtility.getInputOptionValue(CommonOperations.values());
        switch (operation) {
            case Add:
                Admin admin = IOUtility.getNewAdminDetails();
                addNewAdmin(admin);
                break;
            case Delete:
                deleteMyAccount();
                break;
            case Update:
                Admin admin = IOUtility.getNewAdminDetails();
                modifyMyDetails(admin);
            default:
                break;
        }
    }

    public Admin addNewAdmin(Admin admin) {
        if(adminAlreadyExists(admin.getUsername()) != null) {
            return null;
        }

        admins.add(admin);
        return admin;
    }

    public void deleteMyAccount() {
        admins.remove(currentUser);
        IOUtility.showMessage("Account Deleted Successfully....");
        IOUtility.showMessage("You are logged out....");
        startApp();
    }

    public Admin modifyMyDetails(Admin admin) {
        currentUser = admin;
        IOUtility.showMessage("Account Details Updated Successfully....");
        return admin;
    }

    public LibraryBranch addNewBranch(LibraryBranch newBranch) {
        if(branchAlreadyExists(newBranch.getBranchName()) != null) {
            return null;
        }

        branches.add(newBranch);
        return newBranch;
    }

    public LibraryBranch removeBranch(String branchName) {
        var branch = branchAlreadyExists(branchName);
        if(branch == null) return null;

        branches.remove(branch);
        return branch;
    }

    public LibraryBranch modifyBranchDetails(LibraryBranch branch) {
        var branchToBeModified = branchAlreadyExists(branch.getBranchName());
        if(branchToBeModified == null) return null;

        branchToBeModified = branch;
        return branchToBeModified;
    }

    public List<LibraryBranch> getAllBranches() {
        return branches;
    }

    private Admin getLoginAdmin(String username, String password) {
        return admins.stream().filter(admin -> admin.getUsername() == username && admin.getPassword() == password)
                            .findFirst().orElse(null);
    }

    private Admin adminAlreadyExists(String username) {
        if (admins.isEmpty()) return null;
        return admins.stream().filter(admin -> admin.getUsername().equals(username)).findFirst().orElse(null);
    }

    private LibraryBranch branchAlreadyExists(String branchName) {
        if (branches.isEmpty()) return null;
        return branches.stream().filter(branch -> branch.getBranchName().equals(branchName)).findFirst().orElse(null);
    }

    private void seedData() {
        admins = new ArrayList<>();
        branches = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public LibraryBranch getBranch() {
        IOUtility.showMessage("Select your branch");
        List<String> branchNames = new ArrayList<>();
        for (LibraryBranch branch : branches) {
            branchNames.add(branch.getBranchName());
        }
        var branchName = IOUtility.getInputOptionValue(branchNames.toArray());
        return branches.stream().filter(branch -> branch.getBranchName().equals(branchName)).findFirst().orElse(null);
    }
}
