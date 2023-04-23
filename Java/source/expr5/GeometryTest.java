import java.util.Scanner;

public class GeometryTest {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    run:while (true) {
      System.out.print("Enter 1/2: ");
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          System.out.println("Enter a,b: ");
          double a = scanner.nextDouble();
          double b = scanner.nextDouble();
          Oval oval = new Oval(a, b);
          System.out.println(oval);
          break;
        case 2:
          System.out.println("Enter a,b,c: ");
          double a1 = scanner.nextDouble();
          double b1 = scanner.nextDouble();
          double c1 = scanner.nextDouble();
          Ellipsoid ellipsoid = new Ellipsoid(a1, b1, c1);
          System.out.println(ellipsoid);
          break;
        case 0:
          System.out.println("End of program.");
          break run;
        default:
          break;
      }
    }
    scanner.close();
  }
}
