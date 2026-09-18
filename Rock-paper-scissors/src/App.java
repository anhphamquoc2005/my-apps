import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choice = {"kéo", "búa", "bao"};
        String playerUser;
        String playerComputer;
        boolean isRunning = true;

        System.out.println("===========");
        System.out.println(" Oản tù tì");
        System.out.println("===========");

        while (isRunning) {

            System.out.print("\nBạn nhập (kéo, búa, bao): ");
            playerUser = scanner.nextLine();

            playerComputer = choice[random.nextInt(3)];

            if (!playerUser.equalsIgnoreCase(choice[0]) && !playerUser.equalsIgnoreCase(choice[1]) && !playerUser.equalsIgnoreCase(choice[2]) && !playerUser.equalsIgnoreCase("thoát")) {
                System.out.println("\nLựa chọn không hợp lệ!\n");
            } else if (playerUser.equalsIgnoreCase("thoát")) {
                System.out.println("\nĐã thoát trò chơi!");
                isRunning = false;
            } else {
                System.out.printf("\nBạn ra %s \n", playerUser);
                System.out.printf("\nMáy tính ra %s\n\n", playerComputer);
            }

            if (playerComputer.equalsIgnoreCase(choice[0])) {
                if (playerUser.equalsIgnoreCase(choice[1])) {
                    System.out.println("Thắng!");
                } else if (playerUser.equalsIgnoreCase(choice[2])) {
                    System.out.println("Thua");
                } else if (playerUser.equalsIgnoreCase(choice[0])) {
                    System.out.println("Hòa");
                }
            } else if (playerComputer.equalsIgnoreCase(choice[2])) {
                if (playerUser.equalsIgnoreCase(choice[1])) {
                    System.out.println("Thua!");
                } else if (playerUser.equalsIgnoreCase(choice[0])) {
                    System.out.println("Thắng");
                } else if (playerUser.equalsIgnoreCase(choice[2])) {
                    System.out.println("Hòa");
                }
            } else if (playerComputer.equalsIgnoreCase(choice[1])) {
                if (playerUser.equalsIgnoreCase(choice[0])) {
                    System.out.println("Thua!");
                } else if (playerUser.equalsIgnoreCase(choice[2])) {
                    System.out.println("Thắng");
                } else if (playerUser.equalsIgnoreCase(choice[1])) {
                    System.out.println("Hòa");
                }
            }
        }

        scanner.close();
    }
}
