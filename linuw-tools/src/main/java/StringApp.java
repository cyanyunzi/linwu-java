import java.util.StringTokenizer;

public class StringApp {
    public static void main(String[] args) {
        StringTokenizer serverAddrsTokens = new StringTokenizer("192.168.80.94;192.168.80.95;192.168.80.96", ",;");
        while (serverAddrsTokens.hasMoreTokens()) {
            String serverAddr = serverAddrsTokens.nextToken().trim();
            System.out.println(serverAddr);
        }
    }
}
