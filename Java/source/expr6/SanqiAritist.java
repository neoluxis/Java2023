public class SanqiAritist implements forMovie, forSing, forTV {

  String name;

  public SanqiAritist() {
    this("No name");
  }

  public SanqiAritist(String name) {
    this.name = name;
    System.out.println(this);
  }

  @Override
  public void actInMovie() {
    System.out.println("I am acting in a movie.");
  }

  @Override
  public void sing() {
    System.out.println("I am singing.");
  }

  @Override
  public void actInTV() {
    System.out.println("I am acting in a TV show.");
  }

  @Override
  public String toString() {
    return "SanqiAritist [name=" + name + "]";
  }

  public static void main(String[] args) {
    SanqiAritist sanqi = new SanqiAritist("Sanqi");
    sanqi.actInMovie();
    sanqi.actInTV();
    sanqi.sing();
  }
}

interface forMovie {
  void actInMovie();
}

interface forSing {
  void sing();
}

interface forTV {
  void actInTV();
}
