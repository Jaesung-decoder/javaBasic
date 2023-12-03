import java.util.Scanner;

public class W1_Practice02 {
  public static void main(String[] Args){
    System.out.println("[캐시백 계산]");
    System.out.print("결제 금액을 입력해 주세요. (금액):");
    Scanner in = new Scanner(System.in);
    int totalCharge = in.nextInt();

    int cashBack = 0;
    if ((totalCharge * 0.1) / 100 > 3){
        cashBack = 3*100;
      }else{
            cashBack =(int)((totalCharge * 0.1)/100)*100;
        }
        System.out.println("결제 금액은 " + totalCharge + "원이고, 캐시백은 " + cashBack + ("원 입니다."));

    }
}
