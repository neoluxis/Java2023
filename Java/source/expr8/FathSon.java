public class FathSon {
    public static void main(String[] args) {
        F f;
        f = new S();
        f.p();
    }
}

class F {
    void p(){
        System.out.println("F");
    }
}

class S extends F {
    void p(){
        System.out.println("S");
    }
}
