import java.util.Scanner;

public class Four {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("请输入一个4位的电话号码：");
    int tele = sc.nextInt();
    System.out.print("加密后的数字：");
    int[] nums = encrypt(tele);
    for (int i = 0; i < 4; i++) {
      System.out.print(nums[i]);
    }
    System.out.println();
    sc.close();
  }

  public static int[] encrypt(int tele) {
    String teleStr = String.valueOf(tele);
    char[] telec = teleStr.toCharArray();
    int[] nums = new int[4];

    for (int i = 0; i < 4; i++) {
      switch (telec[i]) {
        case '0':
          nums[i] = 0;
          break;
        case '1':
          nums[i] = 1;
          break;
        case '2':
          nums[i] = 2;
          break;
        case '3':
          nums[i] = 3;
          break;
        case '4':
          nums[i] = 4;
          break;
        case '5':
          nums[i] = 5;
          break;
        case '6':
          nums[i] = 6;
          break;
        case '7':
          nums[i] = 7;
          break;
        case '8':
          nums[i] = 8;
          break;
        case '9':
          nums[i] = 9;
          break;
        default:
          break;
      }
    }

    // add 5 to every digit
    for (int i = 0; i < 4; i++) {
      nums[i] += 5;
      nums[i] %= 10;
    }

    int swap = nums[0];
    nums[0] = nums[3];
    nums[3] = swap;
    swap = nums[1];
    nums[1] = nums[2];
    nums[2] = swap;
    return nums;
  }
}
