package LibraryManagementSystem.Models;

public class Patron {
    private int id;
    private String phoneNumber;
    private String name;
    public String getName() {
        return name;
    }

    private String age;

    private static int idGenerator = 0;

    public Patron(String phoneNumber, String name, String age) {
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.name = name;

        id = ++idGenerator;
    }

    public Patron changeMyInfo(String phoneNumber, String name, String age) {
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.name = name;

        return this;
    }
}
