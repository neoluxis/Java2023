/**
 * Cuboid
 */
public class Cuboid extends Rectangle {
    private double height;
    // Constructor
    public Cuboid(double width, double length, double height) {
        super(width, length);
        this.height = height;
    }
    public Cuboid(){
        this(0,0,0);
    }
    // getter and setter
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    // area
    public double getArea(){
        return 2 * (super.area() + super.getLength() * height + super.getWidth() * height);
    }
    // volume
    public double getVolume(){
        return super.area() * height;
    }

    // showMe
    public void showMe(){
        // display the information of the cuboid in chinese
        System.out.print("长方体的长为：" + super.getLength() + "，宽为：" + super.getWidth() + "，高为：" + height);
        System.out.println("长方体的表面积为：" + getArea() + "，体积为：" + getVolume());
    }
}