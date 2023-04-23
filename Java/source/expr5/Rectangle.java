/**
 * Rectangle
 */
public class Rectangle {

    private double length, width;
    Rectangle(){}
    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    // setter and getters
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    // area
    public double area(){
        return length * width;
    }
    // perimeter
    public double perimeter(){
        return 2 * (length + width);
    }
    // show
    public void showMe(){
        System.out.print("矩形：长"+length+"，宽"+width);
        System.out.println(", 周长"+perimeter()+", 面积"+area());
    }
}