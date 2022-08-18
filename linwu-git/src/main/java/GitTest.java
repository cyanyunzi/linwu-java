import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GitTest {
    public static void main(String[] args) {
//        System.out.println("git test");
//        System.out.println("需要提交的东西");
        //这里搁置的东西

        LocalDateTime parse = LocalDateTime.parse("20121123.1111", DateTimeFormatter.ofPattern("yyyyMMdd.HHmm"));
        System.out.println(parse.toLocalDate().toString());
        System.out.println(parse.toLocalTime().toString());
        System.out.println("测试回滚提交1");

    }
}
