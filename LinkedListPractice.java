import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedListPractice {
    public static void main(String[] args) throws IOException {
        int n, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
        } while (k > n || k < 1 || n > 5000);

        LinkedList<Integer> list = IntStream.range(1, n + 1).boxed().collect(Collectors.toCollection(LinkedList::new));

        int index = 0;
        StringBuilder result = new StringBuilder("<");

        while(list.size() > 1){
            index = (index + k - 1) % list.size();
            result.append(list.remove(index)).append(", ");
        }

        result.append(list.getFirst()).append(">");
        System.out.println(result);
    }
}
