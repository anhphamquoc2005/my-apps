import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int animalCount = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal[] cages = new Animal[5];
        int select = 0;

        do {

            inMenu();

            while (!scanner.hasNextInt()) {
                System.out.println("\nBạn chỉ có thể nhập số để lựa chọn!\n");
                System.out.print("Chọn: ");
                scanner.nextLine();
            }

            select = scanner.nextInt();
            scanner.nextLine();

            switch (select) {
                case 1 -> {

                    String name;
                    int age;

                    System.out.print("\nNhập tên động vật: ");
                    name = scanner.nextLine().toUpperCase().trim();
                    while (name.length() < 3) {
                        System.out.println("\nTên thú cưng phải có nhiều hơn 3 ký tự!\n");
                        System.out.print("Nhập tên động vật: ");
                        name = scanner.nextLine().toUpperCase().trim();
                    }

                    while (true) {
                        System.out.print("\nNhập tuổi: ");

                        if (scanner.hasNextInt()) {
                            age = scanner.nextInt();

                            if (age > 0) {
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

                    int type;

                    System.out.print("\nNhập phân loại(1. Chó, 2. Mèo): ");
                    while (true) {

                        if (scanner.hasNextInt()) {

                            type = scanner.nextInt();

                            if (type == 1) {
                                cages[animalCount] = new Dog(name, age);
                                animalCount++;
                                break;
                            } else if (type == 2) {
                                cages[animalCount] = new Cat(name, age);
                                animalCount++;
                                break;
                            }
                        }
                    }
                }

                case 2 -> {
                    System.out.println("\n--- DANH SÁCH ---");
                    for (int i = 0; i < cages.length; i++) {
                        if (cages[i] != null) {
                            System.out.println("Lồng [" + i + "] | " + cages[i]);
                        }
                    }
                }
                case 3 -> {
                    for (int i = 0; i < cages.length; i++) {
                        if (cages[i] != null) {
                            cages[i].makeSound();
                            ((Playable) cages[i]).play();
                        }
                    }
                }
                case 4 -> System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");

                default -> System.out.println("Vui lòng nhập lựa chọn phù hợp!");
            }

        } while (select != 4);

        scanner.close();
    }

    static void inMenu() {
        System.out.println("\n=== TRẠM CỨU HỘ ĐỘNG VẬT ===");
        System.out.println("[1]. Tiếp nhận động vật");
        System.out.println("[2]. Điểm danh");
        System.out.println("[3]. Giờ chơi đùa");
        System.out.println("[4]. Thoát");
        System.out.print("Chọn: ");
    }
}
