package Account;

public class User extends Account{

    public User(String username, String password, String fullName, int age, String phoneNumber) {
        super(username, password, fullName, age, phoneNumber);
    }

    public void printInfo() {
        System.out.printf("\n%s | %s | %s | %d | %s\n", username, password, fullName, age, phoneNumber);
    }
}
