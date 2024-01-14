import java.util.HashSet;
import java.util.Scanner;

public class W6_Mission02 {
    public static void main(String[] args) {
//      나의 좌표 입력 받기: 쉼표로 구분한 정수 입력
        System.out.print("나의 좌표 값을 입력하시오.\n(x좌표와 y좌표는 공백 없이 쉼표로 구분): ");
        Scanner sc = new Scanner(System.in);
        String myinput = sc.next();
//      입력 받은 좌표가 중복되지 않는지 확인하기 위한 HashSet 생성 및 입력 후 확인
        HashSet<String> all = new HashSet<>();
        all.add(myinput);
        
        int myX = Integer.parseInt(myinput.split(",")[0].trim());
        int myY = Integer.parseInt(myinput.split(",")[0].trim());
        System.out.println();

//      가장 거리가 가까운 좌표를 기억해둘 정수 배열 생성, 최소 거리를 저장할 정수 변수 생성
        int minDistance = Integer.MAX_VALUE;
        int[] closest = new int[2];

//      새로운 임의 좌표를 입력 받는 프롬프트 화면 10번 반복

        for (int i = 0; i < 10; i++) {
            boolean dupFlag = false;
//          all HashSet에 저장된 값이면 다시 입력 받는 do-while문.
            do {
                System.out.print("임의의 좌표 값을 입력하시오. \n" + (10-i) + "회 남았습니다. (x좌표와 y좌표는 공백 없이 쉼표로 구분): ");
                String input = sc.next();
                System.out.println();
                if(!all.add(input)){
                    dupFlag = true;
                }else{
                    int tmpX = Integer.parseInt(input.split(",")[0].trim());
                    int tmpY = Integer.parseInt(input.split(",")[1].trim());
//              입력 받은 값에 대해 바로 거리 계산해서 가장 작은 좌표는 기억해 두기
                    int distance = ((tmpX - myX) * (tmpX - myX)) + ((tmpY - myY) * (tmpY - myY));
                    if (distance < minDistance) {
                        minDistance = distance;
                        closest[0] = tmpX;
                        closest[1] = tmpY;

                    }
                    dupFlag = false;
                }
            } while(dupFlag);

//            System.out.println(all); //test code
            System.out.println();
            }
        sc.close();
        System.out.println("가장 가까운 좌표는 (" + closest[0] + ", " + closest[1] + ") 입니다.");
    }
}
