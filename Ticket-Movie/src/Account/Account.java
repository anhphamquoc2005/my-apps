package Account;

public class Account {
    public String username;
    public String password;
    public String fullName;
    public int age;
    public String phoneNumber;
    boolean isEnrolled;

    public Account(String username, String password, String fullName, int age, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.isEnrolled = true;
    }
}
