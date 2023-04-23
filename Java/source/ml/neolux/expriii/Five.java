import java.util.Scanner;

public class Five {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("请输入一个正整数：");
    int num = sc.nextInt();
    String str = String.valueOf(num);
    if (One.isPalindrome(str)) {
      System.out.println("回文数 " + num + " Yes！");
    } else {
      System.out.println("回文数 " + num + " No!");
    }
    sc.close();
  }
}
