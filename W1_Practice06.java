// 류재성

import java.util.*;

public class W1_Practice06 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("총 진행할 투표수를 입력해 주세요.");
        int totalVote = sc.nextInt();
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
        int numCandidate = sc.nextInt();
//      후보자 이름을 저장할 배열 생성
        String[] nameCandidate = new String[numCandidate];
//      후보자 이름과 득표 수를 저장할 HashMap 생성
        HashMap<String,Integer> mapCandidate = new HashMap<String, Integer>();

        for (int i = 0; i < numCandidate; i++) {
            System.out.printf("%d번째 후보자이름을 입력해 주세요.",i+1);
            String name = sc.next();
            nameCandidate[i] = name;
            mapCandidate.put(name, 0);
        }
//      집계 결과를 출력할 간격을 설정하는 변수 gap, 집계된 투표 수를 저장하는 countedVote, 최종 당선자를 저장하는 finalNominee 변수 생성
        double gap = 1;
        int countedVote = 0;
        String finalNominee = null;

        Random random = new Random();

        for(double i = gap; i <= 100; i+=gap){
            int roundVote = (int)(totalVote * gap * 0.01);
            int unallocatedVote = roundVote;
            while(unallocatedVote != 0 && unallocatedVote >= 0){
                String candidateKey = nameCandidate[random.nextInt(numCandidate)];
                int currentRoundVote = random.nextInt(unallocatedVote+1);
                int updatedVote = mapCandidate.get(candidateKey) + currentRoundVote;
                mapCandidate.put(candidateKey, updatedVote);
                unallocatedVote -= currentRoundVote;
                countedVote += currentRoundVote;
            }
            Integer maxValue = Collections.max(mapCandidate.values());
            String maxCandidate = null;
            for(String key: mapCandidate.keySet()){
                if(mapCandidate.get(key).equals(maxValue)){
                    maxCandidate = key;
                }
            }
            System.out.println("[투표진행률]: " + String.format("%,.2f", i) + "%, " + countedVote + "명 투표 => " + maxCandidate);
            for (int j = 0; j < numCandidate; j++) {
                System.out.println("[기호: " + (j+1) + "]\t" + nameCandidate[j] + ":\t" + String.format("%,.2f", ((double)mapCandidate.get(nameCandidate[j])/totalVote)*100) + "%\t(투표수: " + mapCandidate.get(nameCandidate[j]) + ")");
            }
            finalNominee = maxCandidate;

        }
        System.out.println("[투표 결과]\t당선인\t:\t" + finalNominee);


    }

}
