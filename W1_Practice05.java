
// 달력 출력 프로그램
// 수행 목적: Scanner의 입력함수와 조건문 및 반복문을 통한 달력 계산 로직 작성
// 입력 받은 년도와 월을 통한 달력 생성
// 입력값은 년도, 월을 입력
// 날짜는 LocalDate 클래스를 이용(Calendar와 Date클래스도 이용 가능)
// 출력은 입력한 달을 기준으로 이전달, 입력달, 현재달 출력(3달 출력)


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;
public class W1_Practice05 {
    public static void main(String[] args) {
        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        Scanner sc = new Scanner(System.in);
        int focusYear = sc.nextInt();
        sc.nextLine();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int focusMonth = sc.nextInt();


//      1월을 선택했을 때 년도와 달이 올바르게 선택되도록 조건문
        int preYear = focusYear;
        int preMonth = focusMonth - 1;
        if (focusMonth == 1) {
            preYear = focusYear - 1;
            preMonth = 12;
        }
//      현 시점에 대한 변수 만들고 지정
        LocalDate now = LocalDate.now();
        int curYear = now.getYear();
        int curMonth = now.getMonth().getValue();

//      배열 만들어서 저장
        int[] targetYear = {preYear, focusYear, curYear};
        int[] targetMonth = {preMonth, focusMonth, curMonth};
        int[] targetCurrentDay = {1, 1, 1};

//      머리말 출력 - 이전 달, 선택된 달, 현재 달 및 요일 출력
        System.out.print("[" + preYear + "년 " + preMonth + "월]");
        System.out.print("\t\t\t\t\t\t");
        System.out.print("[" + focusYear + "년 " + focusMonth + "월]");
        System.out.print("\t\t\t\t\t\t");
        System.out.println("[" + curYear + "년 " + curMonth + "월]");
        System.out.println("일\t월\t화\t수\t목\t금\t토\t\t일\t월\t화\t수\t목\t금\t토\t\t일\t월\t화\t수\t목\t금\t토");

        Calendar cal = Calendar.getInstance();


        for (int j = 1; j < 36; j += 7) {
            for (int k = 0; k < 3; k++) {
                cal.set(targetYear[k], targetMonth[k] - 1, 1);
                int StartDay = cal.get(Calendar.DAY_OF_WEEK);
                int LastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

                for (int i = j; i < j + 7; i++) {
                    if (i < StartDay || targetCurrentDay[k] > LastDay) {
                        System.out.print("\t");
                    } else {
                        System.out.printf("%02d\t", targetCurrentDay[k]);
                        targetCurrentDay[k]++;
                        }
                    }
                System.out.print("\t");
                }
            System.out.println();
        }

    }

}
