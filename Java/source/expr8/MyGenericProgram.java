interface Arithmetical<T> {
    T add(T obj);
    T subtract(T obj);
    T multiply(T obj);
    T divide(T obj);
}

class Complex implements Arithmetical<Complex> {
    double real, imag;

    Complex(double r, double i) {
        real = r;
        imag = i;
    }

    public Complex add(Complex obj) {
        return new Complex(real + obj.real, imag + obj.imag);
    }

    public Complex subtract(Complex obj) {
        return new Complex(real - obj.real, imag - obj.imag);
    }

    public Complex multiply(Complex obj) {
        return new Complex(real * obj.real - imag * obj.imag, real * obj.imag + imag * obj.real);
    }

    public Complex divide(Complex obj) {
        double denominator = obj.real * obj.real + obj.imag * obj.imag;
        return new Complex((real * obj.real + imag * obj.imag) / denominator,
                (imag * obj.real - real * obj.imag) / denominator);
    }
}

class Fraction implements Arithmetical<Fraction> {
    int numerator, denominator;

    Fraction(int n, int d) {
        numerator = n;
        denominator = d;
    }

    public Fraction add(Fraction obj) {
        int n = numerator * obj.denominator + obj.numerator * denominator;
        int d = denominator * obj.denominator;
        return new Fraction(n, d);
    }

    public Fraction subtract(Fraction obj) {
        int n = numerator * obj.denominator - obj.numerator * denominator;
        int d = denominator * obj.denominator;
        return new Fraction(n, d);
    }

    public Fraction multiply(Fraction obj) {
        int n = numerator * obj.numerator;
        int d = denominator * obj.denominator;
        return new Fraction(n, d);
    }

    public Fraction divide(Fraction obj) {
        int n = numerator * obj.denominator;
        int d = denominator * obj.numerator;
        return new Fraction(n, d);
    }
}

public class MyGenericProgram {
    public static void main(String[] args) {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);
        Complex c3 = c1.add(c2);
        Complex c4 = c1.subtract(c2);
        Complex c5 = c1.multiply(c2);
        Complex c6 = c1.divide(c2);
        System.out.println("Complex addition: " + c3.real + " + " + c3.imag + "i");
        System.out.println("Complex subtraction: " + c4.real + " + " + c4.imag + "i");
        System.out.println("Complex multiplication: " + c5.real + " + " + c5.imag + "i");
        System.out.println("Complex division: " + c6.real + " + " + c6.imag + "i");

        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);
        Fraction f3 = f1.add(f2);
        Fraction f4 = f1.subtract(f2);
        Fraction f5 = f1.multiply(f2);
        Fraction f6 = f1.divide(f2);
        System.out.println("Fraction addition: " + f3.numerator + "/" + f3.denominator);
        System.out.println("Fraction subtraction: " + f4.numerator + "/" + f4.denominator);
        System.out.println("Fraction multiplication: " + f5.numerator + "/" + f5.denominator);
        System.out.println("Fraction division: " + f6.numerator + "/" + f6.denominator);
    }
}