package expr7;

import java.util.Scanner;

/**
 * MyExceptionTestExceptionTest
 */
public class MyExceptionTest {

  public static int multiply(int a, int b) throws MyException {
    int result;
    result = a * b;
    if (result < -32768 || result > 32767) {
      throw new MyException("Out of range of [-32768, 32767]");
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    out:while (true) {
      System.out.println("Input 2 integer: ");
      int a = scanner.nextInt(), b = scanner.nextInt();
      if (a == 0 && b == 0) {
        break out;
      }
      try {
        System.out.println(a + "*" + b + "=" + multiply(a, b));
      } catch (MyException e) {
        System.out.println(e);
      }
    }
    scanner.close();
  }
}

class MyException extends Exception {

  public MyException() {
    super();
  }

  public MyException(String msg) {
    super(msg);
  }
}
