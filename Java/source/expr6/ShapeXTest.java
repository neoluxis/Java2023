/**
 * ShapeXTest
 */
public class ShapeXTest {

  public static void main(String[] args) {
    System.out.println("(1)");
    Rectangle rectangle = new Rectangle(5, 3);
    Triangle triangle = new Triangle(3, 3, 3);
    System.out.println(rectangle);
    System.out.println(triangle);

    System.out.println("(2)");
    Rectangle rect = rectangle.clone();
    System.out.println(rectangle);
    System.out.println(rect);
    System.out.println("modifying rectangle");
    rectangle.length = 10;
    rectangle.width = 8;
    System.out.println(rectangle);
    System.out.println(rect);
  }
}
