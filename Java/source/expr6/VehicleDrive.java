public class VehicleDrive {

  public static void main(String[] args) {
    Car car1 = new Car();
    System.out.println(car1);
    car1.speedUp(10, 5);
    System.out.println(car1);
    car1.speedDown(15, 2);
    System.out.println(car1);
    car1.speedDown(15, 2);
    System.out.println(car1);
  }
}

interface SpeedUp {
  void speedUp(double acceleration, double time);
}

interface SpeedDown {
  void speedDown(double slowDown, double time);
}

class Car implements SpeedUp, SpeedDown {

  private double speed;

  public Car() {
    this(0);
  }

  public Car(double speed) {
    this.speed = speed;
  }

  @Override
  public void speedUp(double acceleration, double time) {
    System.out.println("Speed up from " + speed + " for " + time + " seconds");
    speed += acceleration * time;
  }

  @Override
  public void speedDown(double slowDown, double time) {
    System.out.println(
      "Speed down from " + speed + " for " + time + " seconds"
    );
    speed -= slowDown * time;
    if (speed < 0) {
      speed = 0;
    }
  }

  @Override
  public String toString() {
    return "Car [speed=" + speed + "]";
  }
}
