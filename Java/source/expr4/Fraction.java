public class Fraction {

  private int fz, fm;

  // insert your codes here
  Fraction() {
    this.fz = 0;
    this.fm = 1;
  }

  Fraction(int fz, int fm) {
    this.fz = fz;
    this.fm = fm;
  }

  public void setFz(int fz) {
    this.fz = fz;
  }

  public void setFm(int fm) {
    this.fm = fm;
  }

  public Fraction add(Fraction f1) {
    Fraction fs = new Fraction();
    fs.setFz(this.fz * f1.fm + this.fm * f1.fz);
    fs.setFm(this.fm * f1.fm);
    return fs;
  }

  // insert your codes here
  public Fraction subtract(Fraction f1) {
    Fraction fs = new Fraction();
    fs.setFz(this.fz * f1.fm - this.fm * f1.fz);
    fs.setFm(this.fm * f1.fm);
    return fs;
  }

  public static Fraction multiply(Fraction f1, Fraction f2) {
    Fraction fs = new Fraction();
    fs.setFz(f1.fz * f2.fz);
    fs.setFm(f1.fm * f2.fm);
    return fs;
  }

  // insert your codes here
  public static Fraction divide(Fraction f1, Fraction f2) {
    if (f2.fz == 0) {
      System.out.println("Error: divide by zero");
      return null;
    }
    Fraction fs = new Fraction();
    fs.setFz(f1.fz * f2.fm);
    fs.setFm(f1.fm * f2.fz);
    return fs;
  }

  @Override
  public String toString() {
    return this.fz + "/" + this.fm;
  }

  public static void main(String[] args) {
    Fraction fs1 = new Fraction(1, 3); // 1/3
    Fraction fs2 = new Fraction(2, 5); // 2/5
    System.out.println(fs1.toString());
    System.out.println(fs2); //the same as fs2.toString();
    Fraction fs;
    fs = fs1.add(fs2);
    System.out.println("add: " + fs);
    // insert your codes here
    fs = fs1.subtract(fs2);
    System.out.println("subtract: " + fs);

    fs = Fraction.multiply(fs1, fs2);
    System.out.println("multiply: " + fs);
    // insert your codes here
    fs = Fraction.divide(fs1, fs2);
    System.out.println("divide: " + fs);
  }
}
