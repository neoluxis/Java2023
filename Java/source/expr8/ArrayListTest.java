
import java.util.ArrayList;

/**
 * ArrayListTest
 */
public class ArrayListTest {

  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<String>();
    names.add("James");
    names.add("Tom");
    names.add("Steven");
    names.add("Alice");
    names.add("Bob");
    names.add("Eve");
    names.add("Mary");
    names.add("Jerry");
    for (int i = 0; i < names.size(); i++) {
      System.out.print(names.get(i) + " ");
    }
    System.out.println();

    names.remove("Tom");
    names.sort(null);
    for (String string : names) {
      System.out.print(string + " ");
    }
    System.out.println();
  }
}
