public class TestGeometry {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.0);
        System.out.println(c1);
        Cylinder cy1 = new Cylinder(2.0, 3.0);
        System.out.println(cy1);
    }
}

class Circle {
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

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Circle[radius=" + radius + "]";
        ret += "Area: " + getArea() + " Perimeter: " + getPerimeter();
        return ret;
    }

}

class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
        this.height = 1.0;
    }

    public Cylinder(double r, double h) {
        super(r);
        this.height = h;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    public double getArea() {
        return 2 * Math.PI * getRadius() * height + 2 * super.getArea();
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Cylinder[height=" + height + "]";
        ret += "Area: " + getArea() + " Volume: " + getVolume();
        return ret;
    }

}