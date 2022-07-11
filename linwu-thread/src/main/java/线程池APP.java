import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 线程池APP {


    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ArrayList<String> list = new ArrayList<>();
        singleThreadExecutor.execute(() -> {
            try {
                while (true) {
                    byte[] b1 = new byte[1 * 1024 * 1024];

                    list.add(new String(b1));
                    Thread.sleep(1000);
                    System.out.println(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(1);
    }
}
