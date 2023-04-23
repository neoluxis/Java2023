package src.expriii;
import java.util.Scanner;

/**
 * Three
 */
public class Three {

  public static void main(String[] args) {
    int[][] matrix;
    int size;
    Scanner sc = new Scanner(System.in);
    System.out.print("请输入一个小于21的正整数：");
    size = sc.nextInt();

    if (size > 21) {
      System.out.println("输入的数字大于20，请重新输入！");
      sc.close();
      return;
    }
    sc.close();
    
    matrix = new int[size][size];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = 0;
      }
    }

    int row = 0;
    int col = size - 1;
    for (
      row = 0, col = size - 1;
      col >= 0 && row < matrix.length;
      col--, row++
    ) {
      matrix[row][col] = 5;
      try {
        matrix[row][col - 1] = 2;
      } catch (Exception e) {
        // TODO: handle exception
      }
      try {
        matrix[row + 1][col] = 2;
      } catch (Exception e) {
        // TODO: handle exception
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
