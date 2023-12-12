import java.util.*;

public class QueuePractice {
//  큐의 첫번째 원소를 뽑아낸다.
    public static HashMap<Integer, Integer> idxPoll(HashMap<Integer, Integer> before) {
        HashMap<Integer, Integer> after = (HashMap<Integer,Integer>)before.clone();
//      현재 위치가 1인 원소를 삭제한다.- 현재 위치가 key이다.
        after.remove(1);
//      현재 위치가 2인 원소부터 마지막까지 인덱스 값을 1씩 감소시킨다.
        for (int i = 2; i <= before.size(); i++) {
            after.put(i-1, after.get(i)); // 오류 발생
        }
        return after;
    }
    public static void main(String[] args) {


//      입력된 N 값에 대한 큐를 만든다. 1부터 1씩 증가하는 정수를 값으로 저장한다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= n ; i++) {
            queue.add(i);
        }
//      큐 안의 값들에 대한 처음 인덱스와 현재 인덱스를 저장하는 HashMap 생성, 첫 번째 값의 인덱스는 1이다.
        HashMap<Integer, Integer> idx = new HashMap<Integer, Integer>();
        for (int i = 1; i <= n ; i++) {
            idx.put(i, i);
        }
//      그 다음 입력된 정수를 뽑아낼 원소의 수로 저장하고 뽑을 위치에 해당하는 정수를 List로 저장한다.
        int numTarget = sc.nextInt();
        sc.nextLine();
//      생각지도 않은 데서 시간 날림 - 공백으로 구분된 정수 입력 값을 정수 배열에 저장하기 - 더 간단한 방법?
        String t = sc.nextLine();
        String[] tmp = t.split(" ");
        List<Integer> idxTarget = new ArrayList<Integer>();
        for (String i: tmp) {
            idxTarget.add(Integer.parseInt(i));
        }
//      뽑을 위치를 저장한 idxTarget 배열을 순환 기준으로 삼는다.
        for (int i = 0; i < idxTarget.size(); i++) {
//          뽑아내려는 위치가 큐의 Front, End 중 어디에 더 가까운지 판단한다 - 큐의 크기 절반보다 큰지 작은지.
            if(idxTarget.get(i)< queue.size()/2){
                idxPoll(idx);
                System.out.println(idx);
            }
        }


    }
}
