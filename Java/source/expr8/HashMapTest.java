import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
  public HashMapTest() {
    // Create a HashMap to store Student objects
    Map<String, Student> students = new HashMap<>();

    // Add students to the HashMap
    students.put("17H002", new Student("17H002", "孙悟空", 2000));
    students.put("17H001", new Student("17H001", "唐僧", 40));
    students.put("17H003", new Student("17H003", "猪八戒", 1000));
    students.put("17H004", new Student("17H004", "沙僧", 900));

    // Output information of the student with id "17H003"
    Student student17H003 = students.get("17H003");
    System.out.println("Information of the student with id 17H003:");
    System.out.println(student17H003);

    // Output information of all students
    System.out.println("Information of all students:");
    for (Student student : students.values()) {
      System.out.println(student);
    }

    // Remove "唐僧"
    students.remove("17H001");

    // Convert HashMap to an array of type Student
    Student[] studentArray = students.values().toArray(new Student[0]);

    // Print out all elements of the array using a for-each loop
    System.out.println("Elements of the Student array:");
    for (Student student : studentArray) {
      System.out.println(student);
    }
  }

  public static void main(String[] args) {
    // Create a HashMapTest object to call the no-argument constructor
    new HashMapTest();
  }
}

class Student {
  private String id;
  private String name;
  private int age;

  public Student(String id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public Student() {
    // No-argument constructor
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
