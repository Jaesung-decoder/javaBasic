import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Array {
    public static int[] solution(int[] numbers, String direction){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            queue.add(numbers[i]);
        }
        if(direction.equals("left")){
            queue.add(queue.poll());
        } else if (direction.equals("right")) {
            for (int i = 0; i < numbers.length-1; i++) {
                queue.add(queue.poll());
            }
        }
        int[] result = new int[numbers.length];
        int i = 0;
        while(!queue.isEmpty()){
            result[i] = queue.poll();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3};
        int[] numbers2 = {4, 455, 6, 4, -1, 45, 6};
        String direction1 = "right";
        String direction2 = "left";

        System.out.println("test1: " + Arrays.toString(solution(numbers1,direction1)));
        System.out.println("test2: " + Arrays.toString(solution(numbers2,direction2)));
    }
    
}
