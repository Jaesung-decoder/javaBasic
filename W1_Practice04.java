// 류재성

// Scanner의 입력 함수와 조건문 및 Random클래스를 통한 주민번호 생성 로직 작성
// 입력값은 2020년도 이후로 입력한다는 전제로 작성

import java.util.Scanner;
import java.util.Random;

public class W1_Practice04 {
    public static void main(String[] args){
//      birthYear, birthMonth, birthDate, sex 입력 받아 변수 저장
        Boolean flag = true;

        System.out.println("[주민등록번호 계산]");
        Scanner sc = new Scanner(System.in);
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        int birthYear = sc.nextInt();

//      입력값이 2020보다 작을 때 다시 입력하게 프롬팅
        boolean wrongYear = false;
        if(birthYear < 2020){
            wrongYear = true;
        }
        while (wrongYear){
            sc.nextLine();
            System.out.print("2020년 이후 출생자만 가능합니다. 다시 입력해주세요.(yyyy):");
            birthYear =sc.nextInt();
            if(birthYear >= 2020){
                wrongYear = false;
                break;
            }
        }

        System.out.print("출생월을 입력해 주세요.(mm):");
        int birthMonth = sc.nextInt();
        System.out.print("출생일을 입력해 주세요.(dd):");
        int birthDate = sc.nextInt();

//      성별 'm' 이면 3, 'f'이면 4
        System.out.print("성별을 입력해 주세요.(m/f):");
        sc.nextLine();
        char charSex = sc.next().charAt(0);
        int sex = 0;
        switch(charSex){
            case 'm': sex = 3;
            break;

            case 'f': sex = 4;
            break;
        }

        sc.close();
//      임의번호 값 구하기
        Random random = new Random();

        System.out.printf(Integer.toString(birthYear).substring(2) + String.format("%02d",birthMonth) + String.format("%02d", birthDate) + "-" + Integer.toString(sex
        ) + String.format("%06d",(int)random.nextInt(999999)));

    }
}
