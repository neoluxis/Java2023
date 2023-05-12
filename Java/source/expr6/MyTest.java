public class MyTest {

  public static void main(String[] args) {
    Musician musician = new Musician("Tom");
    Instrument piano = new Piano();
    Instrument violin = new Violin();
    musician.play(piano);
    musician.play(violin);

    Musician musician2 = new Musician("Jerry");
    musician2.play(piano);
    musician2.play(violin);
  }
}

interface Instrument {
  public String makeSound();
}

class Piano implements Instrument {

  @Override
  public String makeSound() {
    System.out.println("Piano is making sound.");
    return "Piano";
  }
}

class Violin implements Instrument {

  @Override
  public String makeSound() {
    System.out.println("Violin is making sound.");
    return "Violin";
  }
}

class Musician {

  String name;

  public Musician() {
    name = "Musician";
  }

  public Musician(String name) {
    this.name = name;
  }

  public void play(Instrument instrument) {
    System.out.println(name + "is playing " + instrument.makeSound());
  }
}
