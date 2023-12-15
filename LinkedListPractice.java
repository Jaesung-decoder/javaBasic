import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
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

        int order = 0;
        System.out.print("<");

        Iterator<Integer> iterator = list.iterator();
        while (list.size() > 1) {
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                order++;

                if (order % k == 0) {
                    System.out.print(element);

                    iterator.remove();

                    if (list.size() > 1) {
                        System.out.print(", ");
                    }
                }
            }

            iterator = list.iterator();
        }
        if(!list.isEmpty()){
            System.out.print(", " + list.get(0));
        }
        System.out.print(">");
    }
}
