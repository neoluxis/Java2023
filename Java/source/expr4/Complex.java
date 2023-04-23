public class Complex {

  double real;
  double imag;

  public Complex(double real, double imag) {
    this.real = real;
    this.imag = imag;
  }

  @Override
  public String toString() {
    if (real == 0 || imag == 0) {
      return "0";
    } else if (real == 0) {
      return imag + "i";
    } else if (imag == 0) {
      return real + "";
    } else if (imag > 0) {
      return real + "+" + imag + "i";
    } else {
      return real + "" + imag + "i";
    }
  }
}

class ComplexCalc {

  public static Complex add(Complex a, Complex b) {
    return new Complex(a.real + b.real, a.imag + b.imag);
  }

  public static Complex subtract(Complex a, Complex b) {
    return new Complex(a.real - b.real, a.imag - b.imag);
  }

  public static Complex multiply(Complex a, Complex b) {
    return new Complex(
      a.real * b.real - a.imag * b.imag,
      a.real * b.imag + a.imag * b.real
    );
  }

  public static Complex divide(Complex a, Complex b) {
    double denominator = b.real * b.real + b.imag * b.imag;
    return new Complex(
      (a.real * b.real + a.imag * b.imag) / denominator,
      (a.imag * b.real - a.real * b.imag) / denominator
    );
  }

  public static void main(String[] args) {
    Complex a = new Complex(1, 3);
    Complex b = new Complex(2, 5);
    System.out.println(ComplexCalc.add(a, b));
    System.out.println(ComplexCalc.subtract(a, b));
    System.out.println(ComplexCalc.multiply(a, b));
    System.out.println(ComplexCalc.divide(a, b));
    System.out.println("--------------------try again---------------------");
    Complex c = new Complex(1, 3);
    Complex d = new Complex(0, 3);
    System.out.println(ComplexCalc.add(c, d));
    System.out.println(ComplexCalc.subtract(c, d));
    System.out.println(ComplexCalc.multiply(c, d));
    System.out.println(ComplexCalc.divide(c, d));
  }
}
