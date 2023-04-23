public class Ellipsoid extends Oval {

  private double a, b, c;

  public Ellipsoid() {
    this(1, 1, 1);
  }

  public Ellipsoid(double a, double b, double c) {
    super(a, b);
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public double area() {
    return 4 * Math.PI * a * b;
  }

  @Override
  public String toString() {
    return (
      "Ellipsoid [a=" + a + ", b=" + b + ", c=" + c + "]" + " area=" + area()
    );
  }
}
