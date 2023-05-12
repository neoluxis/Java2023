public class Rectangle implements ShapeX {

  public double length;
  public double width;

  public Rectangle() {
    this(1, 1);
  }

  public Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  @Override
  public double area() {
    return length * width;
  }

  @Override
  public double perimeter() {
    return 2 * (length + width);
  }

  @Override
  public String toString() {
    return (
      "Rectangle [length=" +
      length +
      ", width=" +
      width +
      " area: " +
      area() +
      " perimeter: " +
      perimeter() +
      "]"
    );
  }

  @Override
  public Rectangle clone() {
    return new Rectangle(length, width);
  }
}
