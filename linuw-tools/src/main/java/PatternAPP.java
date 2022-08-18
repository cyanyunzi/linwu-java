import java.io.IOException;
import java.util.regex.Pattern;

public class PatternAPP {
    private static Pattern pattern = Pattern.compile("com\\.venustech\\.taihe\\.pangu\\..*service.*");
    public static void main(String[] args) throws IOException, InterruptedException {
        Pattern compile = Pattern.compile("/api/v*", Pattern.CASE_INSENSITIVE);
        String URL = "/api/v2/page/cnsa/audit/search/group/search_tabs";
        System.out.println(compile.matcher(URL).find());
    }

    /*
    * Spring 匹配Java 包名com.venustech.taihe.pangu
    * */




}
