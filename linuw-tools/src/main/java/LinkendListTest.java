import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class LinkendListTest {

    public static void main(String[] args) {
        LinkedList<String> list = fullList();

        long start = System.currentTimeMillis();
        myTest(list);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        LinkedList<String> objects = new LinkedList(list);
        long start1 = System.currentTimeMillis();
        myTest(objects);
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);

    }


    private static LinkedList<String> fullList() {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 20000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        return list;
    }

    private static void myTest(List<String> list) {
        ArrayList<String> objects = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            objects.add(list.get(i));
        }
    }
}
