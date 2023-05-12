package expr7;

import java.util.Scanner;

/**
 * ComplexTest
 */
public class ComplexTest {

  static Complex testCases[][] = {
    { new Complex(1, 2), new Complex(0, 1) },
    { new Complex(1, 2), new Complex(0, 0) },
    { new Complex(1, 2), new Complex(3, 4) },
    { new Complex(1, 2), new Complex(2, 0) },
  };

  public static void main(String[] args) {
    for (Complex[] testCase : testCases) {
      System.out.println("c1: " + testCase[0]);
      System.out.println("c2: " + testCase[1]);
      System.out.println("c1 + c2: " + Complex.add(testCase[0], testCase[1]));
      System.out.println("c1 - c2: " + Complex.sub(testCase[0], testCase[1]));
      System.out.println("c1 * c2: " + Complex.mul(testCase[0], testCase[1]));
      try {
        System.out.println("c1 / c2: " + Complex.div(testCase[0], testCase[1]));
      } catch (ComplexException e) {
        System.out.println(e);
      }
    }
  }
}

class Complex {

  private double real, imag;

  public Complex() {
    this(0, 0);
  }

  public Complex(double real, double imag) {
    this.real = real;
    this.imag = imag;
  }

  @Override
  public String toString() {
    return real + " + " + imag + "i";
  }

  public static Complex add(Complex c1, Complex c2) {
    return new Complex(c1.real + c2.real, c1.imag + c2.imag);
  }

  public static Complex sub(Complex c1, Complex c2) {
    return new Complex(c1.real - c2.real, c1.imag - c2.imag);
  }

  public static Complex mul(Complex c1, Complex c2) {
    return new Complex(
      c1.real * c2.real - c1.imag * c2.imag,
      c1.real * c2.imag + c1.imag * c2.real
    );
  }

  public static Complex div(Complex c1, Complex c2) throws ComplexException {
    if (c2.real == 0 && c2.imag == 0) {
      throw new ComplexException("Divisor cannot be zero!");
    }
    double denominator = c2.real * c2.real + c2.imag * c2.imag;
    return new Complex(
      (c1.real * c2.real + c1.imag * c2.imag) / denominator,
      (c1.imag * c2.real - c1.real * c2.imag) / denominator
    );
  }
}

class ComplexException extends Exception {

  private static final long serialVersionUID = 1L;

  public ComplexException() {
    super();
  }

  public ComplexException(String message) {
    super(message);
  }
}
