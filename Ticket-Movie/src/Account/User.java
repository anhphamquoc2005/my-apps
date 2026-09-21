package Account;

public class User {
    public String username;
    public String password;
    public String fullName;
    public int age;
    public String phoneNumber;
    public static int numOfUser;

    public User() {
        numOfUser++;
    }

    public void printInfo() {
        System.out.printf("\n%s | %s | %s | %d | %s\n", username, password, fullName, age, phoneNumber);
    }

    public void printNumOfUser() {
        System.out.printf("Đang có %d người đã đăng ký vào hệ thống.\n", numOfUser);
    }
}
