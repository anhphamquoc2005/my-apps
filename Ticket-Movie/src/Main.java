import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username;
        String password;
        String loginUser;
        String loginPass;
        String phoneNumber;
        int age;
        int select = 0;

        do {
            System.out.println("=== Đặt vé xem Beta Cinema ===");
            System.out.println("1. Đăng ký tài khoản");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Bạn chỉ có thể nhập số để lựa chọn.");
                System.out.print("Chọn: ");
                scanner.next();
            }

            select = scanner.nextInt();
            scanner.nextLine();

            switch (select) {
                case 1 -> {
                    System.out.print("\nTạo tên đăng nhập: ");
                    username = scanner.nextLine();
                    while (username.length() < 6 || username.length() > 12 || username.contains(" ") || username.contains("_")) {
                        System.out.println("Tên đăng nhập phải có từ 6 - 12 ký tự!");
                        System.out.println("Tên đăng nhập không được chứa khoảng trống hay dấu gạch dưới!");
                        System.out.print("\nTạo tên đăng nhập: ");
                        username = scanner.nextLine();
                        while (username.length() < 6 || username.length() > 12) {
                            System.out.println("Tên đăng nhập phải có từ 6 - 12 ký tự!");
                            System.out.print("\nTạo tên đăng nhập: ");
                            username = scanner.nextLine();
                        }

                        while (username.contains(" ") || username.contains("_")) {
                            System.out.println("Tên đăng nhập không được chứa khoảng trống hay dấu gạch dưới!");
                            System.out.print("\nTạo tên đăng nhập: ");
                            username = scanner.nextLine();
                        }
                    }

                    System.out.print("\nTạo mật khẩu: ");
                    password = scanner.nextLine();
                    while (password.length() < 8 || password.length() > 16 && password.contains(" ") || password.contains("_")) {
                        System.out.println("Mật khẩu phải có từ 6 - 12 ký tự!");
                        System.out.println("Mật khẩu không được chứa khoảng trống hay dấu gạch dưới!");
                        System.out.print("\nTạo mật khẩu: ");
                        password = scanner.nextLine();

                        while (password.length() < 8 || password.length() > 16) {
                            System.out.println("Mật khẩu phải có từ 6 - 12 ký tự!");
                            System.out.print("\nTạo mật khẩu: ");
                            password = scanner.nextLine();
                        }

                        while (password.contains(" ") || password.contains("_")) {
                            System.out.println("Mật khẩu không được chứa khoảng trống hay dấu gạch dưới!");
                            System.out.print("\nTạo mật khẩu: ");
                            password = scanner.nextLine();
                        }
                    }

                    System.out.println("\nTạo tài khoản thành công!\n");
                }

                case 2 -> {
                    break;
                }
                case 3 -> {
                    System.out.println("\nCảm ơn quý khách đã sử dụng dịch vụ!");
                    break;
                }
            }
        } while (select != 3);

        scanner.close();
    }
}
