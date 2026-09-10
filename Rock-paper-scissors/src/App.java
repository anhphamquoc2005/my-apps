import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Rock-paper-scissors ===");
            System.out.println("Nhap keo/bua/bao: ");

            int random = r.nextInt(3);
            // System.out.println("Result = " + random); test random số

            String computer = null;

            if (random == 0)
                computer = "keo";
            if (random == 1)
                computer = "bua";
            if (random == 2)
                computer = "bao";

            String userInput = sc.nextLine();

            if (userInput.equalsIgnoreCase("thoat")) {
                System.out.println("Tam biet!");
                break;
            }

            if (!userInput.equals("keo") && !userInput.equals("bua") && !userInput.equals("bao")) {
                System.out.println("Vui long nhap keo/bua/bao de tiep tuc!");
                continue;
            }

            System.out.println("Ban ra: " + userInput);
            System.out.println("May ra: " + computer);

            if (userInput.equals(computer))
                System.out.println("Hoa");

            if (userInput.equals("keo")) {
                if (computer == "bua")
                    System.out.println("Thua");
                if (computer == "bao")
                    System.out.println("Thang");
            }

            else if (userInput.equals("bua")) {
                if (computer == "bao")
                    System.out.println("Thua");
                if (computer == "keo")
                    System.out.println("Thang");
            }

            else if (userInput.equals("bao")) {
                if (computer == "keo")
                    System.out.println("Thua");
                if (computer == "bua")
                    System.out.println("Thang");
            }
        }
        sc.close();
    }
}
