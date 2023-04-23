package src.expriii;
import java.util.Scanner;

public class Two {
  public static void main(String[] args) {
    boolean dir = true;
    int size;
    int out=0;
    System.out.print("输入小于21的数字：");
    Scanner sc = new Scanner(System.in);
    size = sc.nextInt();
    int matrix[][] = new int[size][size];
    for(int i=0; i<size; i++){
      if(dir){
        for(int j=0; j<size; j++){
          matrix[i][j] = out;
          out ++;
        }
      }else{
        for(int j = size; j>0; j--){
          matrix[i][j-1] = out;
          out ++;
        }
      }
      dir = !dir;
    }
    for(int i =0; i<size; i++){
      for(int j=0; j<size; j++){
        System.out.printf("%3d ", matrix[i][j]);
      }
      System.out.println();
    }
    sc.close();
  }
}
