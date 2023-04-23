
public class Circle {

  private double radius;

  public Circle() {
    this.radius = 1.0;
  }

  public Circle(double radius) {
    this.radius = radius;
  }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area(){
        return Math.PI * radius * radius;
    }

    public double perimeter(){
        return 2 * Math.PI * radius;
    }
}
