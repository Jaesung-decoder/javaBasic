import java.util.*;

public class SubString {
    public static int solution(String str1, String str2){
        int str2Length = str2.length();
        int result = 2;

        for (int i = 0; i < str1.length()-str2Length+1; i++) {
            String compare = str1.substring(i, i+str2Length);
            if(compare.equals(str2)){
                result = 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str1E1 = "ab6CDE443fgh22iJKlmn1o";
        String str2E1 = "6CD";
        String str1E2 = "ppprrrogrammers";
        String str2E2 = "pppp";
        String str1E3 = "AbcAbcA";
        String str2E3 = "AAA";
        System.out.println(solution(str1E1, str2E1));
        System.out.println(solution(str1E2, str2E2));
        System.out.println(solution(str1E3, str2E3));
    }
    
}
