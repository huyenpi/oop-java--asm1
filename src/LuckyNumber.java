import java.util.Scanner;
public class LuckyNumber {
    public static void main(String[] args) {
        final int MAXIMUM = 100;
        System.out.println("Tôi đang nghĩ một số trong khoảng từ 0 đến " + MAXIMUM + "...");
        int[] result = play(MAXIMUM);
        report(result[0], result[1], result[2]);
    }

    public static int[] play(int max) {
        Scanner scan = new Scanner(System.in);
        int myNum;
        String youranswer;
        int counter;
        int totalGame = 0;
        int totalGuess = 0;
        int bestGame =0;
        do {
            totalGame++;
            counter = 0;
            myNum = (int) Math.floor(Math.random() * max + 1);
            System.out.println("My num: " + myNum);
            while (true) {
                System.out.print("Bạn đoán? ");
                int yourNum = scan.nextInt();
                counter++;
                if (yourNum > myNum) {
                    System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn");
                } else if (yourNum < myNum) {
                    System.out.println("Số may mắn lớn hơn số dự đoán của bạn");
                } else {
                    System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " + counter + " lần dự đoán");
                    totalGuess += counter;
                    if (counter < bestGame || bestGame == 0) {
                        bestGame = counter;
                    }
                    System.out.println("bestGame: " + bestGame);
                    break;
                }
            }
            System.out.print("Bạn có muốn tiếp tục chơi không? ");
            youranswer = scan.next();
        } while (youranswer.equalsIgnoreCase("y") || youranswer.equalsIgnoreCase("yes"));
        return new int[]{totalGame, totalGuess, bestGame};

    }


    public static void report(int totalGame, int totalGuess, int bestGame) {
        double avg = (double) totalGuess / totalGame;
        System.out.println("avg : "+avg);
        double guessAvg = (double) Math.round(avg *10)/10;
        System.out.println("Kết quả tổng quát của trò chơi:");
        System.out.println("Tổng số lần chơi: " + totalGame);
        System.out.println("Tổng số lần dự đoán: " + totalGuess);
        System.out.println("Số lần dự đoán trung bình mỗi lượt: " + guessAvg);
        System.out.println("Số lần dự đoán ít nhất: " + bestGame);
    }
}










