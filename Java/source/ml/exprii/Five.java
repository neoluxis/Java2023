public class Five {

  static int[] scores = {
    82,
    74,
    65,
    77,
    52,
    98,
    46,
    67,
    88,
    91,
    73,
    87,
    71,
    91,
    83,
    62,
    79,
    82,
    66,
    72,
  };

  public static void main(String[] args) {
    int sum = 0;
    for (int i = 0; i < scores.length; i++) {
      sum += scores[i];
      for (int j = i; j < scores.length; j++) {
        if (scores[i] < scores[j]) {
          int swap = scores[i];
          scores[i] = scores[j];
          scores[j] = swap;
        }
      }
    }
    System.out.println("平均分：" + sum / scores.length);
    System.out.println("最高分：" + scores[0]);
  }
}
