import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        String username = "";
        String password = "";
        String loginUser;
        String loginPass;
        String phoneNumber;
        String characterChair;
        double priceBill;
        double sumBill;
        boolean isStudent;
        boolean isSenior;
        int amount;
        int age;
        int select = 0;

        do {
            inMenu();
            System.out.print("Chọn: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Bạn chỉ có thể nhập số để lựa chọn.");
                System.out.print("Chọn: ");
                scanner.nextLine();
            }

            select = scanner.nextInt();
            scanner.nextLine();

            switch (select) {
                case 1 -> {
                    System.out.print("\nTạo tên đăng nhập: ");
                    username = scanner.nextLine();
                    while (username.length() < 6 || username.length() > 12 || username.contains(" ") || username.contains("_")) {

                        if (username.length() < 6 || username.length() > 12) {
                            System.out.println("Tên đăng nhập phải có từ 6 - 12 ký tự!");
                        }

                        if (username.contains(" ") || username.contains("_")) {
                            System.out.println("Tên đăng nhập không được chứa khoảng trống hay dấu gạch dưới!");
                        }

                        System.out.print("\nTạo tên đăng nhập: ");
                        username = scanner.nextLine();
                    }

                    System.out.print("\nTạo mật khẩu: ");
                    password = scanner.nextLine();
                    while (password.length() < 8 || password.length() > 16 || password.contains(" ") || password.contains("_")) {

                        if (password.length() < 8 || password.length() > 16) {
                            System.out.println("Mật khẩu phải có từ 8 - 16 ký tự!");
                        }

                        if (password.contains(" ") || password.contains("_")) {
                            System.out.println("Mật khẩu không được chứa khoảng trống hay dấu gạch dưới!");
                        }

                        System.out.print("\nTạo mật khẩu: ");
                        password = scanner.nextLine();
                    }

                    System.out.print("\nĐang tải");

                    for (int i = 3; i > 0; i--) {
                        System.out.print(".");
                        Thread.sleep(1000);
                    }

                    System.out.println("\n\nTạo tài khoản thành công!\n");

                    Thread.sleep(1000);
                }

                case 2 -> {
                    System.out.print("Tên đăng nhập: ");
                    loginUser = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    loginPass = scanner.nextLine();
                    while (!loginUser.equalsIgnoreCase(username) || loginUser.isEmpty() && !loginPass.equalsIgnoreCase(password) || loginPass.isEmpty()) {
                        System.out.println("Tên đăng nhập hoặc mật khẩu không khớp\n");
                        System.out.print("Tên đăng nhập: ");
                        loginUser = scanner.nextLine();
                        System.out.print("Nhập mật khẩu: ");
                        loginPass = scanner.nextLine();
                    }

                    System.out.print("\nĐang tải");

                    for (int i = 3; i > 0; i--) {
                        System.out.print(".");
                        Thread.sleep(1000);
                    }

                    System.out.println("\n\nĐăng nhập thành công!\n");
                    Thread.sleep(1000);

                    do {
                        inSystemUI();
                        while (!scanner.hasNextInt()) {
                            System.out.println("Bạn chỉ có thể nhập số để lựa chọn.");
                            System.out.print("Chọn: ");
                            scanner.nextLine();
                        }

                        select = scanner.nextInt();
                        scanner.nextLine();

                        switch (select) {
                            case 1, 2, 3 -> {
                                System.out.print("\nĐang tải hình ảnh và thông tin ghế");

                                for (int i = 3; i > 0; i--) {
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                }

                                inCinemaMap();
                                System.out.print("\n\nNhập mã ghế để chọn vị trí ngồi(A1, A2): ");
                                characterChair = scanner.nextLine().toUpperCase();
                                while (characterChair.length() > 3 || !characterChair.matches("^[A-Ka-k]\\d+$")) {

                                    if (characterChair.length() > 3) {
                                        System.out.println("Mã ghê không tồn tại!");
                                    }

                                    if (!characterChair.matches("^[A-Ka-k]\\d+$")) {
                                        System.out.println("Mã ghê không tồn tại!");
                                    }

                                    System.out.print("\nNhập mã ghế để chọn vị trí ngồi(A1, A2): ");
                                    characterChair = scanner.nextLine().toUpperCase();
                                }

                            }
                            case 4 -> {}
                            case 5 -> {}
                        }
                    } while (select != 4);

                }
                case 3 -> {
                    System.out.println("\nCảm ơn quý khách đã sử dụng dịch vụ!");
                }
            }
        } while (select != 3);

        scanner.close();
    }

    public static void inMenu() {
        System.out.println("\n=== Đặt vé xem Beta Cinema ===");
        System.out.println("1. Đăng ký tài khoản");
        System.out.println("2. Đăng nhập");
        System.out.println("3. Thoát");
    }

    public static void inSystemUI() {
        System.out.println("\n========== Lịch chiếu phim ==========");
        System.out.println("[1] Nghỉ hè sợ nghỉ hưu");
        System.out.println("[2] Hộ Linh Tráng Sĩ");
        System.out.println("[3] Harry Potter và Hòn Đá Phù Thủy");
        System.out.println("[4] Thoát");
        System.out.print("Chọn: ");
    }

    public static void inCinemaMap() {

        System.out.println("\n\n                ───────────────────────────");
            System.out.println("                         MÀN HÌNH");

        for (char i = 'A'; i < 'D'; i++) {
            System.out.println();
            for (int j = 1; j < 13; j++) {
                System.out.print("[" + i + j + "] ");
            }
        }
        
        for (char i = 'D'; i < 'K'; i++) {
            System.out.println();
            for (int j = 1; j < 15; j++) {
                System.out.print("[" + i + j + "] ");
            }
        }

        System.out.print("\n          ");

        for (int i = 1; i < 11; i++) {

            System.out.print("[K" + i + "] ");
        }
    }
}
