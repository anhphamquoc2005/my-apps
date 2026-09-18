import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {

        int balance = 4000;
        int amount = 0;
        int bet;
        int payout;
        String[] row;
        String isContinue;
        String isStop;

        System.out.println("=========================");
        System.out.println("    MÁY ĐÁNH BẠC JAVA    ");
        System.out.println("Symbols: \uD83C\uDF52 \uD83C\uDF49 \uD83C\uDF4B \uD83D\uDD14 ⭐");
        System.out.println("=========================");

        System.out.printf("Bạn được tặng %,d VNĐ cho lần chơi đầu tiên!!!\n", balance);

        while (balance > 0) {

            System.out.printf("Số dư hiện tại %,d VNĐ \n", balance);

            if (balance < 5000) {
                System.out.print("Số dư của bạn đã hết. Bạn có muốn nạp thêm?(Y/N): ");
                isContinue = scanner.nextLine();

                if (isContinue.equalsIgnoreCase("Y")) {
                    balance = deposit(balance, amount);
                    System.out.printf("Số dư hiện tại %,d VNĐ \n", balance);
                } else if (isContinue.equalsIgnoreCase("N")) {
                    break;
                } else if (!isContinue.equalsIgnoreCase("Y") && !isContinue.equalsIgnoreCase("N")) {
                    System.out.println("\nYêu cầu không hợp lệ!\n");
                }
            }

            System.out.print("\nBạn muốn đặt cược bao nhiêu? (cược tối thiểu 5,000 VNĐ): ");

            while (!scanner.hasNextInt()) {
                System.out.println("\nSố tiền cược tối thiểu là 5,000 VNĐ!\n");
                System.out.print("Bạn muốn đặt cược bao nhiêu? (cược tối thiểu 5,000 VNĐ): ");
                scanner.nextLine();
            }

            bet = scanner.nextInt();

            scanner.nextLine();

            if (bet > balance) {
                System.out.println("\nSố dư của bạn hiện tại không đủ để cược!\n");
                continue;
            } else if (bet < 5000) {
                System.out.println("\nSố tiền cược tối thiểu là 5,000 VNĐ!\n");
                continue;
            } else {
                balance -= bet;
            }

            System.out.print("\nSpinning");
            for (int i = 3; i > 0; i--) {
                Thread.sleep(400);
                System.out.print(".");
            }
            System.out.println();

            row = spinRow();
            printRow(row);
            payout = getPayOut(row, bet);

            if (payout > 0) {
                System.out.printf("Bạn thắng %,d VNĐ \n", payout);
                balance += payout;
            } else {
                System.out.printf("Bạn đã thua! Bạn bị trừ %,d VNĐ\n\n", bet);
            }

            System.out.print("Bạn có muôn tiếp tục?(Y/N): ");
            isStop = scanner.nextLine();

            if (isStop.equalsIgnoreCase("Y")) {
                System.out.println("\nTiếp tục!");
            } else if (isStop.equalsIgnoreCase("N")) {
                System.out.println("\nTạm biệt!\n");
                break;
            } else if (!isStop.equalsIgnoreCase("Y") && !isStop.equalsIgnoreCase("N")) {
                System.out.println("\nYêu cầu không hợp lệ!\n");
            }
        }

        scanner.close();
    }

    static int deposit(int balance, int amount) {
        System.out.print("Nhập số tiền bạn muốn nạp: ");

        while (true) {
            if (scanner.hasNextInt()) {
                amount = scanner.nextInt();
                scanner.nextLine();

                if (amount >= 10000) {
                    break;
                } else {
                    System.out.println("\nSố tiền bạn nạp phải tối thiểu 10,000 VNĐ!\n");
                }

                System.out.print("Nhập số tiền bạn muốn nạp: ");

            } else {
                System.out.println("\nYêu cầu nhập số tiền hợp lệ!\n");
            }
        }

        System.out.println("Nạp tiền thành công!");
        balance += amount;

        return balance;
    }
    static String[] spinRow() {

        String[] symbols = {"\uD83C\uDF52", "\uD83C\uDF49", "\uD83C\uDF4B", "\uD83D\uDD14", "⭐"};
        String[] row = new String[3];

        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(symbols.length)];
        }

        return row;
    }
    static void printRow(String[] row) {
        System.out.println("\n==============");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("==============\n");
    }
    static  int getPayOut(String[] row, int bet) {

        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch (row[0]) {
              case "\uD83C\uDF52" -> bet * 3;
              case "\uD83C\uDF49" -> bet * 4;
              case "\uD83C\uDF4B" -> bet * 5;
              case "\uD83C\uDF4C" -> bet * 10;
              case "⭐" -> bet * 20;
              default -> 0;
            };
        } else if (row[0].equals(row[1])) {
            return switch (row[0]) {
                case "\uD83C\uDF52" -> bet * 2;
                case "\uD83C\uDF49" -> bet * 3;
                case "\uD83C\uDF4B" -> bet * 4;
                case "\uD83C\uDF4C" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };
        } else if (row[1].equals(row[2])) {
            return switch (row[1]) {
                case "\uD83C\uDF52" -> bet * 2;
                case "\uD83C\uDF49" -> bet * 3;
                case "\uD83C\uDF4B" -> bet * 4;
                case "\uD83C\uDF4C" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };
        }

        return 0;
    }
}
