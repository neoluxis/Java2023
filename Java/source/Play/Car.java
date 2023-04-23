package Play;

public class Car {
    public static void main(String[] args) {
        Maio m = new Maio();
        Maio n = new Maio("Mio");
        System.out.println(n);
        
        System.out.println(m);
    }
}

class Maio {

    public String name;

    public Maio(){
        this("Null");
    }

    public Maio(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Maio: " + name;
    }

}
