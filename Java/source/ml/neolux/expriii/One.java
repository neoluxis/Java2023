import java.util.Scanner;

/**
 * One
 */
public class One {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串: ");
        String str = sc.nextLine();
        if (isPalindrome(str)) {
            System.out.println(str + "是一个回文");
        } else {
            System.out.println(str + "不是一个回文");
        }
        
        sc.close();
    }

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}