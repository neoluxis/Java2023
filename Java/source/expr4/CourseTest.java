
import java.util.Scanner;

public class CourseTest {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(
      "Input course information (course number, course name, and credits):"
    );
    String CourseNum = sc.next();
    String CourseTitle = sc.nextLine();
    double CourseCredits = sc.nextDouble();
    Course c1 = new Course(CourseNum, CourseTitle, CourseCredits);
    Course c2 = new Course(CourseNum, CourseTitle, CourseCredits);
    // output all
    System.out.println("Course Number: " + c1.getCourseNumber());
    System.out.println("Course Title: " + c1.getCourseTitle());
    System.out.println("Course Credits: " + c1.getCourseCredits());
    System.out.println("Course Hours: " + c1.getHours());
    System.out.println("Course Number: " + c2.getCourseNumber());
    System.out.println("Course Title: " + c2.getCourseTitle());
    System.out.println("Course Credits: " + c2.getCourseCredits());
    System.out.println("Course Hours: " + c2.getHours());

    sc.close();
  }
}
