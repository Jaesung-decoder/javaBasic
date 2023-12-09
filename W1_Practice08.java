import java.util.Scanner;
public class W1_Practice08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        int annualRev = sc.nextInt();

//      연소득에 적용될 수 있는 최고 세율 구간을 구분하는 조건문
//      세율 구간을 구분하는 연소득 값도 배열로 저장
        int[] guide = {6, 15, 24, 35, 38, 40, 42, 45};
        int[] threshold = {0, 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
        int revenueGrade = 0;
        if (annualRev > threshold[7]) {
            revenueGrade = 7;
        } else {
            for (int j = 0; j < 7; j++) {
                if (annualRev > threshold[j] && annualRev <= threshold[j + 1]) {
                    revenueGrade = j;
                }
            }
        }

//      차등 세율 구간 적용하여 세금 계산 출력
//      차등세율 누적 계산 적용할 변수 생성 및 누적
        int untaxed = annualRev;
        int accumulated = 0;
        if (revenueGrade == 0) {
            System.out.println(untaxed + " *  " + guide[0] + "% =\t\t" + (int)(untaxed * 0.01 * guide[0]));
            accumulated += (int)(untaxed * 0.01 * guide[0]);
        } else {
            for (int i = 0; i < revenueGrade + 1; i++) {
                if (untaxed >= threshold[i + 1] - threshold[i]) {
                    System.out.printf("%11d * %2d", threshold[i + 1] - threshold[i], guide[i]);
                    System.out.print("% = ");
                    System.out.printf("%11d",(int)((threshold[i+1]-threshold[i]) * 0.01 * guide[i]));
                    untaxed -= threshold[i + 1] - threshold[i];
                    accumulated += (int)((threshold[i+1]-threshold[i]) * 0.01 * guide[i]);
                } else {
                    System.out.printf("%11d * %2d", untaxed, guide[i]);
                    System.out.print("% = ");
                    System.out.printf("%11d",(int)(untaxed * 0.01 * guide[i]));
                    accumulated += (int)(untaxed * 0.01 * guide[i]);

                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.print("[세율에 의한 세금]:\t\t");
        System.out.printf("%11d\n", accumulated);
//      누직공제 계산
        int[] deduX = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};
        int deduxTotal = (int)(annualRev * (guide[revenueGrade] * 0.01)) - (int)deduX[revenueGrade];
        System.out.print("[누직공세 계산에 의한 세금]:");
        System.out.printf("%11d\n", deduxTotal);
    }
}
