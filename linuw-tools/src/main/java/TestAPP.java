import java.io.IOException;

public class TestAPP {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process exec = Runtime.getRuntime().exec("sh /Users/zhanglei/soft/nacos/pangu-nacos-2.2.3/bin/startup.sh");
        int i = exec.waitFor();
        System.out.println(1);
    }

    /*
    * Spring 匹配Java 包名com.venustech.taihe.pangu
    * */




}
