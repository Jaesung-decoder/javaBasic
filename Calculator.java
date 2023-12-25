import java.util.*;

public class Calculator {
    public static int solution(Queue<String> queue){
        int result = 0;
        result += Integer.parseInt(queue.poll());
        while(!queue.isEmpty()){
            String tmp = queue.poll();
            if(tmp.equals("+")){
                result += Integer.parseInt(queue.poll());
            } else if (tmp.equals("-")) {
                result -= Integer.parseInt(queue.poll());
            }else if (tmp.equals("*")) {
                result *= Integer.parseInt(queue.poll());
            }else if (tmp.equals("/")) {
                result /= Integer.parseInt(queue.poll());
            } else if (tmp.equals("=")) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        boolean flag = true;
        while(flag){
            String input = sc.next();
            if(input.equals("=")){
                flag = false;
            } else{
                queue.add(input);
            }
            sc.nextLine();
        }
        System.out.println(solution(queue));
    }
    
}
