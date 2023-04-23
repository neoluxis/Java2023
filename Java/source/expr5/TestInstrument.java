/**
 * TestInstrument
 */
public class TestInstrument {

  public static void main(String[] args) {
    Musician bob = new Musician("Bob");
    Erhu erhu = new Erhu();
    Piano piano = new Piano();
    Violin violin = new Violin();
    System.out.println(bob.getName());
    bob.play(erhu);
    bob.play(piano);
    bob.play(violin);
    System.out.println(piano.getName());
    Musician[] players = {
      new Musician("tom"),
      new Musician("jerry"),
      new Musician("mickey"),
      new Musician("pluto"),
    };
    for (Musician player : players) {
      player.play(piano);
    }
  }
}

class Erhu extends Instrument {

  public String makeSound() {
    return "Erhu";
  }
}

class Piano extends Instrument {

  public String getName() {
    return "Piano";
  }

  public String makeSound() {
    return "Piano";
  }
}

class Violin extends Instrument {

  public String makeSound() {
    return "Violin";
  }
}
