package expr7;

public class ExceptionTest {

  public static void main(String[] args) {
    String output[] = {
      "The",
      "brown",
      "fox",
      "jumps",
      "over",
      "the",
      "lazy",
      "dog",
    };
    int i = 0;
    while (i < 10) {
      try {
        System.out.println(output[i++]);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("\n 下标越界异常处理！");
        System.out.println(e);
        break;
      } finally {
        System.out.println("Execute no matter what!");
      }
    }
    System.out.println("Haha...");
  }
}
