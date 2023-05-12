package expr7;

import java.util.Scanner;

public class TriangleTest {

  public static void main(String[] args) {
    Triangle triangle = new Triangle();
    Scanner scanner = new Scanner(System.in);
    double a, b, c;
    while (true) {
      System.out.println("Input 3 sides of a triangle: ");
      a = scanner.nextDouble();
      b = scanner.nextDouble();
      c = scanner.nextDouble();
      if (a == 0 && b == 0 && c == 0) {
        System.out.println("Bye!");
        break;
      }
      try {
        triangle.setSides(a, b, c);
        System.out.println(triangle);
      } catch (TriangleException e) {
        System.out.println(e);
      }
    }
    scanner.close();
  }
}

class Triangle {

  private double a, b, c;

  public Triangle() {}

  public void setSides(double a, double b, double c) throws TriangleException {
    if (a * b * c != 0 && a + b > c && a + c > b && b + c > a) {
      this.a = a;
      this.b = b;
      this.c = c;
    } else {
      throw new TriangleException("Invalid sides!");
    }
  }

  public double area() {
    double p = (a + b + c) / 2;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
  }

  public double perimeter() {
    return a + b + c;
  }

  @Override
  public String toString() {
    return (
      "Triangle [a=" +
      a +
      ", b=" +
      b +
      ", c=" +
      c +
      ", area=" +
      area() +
      ", perimeter=" +
      perimeter() +
      "]"
    );
  }
}

class TriangleException extends Exception {

  private static final long serialVersionUID = 1L;

  public TriangleException() {
    super();
  }

  public TriangleException(String message) {
    super(message);
  }
}
