import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;

public class HashTable {
    public static String solution(String s){
        char[] arrChar = s.toCharArray();
        Hashtable<Character, Integer> memoryTable = new Hashtable<>();
        for(char c: arrChar){
            if(memoryTable.containsKey(c)){
                memoryTable.put(c, memoryTable.get(c) + 1);
            }else{
                memoryTable.put(c, 1);
            }
        }
        ArrayList<Integer> onlyOne = new ArrayList<>();
        for (char alphabet: memoryTable.keySet()){
            if(memoryTable.get(alphabet) == 1){
                onlyOne.add((int)alphabet);
            }
        }
       onlyOne.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < onlyOne.size(); i++) {
            int x = onlyOne.get(i);
            sb.append((char)x);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String test1 = "abcabcadc";
        String test2 = "abdc";
        String test3 = "hello";

        System.out.println("test1: " + solution(test1));
        System.out.println("test2: " + solution(test2));
        System.out.println("test3: " + solution(test3));
    }
    
}
