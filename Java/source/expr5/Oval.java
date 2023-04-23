public class Oval extends Shape {

  private double a;
  private double b;

  public Oval() {
    this(1, 1);
  }

  public Oval(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double area() {
    return Math.PI * a * b;
  }

  public double perimeter() {
    return (2 * Math.PI * Math.sqrt((a * a + b * b) / 2));
  }

  @Override
  public String toString() {
    return (
      "Oval [a=" +
      a +
      ", b=" +
      b +
      "]" +
      " area=" +
      area() +
      " perimeter=" +
      perimeter()
    );
  }
}
