
public class Course {
    private String courseNumber;
    private String courseTitle;
    private double courseCredits;

    public Course(){}

    public Course(String courseNumber, String courseTitle, Double courseCredits) {
        this.courseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.courseCredits = courseCredits;
    }

    // mutator and accessor methods
    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(double courseCredits) {
        this.courseCredits = courseCredits;
    }

    public double getHours() {
        return courseCredits * 16;
    }
}
