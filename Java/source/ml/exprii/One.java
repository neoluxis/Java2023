import java.util.Scanner;

public class One {

  public static void main(String[] args) {
    System.out.print("Enter 3 side lengths: ");
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    System.out.println("Area: " + getArea(a, b, c));
    sc.close();
  }

  public static int getArea(int a, int b, int c) {
    int s = (a + b + c) / 2;
    return (int) Math.sqrt(s * (s - a) * (s - b) * (s - c));
  }
}
