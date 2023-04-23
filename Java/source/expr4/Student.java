public class Student {

  private String stuNum, stuName;
  private int stuAge;
  static int totalNum = 0;

  public Student() {
    totalNum++;
  }

  public Student(String stuNum, String stuName, int stuAge) {
    this.stuNum = stuNum;
    this.stuName = stuName;
    this.stuAge = stuAge;
    totalNum++;
  }

  // getter and setter
  public String getStuNum() {
    return stuNum;
  }

  public void setStuNum(String stuNum) {
    this.stuNum = stuNum;
  }

  public String getstuName() {
    return stuName;
  }

  public void setstuName(String stuName) {
    this.stuName = stuName;
  }

  public int getStuAge() {
    return stuAge;
  }

  public void setStuAge(int stuAge) {
    this.stuAge = stuAge;
  }

  public static int getTotalNum() {
    return totalNum;
  }

  public static void setTotalNum(int totalNum) {
    Student.totalNum = totalNum;
  }

  public void printStudent() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    return (stuNum + ',' + stuName + ',' + stuAge + ",total=" + totalNum);
  }

  public static void main(String[] args) {
    Student st1 = new Student("s001", "孙悟空", 525);
    st1.printStudent();
    Student st2 = new Student("s002", "唐僧", 50);
    st2.printStudent();
    Student.setTotalNum(35);
    System.out.println(st1);
    System.out.println(st2);
    Student st3 = new Student();
    st3.setStuNum("s003");
    st3.setstuName("tom");
    st3.setStuAge(19);
    // st3.printStudent();
    System.out.println(st3);

    int newAge = 20;
    System.out.println("newAge:" + newAge);
    st2.setStuAge(newAge);
    System.out.println("age of st2:" + st2.getStuAge());
  }
}
