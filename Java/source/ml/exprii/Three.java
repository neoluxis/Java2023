public class Three {
    public static void main(String[] args) {
        int target = 14;
        int o = 1;
        for (int i = 0; i < target; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("%3d ", o);    
                o++;
            }
            System.out.println();
        }
    }
}
