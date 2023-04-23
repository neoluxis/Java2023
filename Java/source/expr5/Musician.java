public class Musician {

  String name;

  public Musician(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Musician [name=" + name + "]";
  }

  public void play(Instrument i) {
    System.out.println(this + " plays " + i.makeSound());
  }
}
