// 류재성

public class W1_Practice01 {
  public static void main(String[] args){
          System.out.println("[구구단 출력]");
          for(int i=1; i<10; i++){
              for(int j=1; j<10; j++){
                  int k = i*j;
                  System.out.print(String.format("%02d", j) + " x " + String.format("%02d", i) + " = " +String.format("%02d", k));
                  System.out.print("    ");
              }
              System.out.println();
          }
      }
}
