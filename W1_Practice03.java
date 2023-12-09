// 류재성

import java.util.Scanner;

public class W1_Practice03 {
    public static void main(String[] args){
        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요. (숫자):");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        System.out.print("입장시간을 입력해 주세요. (숫자입력):");
        int hour = sc.nextInt();

        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        String merit = sc.next();

        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        String welfareCard = sc.next();
        sc.close();

        int entryFare = 10000;
        if(age < 3){
            entryFare = 0;
        } else if (age < 13) {
            entryFare = 4000;
        } else if (hour >= 17) {
            entryFare = 4000;
        } else if (merit.equals("y") || welfareCard.equals("y")) {
            entryFare = 8000;
        }
        System.out.println("입장료: " + entryFare);
    }
}
