import java.util.*;

// 로또 번호 조합 생성하는 클래스, 메소드 생성
class DigitLottery {
    ArrayList<Integer> combination = new ArrayList<Integer>();
    DigitLottery(){};
    public ArrayList<Integer> generateCombination(){
        Random rd = new Random();
        combination.clear();
        for (int i = 0; i < 6; i++) {
            int ranNum = rd.nextInt(45)+1;
            if(combination.contains(ranNum)){
                ranNum = rd.nextInt(45)+1;
            }
            combination.add(ranNum);
        }
        combination.sort(Comparator.naturalOrder());
        return combination;
    }
}

public class W1_Practice07 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("로또 개수를 입력해 주세요. (숫자 1 ~ 10):");
        int numLottery = sc.nextInt();

//      내가 구매한 로또 번호 생성하기
        HashMap<Character, ArrayList> myTotalCombination = new HashMap<>(numLottery);
        for (int i = 0; i < numLottery; i++) {
            DigitLottery batch = new DigitLottery();
            myTotalCombination.put((char)(i+65), batch.generateCombination());
        }
//      내가 구매한 로또 번호(들) 모두 출력하기
        for (int i = 0; i < myTotalCombination.size(); i++) {
            System.out.print((char)(i+65) + "\t");
            ArrayList ar1 = myTotalCombination.get((char)(i+65));
            for (int j = 0; j < ar1.size(); j++) {
                System.out.print(ar1.get(j));

                if(j != myTotalCombination.get((char)(i+65)).size()-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
        System.out.println();

//      당첨번호 생성하기
        ArrayList<Integer> rightCombination = new ArrayList<Integer>();
        DigitLottery theChosen = new DigitLottery();
        rightCombination = theChosen.generateCombination();
        
        System.out.println("[로또 발표]");
        System.out.print("\t");
        for (int i = 0; i < rightCombination.size(); i++) {
            System.out.print(rightCombination.get(i));
            if(i != rightCombination.size()-1){
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println();


        System.out.println("[내 로또 결과]");
        for (int i = 0; i < myTotalCombination.size(); i++) {
            System.out.print((char)(i+65) + "\t");
            ArrayList ar2 = myTotalCombination.get((char)(i+65));
            int cnt = 0;
            for (int j = 0; j < ar2.size(); j++) {
                System.out.print(ar2.get(j));

                if(j != myTotalCombination.get((char)(i+65)).size()-1){
                    System.out.print(",");
                }
            }
            for (int k = 0; k < rightCombination.size(); k++) {
                if(ar2.contains(rightCombination.get(k))){
                    cnt++;
                }
            }
            System.out.print(" => " + cnt +"개 일치");
            System.out.println();
        }
    }
}
