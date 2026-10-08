package Account;

public class Account {

    public String username;
    public String password;
    public String fullName;
    public int age;
    public String phoneNumber;
    boolean isEnrolled;
    User user;
    Admin admin;

    public Account(String typeAccount) {
        this.username = "";
        this.password = "";
        this.fullName = "";
        this.age = 0;
        this.phoneNumber = "";
        this.isEnrolled = false;
        this.user = new User(typeAccount);
    }

    public Account(String username, String password, String typeAccount) {
        this.username =  username;
        this.password = password;
        this.admin = new Admin(typeAccount);
    }

    public void printInfo() {
        System.out.printf("\n%s | %s | %s | %d | %s\n", username, password, fullName, age, phoneNumber);
    }
}
