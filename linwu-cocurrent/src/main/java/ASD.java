import java.util.ArrayList;
import java.util.Iterator;

public class ASD {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().equals(3)) {
        iterator.remove();
      }
    }

    System.out.println(list);
  }
}
