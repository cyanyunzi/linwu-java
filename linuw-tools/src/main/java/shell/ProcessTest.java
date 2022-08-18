package shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessTest {
    public static void main(String[] args) {
        String path = "/Users/zhanglei/Documents/vs-code/泰合/test.sh";
        String command = "arg1 agr2 arg3 arg4 arg5";
        test(path, command);


    }

    public static int test(String path,String command) {
        int waitFor = 1;/*脚本返回出口码  1失败 0成功*/
        StringBuilder builder = new StringBuilder();

        InputStream inputStream = null;
        InputStreamReader in = null;
        BufferedReader br = null;

        try {
            Process p = Runtime.getRuntime().exec(new String[]{path, command});
            inputStream = p.getInputStream();
            in = new InputStreamReader(inputStream);
            br = new BufferedReader(in);
            String line = null;
            while ((line = br.readLine()) != null) {
                builder.append(line);
                builder.append("\r\n");
            }

            waitFor = p.waitFor();

            System.out.println(builder);
            return waitFor;

        } catch (Throwable e) {
            e.getStackTrace();
        } finally {
            closeStream( inputStream, in, br);
        }

        return waitFor;
    }

    private static void closeStream(InputStream inputStream, InputStreamReader in, BufferedReader br) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }
}
