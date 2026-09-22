import Account.Admin;
import Account.User;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Movie[] movies = new Movie[3];

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Admin admin = new Admin();
        User user = new User("", "", "", 0, "");
        String loginUser;
        String loginPass;
        String target;
        String[] chairs;
        String characterChair = "";
        double priceBill = 0;
        double sumBill = 0;
        boolean isStudent = false;
        boolean isSenior = false;
        int numOfUser = 0;
        int amountChair;
        int age = 0;
        int select = 0;

        movies[0] = new Movie("[1] Nghỉ hè sợ nghỉ hưu", 70000, 117);
        movies[1] = new Movie("[2] Hộ Linh Tráng Sĩ", 70000, 135);
        movies[2] = new Movie("[3] Harry Potter và Hòn Đá Phù Thủy", 70000);

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
                    user.username = scanner.nextLine();
                    while (user.username.length() < 6 || user.username.length() > 12 || user.username.contains(" ") || user.username.contains("_")) {

                        if (user.username.length() < 6 || user.username.length() > 12) {
                            System.out.println("Tên đăng nhập phải có từ 6 - 12 ký tự!");
                        }

                        if (user.username.contains(" ") || user.username.contains("_")) {
                            System.out.println("Tên đăng nhập không được chứa khoảng trống hay dấu gạch dưới!");
                        }

                        System.out.print("\nTạo tên đăng nhập: ");
                        user.username = scanner.nextLine();
                    }

                    System.out.print("\nHọ và tên: ");
                    user.fullName = scanner.nextLine().trim();
                    while (user.fullName.trim().length() < 10) {
                        System.out.println("Họ và tên không được ít hơn 10 ký tự!\n");

                        System.out.print("Họ và tên: ");
                        user.fullName = scanner.nextLine().trim();
                    }

                    while (true) {
                        System.out.print("\nTuổi: ");

                        if (scanner.hasNextInt()) {
                            user.age = scanner.nextInt();

                            if (user.age > 0) {
                                break;
                            } else {
                                System.out.println("Tuổi không đúng định dạng!");
                            }
                        } else {
                            System.out.println("Tuổi không đúng định dạng!");
                            scanner.nextLine();
                        }
                    }

                    scanner.nextLine();

                    System.out.print("\nSố điện thoại: ");
                    user.phoneNumber = scanner.nextLine();
                    while (!user.phoneNumber.matches("^0[987532]\\d{8}$")) {
                        System.out.println("Số điện thoại không đúng định dạng!\n");
                        System.out.print("Số điện thoại:");
                        user.phoneNumber = scanner.nextLine();
                    }

                    System.out.print("\nTạo mật khẩu: ");
                    user.password = scanner.nextLine();
                    while (user.password.length() < 8 || user.password.length() > 16 || user.password.contains(" ") || user.password.contains("_")) {

                        if (user.password.length() < 8 || user.password.length() > 16) {
                            System.out.println("Mật khẩu phải có từ 8 - 16 ký tự!");
                        }

                        if (user.password.contains(" ") || user.password.contains("_")) {
                            System.out.println("Mật khẩu không được chứa khoảng trống hay dấu gạch dưới!");
                        }

                        System.out.print("\nTạo mật khẩu: ");
                        user.password = scanner.nextLine();
                    }

                    System.out.print("\nĐang tải");

                    for (int i = 3; i > 0; i--) {
                        System.out.print(".");
                        Thread.sleep(400);
                    }

                    System.out.println("\n\nTạo tài khoản thành công!\n");

                    numOfUser++;

                    Thread.sleep(400);
                }

                case 2 -> {
                    System.out.print("\nTên đăng nhập: ");
                    loginUser = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    loginPass = scanner.nextLine();
                    while (!loginUser.equalsIgnoreCase(user.username) || loginUser.isEmpty() && !loginPass.equalsIgnoreCase(user.password) || loginPass.isEmpty()) {
                        System.out.println("Tên đăng nhập hoặc mật khẩu không khớp\n");
                        System.out.print("Tên đăng nhập: ");
                        loginUser = scanner.nextLine();
                        System.out.print("Nhập mật khẩu: ");
                        loginPass = scanner.nextLine();
                    }

                    System.out.print("\nĐang tải");

                    for (int i = 3; i > 0; i--) {
                        System.out.print(".");
                        Thread.sleep(400);
                    }

                    System.out.println("\n\nĐăng nhập thành công!\n");
                    Thread.sleep(400);

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

                                while (true) {
                                    System.out.print("\n\nNhập số lượng ghế bạn muốn chọn (lưu ý: để chọn ghế couple bạn cần số lượng 2 ghế): ");

                                    if (scanner.hasNextInt()) {
                                        amountChair = scanner.nextInt();
                                        if (amountChair > 0) {
                                            break;
                                        } else {
                                            System.out.println("Không đúng định dạng!");
                                        }
                                    } else {
                                        System.out.println("Không đúng định dạng!");
                                        scanner.nextLine();
                                    }
                                }

                                chairs = new String[amountChair];

                                scanner.nextLine();

                                for (int i = 0; i < chairs.length; i++) {
                                    System.out.print("\n\nNhập mã ghế để chọn vị trí ngồi (A1, A2, đối với ghế đôi chỉ cần nhập ghế số lẻ ví dụ K1): ");
                                    characterChair = scanner.nextLine().toUpperCase();
                                    while (true) {

                                        char letter = Character.toUpperCase(characterChair.charAt(0));
                                        int number = Integer.parseInt(characterChair.substring(1));
                                        boolean isValid = false;

                                        if (characterChair.length() > 3 || !characterChair.matches("^[A-Ka-k]\\d+$")) {
                                            System.out.println("Mã ghê không tồn tại!");
                                            System.out.print("\nNhập mã ghế để chọn vị trí ngồi(A1, A2): ");
                                            characterChair = scanner.nextLine().toUpperCase();
                                            continue;
                                        }

                                        if ((letter >= 'A' && letter <= 'C')) {
                                            if (number >= 1 && number <= 12) {
                                                chairs[i] = characterChair;
                                                priceBill = 70000;
                                                sumBill = priceBill * amountChair;
                                                isValid = true;
                                            }
                                        } else if (letter >= 'D' && letter <= 'J') {
                                            if (number >= 1 && number <= 14) {
                                                chairs[i] = characterChair;
                                                priceBill = 80000;
                                                sumBill = priceBill * amountChair;
                                                isValid = true;
                                            }
                                        } else if (letter == 'K') {
                                            if (number >= 1 && number <= 9 && number % 2 != 0) {
                                                if (i < chairs.length -1) {
                                                    chairs[i] = "K" + number;
                                                    chairs[i + 1] = "K" + (number + 1);
                                                    priceBill = 75000;
                                                    sumBill += (priceBill * 2);
                                                    i++;
                                                    isValid = true;
                                                } else {
                                                    System.out.println("Số lượng ghế bạn chọn không phù hợp để chọn hàng ghế K!");
                                                }
                                            } else {
                                                System.out.println("Bạn chỉ cần nhập 1 ghế số lẻ. Hệ thống sẽ tự động xác nhận ghế đôi cho bạn!");
                                            }
                                        }

                                        if (!isValid) {
                                            System.out.println("\nMã ghế không tồn tại!");
                                            System.out.print("\nNhập mã ghế để chọn vị trí ngồi(A1, A2): ");
                                            characterChair = scanner.nextLine().toUpperCase();
                                        } else {
                                            System.out.println("\nChọn ghế thành công!\n");
                                            break;
                                        }
                                    }
                                }

                                System.out.print("Đang in hóa đơn");
                                for (int i = 3; i > 0; i--) {
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                }

                                sumBill = priceBill * amountChair;

                                if (user.age < 18) {
                                    isStudent = true;
                                    System.out.println("\n\nBạn là sinh viên! Bạn sẽ được giảm 10% vào tổng hóa đơn!");
                                    Thread.sleep(1000);
                                } else if (user.age >= 60) {
                                    isSenior = true;
                                    System.out.println("\n\nBạn là người cao tuổi! Bạn sẽ được giảm 20% vào tổng hóa đơn!");
                                    Thread.sleep(1000);
                                }

                                if (isStudent) {
                                    if (isSenior) {
                                        sumBill *= 0.7;
                                    }
                                    else {
                                        sumBill *= 0.9;
                                    }
                                } else {
                                    if (isSenior) {
                                        sumBill *= 0.8;
                                    }
                                    else {
                                        sumBill *= 1;
                                    }
                                }

                                int idBill = random.nextInt(1000, 4999);
                                System.out.printf("""
                                      \n\n============ %d ===========
                                        Tên: %s
                                        SĐT: %s
                                        Rạp: 7
                                        Ghế: %s
                                        Tổng hóa đơn: %,.0f VNĐ
                                      =======================
                                        \n""", idBill, user.fullName, user.phoneNumber, Arrays.toString(chairs), sumBill);
                            }

                            case 4 -> {
                                boolean isFound = false;

                                while (!isFound) {
                                    System.out.print("\nNhập tên phim cần tìm kiếm (nhập 'thoát' nêu muốn trở lại): ");
                                    target = scanner.nextLine().trim();

                                    if (target.equalsIgnoreCase("Thoát")) {
                                        isFound = true;
                                    }

                                    if (target.isEmpty()) {
                                        System.out.println("Không tìm thấy!");
                                        continue;
                                    }

                                    for (Movie m : movies) {
                                         if(m != null && m.getTitle().toLowerCase().contains(target.toLowerCase())) {
                                            m.printInfo();
                                        }
                                    }
                                }
                            }

                            case 5 -> user.printInfo();

                            case 6 -> System.out.println("Cảm ơn quý khách!");
                        }
                    } while (select != 6);

                }

                case 3 -> {
                    System.out.print("\nTên đăng nhập (Admin): ");
                    admin.adminUser = scanner.nextLine();
                    System.out.print("Mật khẩu (Admin): ");
                    admin.adminPassword = scanner.nextLine();

                    while (!admin.adminUser.contains("admin") || !admin.adminPassword.contains("admin")) {
                        System.out.println("\nTên đăng nhập hoặc mật khẩu không đúng!\n");

                        System.out.print("Tên đăng nhập (Admin): ");
                        admin.adminUser = scanner.nextLine();
                        System.out.print("Mật khẩu (Admin): ");
                        admin.adminPassword = scanner.nextLine();
                    }

                    System.out.printf("\nHiện đang có %d người đăng ký vào hệ thống.\n", numOfUser);
                }

                case 4 -> {
                    System.out.println("\nCảm ơn quý khách đã sử dụng dịch vụ!");
                }
            }
        } while (select != 4);

        scanner.close();
    }

    public static void inMenu() {
        System.out.println("\n=== Đặt vé xem Beta Cinema ===");
        System.out.println("1. Đăng ký tài khoản");
        System.out.println("2. Đăng nhập");
        System.out.println("3. Đăng nhập với quyền Admin");
        System.out.println("4. Thoát");
    }

    public static void inSystemUI() {
        System.out.println("\n========== Lịch chiếu phim ==========");
        for (Movie m : movies) {
            m.printInfo();
        }
        System.out.println("[4] Tìm kiếm");
        System.out.println("[5] Xem thông tin tài khoản");
        System.out.println("[6] Thoát");
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
