import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPApp {
    public static void main(String[] args) throws IOException {
        // 创建客户端socket对象
        DatagramSocket ds = new DatagramSocket();
        for (int i = 0; i < 10; i++) {
            byte[] bys = "<657>Dec  6 13:51:29 vsg VSP: SerialNum=1103331709079998 GenTime=\"2018-12-25 16:15:55\" SrcIP=192.168.13.217 ip=172.16.31.37 ns=Unknown name=Unknown vendor=Unknown model=Unknown location=Unknown fireware_ver=Unknown evt_type=3 block_ip=* Level=5 content=\"非法接入\" desc=\"非拓扑资产非法连接 172.16.255.255:137\" IsOutreach=0 OutreachInfo=  DstIP=172.16.255.255 SrcPort=137 DstPort=137 InInterface=ge0/4(NULL) count=1  ".getBytes();
            int length = bys.length;
            InetAddress address = InetAddress.getByName("192.168.80.95");
            int port = 62828;
            // 创建数据，并打包数据
            DatagramPacket dp = new DatagramPacket(bys, length, address, port);
            // 调用DatagramSocket对象方法发送数据
            ds.send(dp);
        }
        System.out.println("发送完毕");
        // 关闭发送端
        ds.close();
    }

}
