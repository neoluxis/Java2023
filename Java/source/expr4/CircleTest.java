
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(5);

        c1.setRadius(10);
        System.out.println("Area: " + c1.area());
        System.out.println("Perimeter: " + c1.perimeter());
        System.out.println("Diameter: " + c1.getRadius()*2);
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Area: " + c2.area());
        System.out.println("Perimeter: " + c2.perimeter());
        System.out.println("Diameter: " + c2.getRadius()*2);
    }
}
