import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Four
 * @description:  Given a text file d:\numbers.txt, read in all integers from the file and, output all the even numbers to file d:\evens.txt, all the odd numbers to file d:\odds.txt, and all the prime numbers to file d:\primes.txt.
 */
public class Four {

  public static final String NUMBERS = "numbers.txt";
  public static final String PRIME = "primes.txt";
  public static final String ODD = "odds.txt";
  public static final String EVEN = "evens.txt";

  public static void main(String[] args) throws IOException {
    // open NUMBER
    Scanner scanner = new Scanner(Path.of(NUMBERS));
    // open PRIME
    PrintWriter primeWriter = new PrintWriter(PRIME);
    // open ODD
    PrintWriter oddWriter = new PrintWriter(ODD);
    // open EVEN
    PrintWriter evenWriter = new PrintWriter(EVEN);

    while(scanner.hasNextInt()) {
      int n = scanner.nextInt();
      if (isPrime(n)) primeWriter.println(n);
      if (isOdd(n)) oddWriter.println(n);
      if (isEven(n)) evenWriter.println(n);
    }

    scanner.close();
    primeWriter.close(); // Close the primeWriter
    oddWriter.close();  // Close the oddWriter
    evenWriter.close(); // Close the evenWriter
    /***
     * 注意，需要关闭 PrintWriter 对象，否则文件内容不会写入到文件中。
     */
  }

  public static boolean isOdd(int n) {
    return n % 2 == 1;
  }

  public static boolean isPrime(int n) {
    if (n == 1) return false;
    for (int i = 2; i < n; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }

  public static boolean isEven(int n) {
    return n % 2 == 0;
  }
}
