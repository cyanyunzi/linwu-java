import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPPApp {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.80.94", 62828);

        // 使用Socket对象中的方法getOutputStream()，获取网络字节输出流OutputStream对象。
        OutputStream outputStream = socket.getOutputStream();

        // 使用网络字节输出流OutputStream对象中的方法write，给服务器发送数据。
        outputStream.write("<657>Dec  6 13:51:29 vsg VSP: SerialNum=1103331709079998 GenTime=\"2018-12-25 16:15:55\" SrcIP=192.168.13.217 ip=172.16.31.37 ns=Unknown name=Unknown vendor=Unknown model=Unknown location=Unknown fireware_ver=Unknown evt_type=3 block_ip=* Level=5 content=\"非法接入\" desc=\"非拓扑资产非法连接 172.16.255.255:137\" IsOutreach=0 OutreachInfo=  DstIP=172.16.255.255 SrcPort=137 DstPort=137 InInterface=ge0/4(NULL) count=1".getBytes());

        // 使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象。
        InputStream inputStream = socket.getInputStream();

        // 使用网络字节输入流InputStream对象中的方法read，读取服务器回写的数据。
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String x = new String(bytes, 0, len);
        System.out.println(x);

        // 释放资源(Socket)。
        socket.close();
    }

}
