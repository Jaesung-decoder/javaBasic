import java.util.*;

public class QueuePractice {
//    0. 현재 Queue의 Front에 있는 원소의 원래 자리를 구하는 기능
    public static int findKey1index(HashMap<Integer, Integer> current){
        int foundkey = 0;
        for(int key: current.keySet()){
            if(current.get(key) == 1){
                foundkey = key;
            }
        }
        return foundkey;
    }

//  1. 큐의 첫번째 원소를 뽑아낸다 - 큐 자체적으로 변경하는 기능과 큐의 인덱스를 변경하는 기능 구현
    public static Queue<Integer> queuePoll(Queue<Integer> before){
        before.poll();
        return before;
    }
    public static HashMap<Integer, Integer> idxPoll(HashMap<Integer, Integer> before) {
        HashMap<Integer, Integer> after = (HashMap<Integer,Integer>)before.clone();
//      현재 위치가 1인 원소를 삭제한다. value를 삭제하므로 values().remove(value) 사용
        after.values().remove(1);
//      현재 위치가 2인 원소부터 마지막까지 인덱스 값을 1씩 감소시킨다.
        for(int key: after.keySet()){
            after.put(key, after.get(key)-1);
        }
        return after;
    }

//  2. Queue 안의 원소들을 왼쪽으로 한 칸씩 이동시킨다. a1, .. ak -> a2, .. ak, a1이 된다.
public static Queue<Integer> queueLeft(Queue<Integer> before){
        if(!before.isEmpty()){
            int first = before.peek();
            before.poll();
            before.add(first);
        }
    return before;
}
    public static HashMap<Integer, Integer> idxLeft(HashMap<Integer, Integer> before) {
        HashMap<Integer, Integer> after = (HashMap<Integer,Integer>)before.clone();

//      현재 위치가 1이면 현재 위치를 가장 마지막으로 변경하고 그렇지 않다면 현재 인덱스를 하나씩 감소시킨다.
        for(int key: after.keySet()){
            if(after.get(key) == 1){
                after.put(key, after.size());
            }else{
                after.put(key,after.get(key) - 1);
            }
        }
        return after;
    }

    //  3. Queue 안의 원소들을 오른쪽으로 한 칸씩 이동시킨다. a1, .. ak -> ak, .. a1, ak-1이 된다.
    public static Queue<Integer> queueRight(Queue<Integer> before){
        Queue<Integer> tmp = new LinkedList<Integer>();
        int itr1 = before.size();
        for (int i = 0; i < itr1; i++) {
            if(before.size() == 1){
                break;
            }else{
                tmp.add(before.poll());
            }
        }
        int itr2 = tmp.size();
        for (int i = 0; i < itr2; i++) {
            before.add(tmp.peek());
            tmp.remove();
        }
        return before;
    }
    public static HashMap<Integer, Integer> idxRight(HashMap<Integer, Integer> before) {
        HashMap<Integer, Integer> after = (HashMap<Integer,Integer>)before.clone();

//      현재 위치가 가장 마지막이면 현재 위치를 1로 변경하고 그렇지 않다면 현재 인덱스를 하나씩 추가시킨다.
        for(int key: after.keySet()){

            if(after.get(key) == after.size()){
                after.put(key, 1);
            }else{
                after.put(key,after.get(key) + 1);
            }
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
//      HashMap의 key 값은 변경이 어렵기 때문에 처음 인덱스로 보고 value를 현재 인덱스로 본다.
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
//      Left, Right 움직인 횟수를 저장하는 변수 생성
        int cntLeft = 0;
        int cntRight = 0;


//      뽑을 위치를 저장한 idxTarget 배열을 순환 기준으로 삼는다.
        for (int i = 0; i < idxTarget.size(); i++) {
//          뽑아내려는 위치가 큐의 가장 앞에 있는 값이 맞는지 확인한다. value를 보고 Key를 찾는 기능 구현
//          맞으면 Poll 실행, 맞지 않으면 맞을 때까지 나머지 기능을 실행한다.
            int foundkey1 = findKey1index(idx);
            System.out.println("foundkey1 = " + foundkey1);
            if(idxTarget.get(i) == foundkey1){
                idx = idxPoll(idx);
                queue = queuePoll(queue);
                System.out.println("queue = " + queue);
                System.out.println("idx = " + idx);
            } else if (idx.get(idxTarget.get(i)) <= (int)Math.round((double)queue.size()/2)) {
                System.out.println("idxTarget.get(i) = " + idxTarget.get(i));
                queue = queueLeft(queue);
                idx = idxLeft(idx);
                cntLeft++;
                System.out.println("queue = " + queue);
                System.out.println("idx = " + idx);
                } else {
                System.out.println("idxTarget.get(i) = " + idxTarget.get(i));
                    queue = queueRight(queue);
                    idx = idxRight(idx);
                    cntRight++;
                    System.out.println("queue = " + queue);
                    System.out.println("idx = " + idx);

                }
            }
        System.out.printf("2번 연산은 %d번 수행했습니다.\n", cntLeft);
        System.out.printf("3번 연산은 %d번 수행했습니다.", cntRight);
        }


}
