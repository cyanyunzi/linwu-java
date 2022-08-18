package lottery;

import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LotteryUtils {

  public static final Random RANDOM = new Random();

  public static void SSQ() {
    String red = getNumStr(6, 34);
    String blue = getNumStr(1, 17);
    System.out.println(red + "    " + blue);
  }

  public static void DLT() {

    String red = getNumStr(5, 36);
    String blue = getNumStr(2, 13);
    System.out.println(red + "    " + blue);
  }

  public static void QXC() {
    String red = getNumStr(6, 10);
    String blue = getNumStr(1, 15);
    System.out.println(red + "    " + blue);
  }



  private static String getNumStr(int size, int bound) {
    TreeSet<Integer> set = new TreeSet<>();
    while (true) {
      if (set.size() >= size) {
        break;
      }
      // 红
      Integer num = getNum(bound);
      if (num == 0) {
        continue;
      }
      if (set.contains(num)) {
        continue;
      }
      set.add(num);
    }

    return set.stream()
        .map(
            num -> {
              if (num.toString().length() == 1) {
                return "0" + num;
              }
              return num.toString();
            })
        .collect(Collectors.joining(" "));
  }

  private static Integer getNum(int bound) {
    return RANDOM.nextInt(bound);
  }

  public static void main(String[] args) {
    System.out.println("双色球");
    for (int j = 0; j < 3; j++) {
      SSQ();
    }

    System.out.println("大乐透");
    for (int i = 0; i < 3; i++) {
      DLT();
    }
//
//    System.out.println("七星彩");
//    for (int i = 0; i < 8; i++) {
//      if(i==7){
//        QXC();
//      }
//    }
  }
}
