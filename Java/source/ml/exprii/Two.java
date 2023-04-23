package src.exprii;
import java.util.Scanner;

public class Two {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int integer = sc.nextInt(); // 1234567
    int length = String.valueOf(integer).length(); // 7
    while (integer != 0) {
      System.out.println(integer);
      // 1234567 -> 234567 -> 34567 -> 4567 -> 567 -> 67 -> 7
      integer = integer % (int) Math.pow(10, length - 1);

      length--;
    }
    sc.close();
  }
}
