import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class process implements Runnable {
    private DatagramSocket sk;
    private DatagramPacket pk;
    private String ss;

    public process(DatagramPacket dp, DatagramSocket ds, String content) {
        this.pk = dp;
        this.sk = ds;
        this.ss = content;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sk.receive(pk);
                String info = new String(pk.getData(), 0, pk.getLength());
                System.out.println("收到的是： " + info);
                if (info.equals("我在响应你！")) {
                    byte[] data3 = "好了停吧".getBytes();
                    DatagramPacket packet3 = new DatagramPacket(data3, data3.length, pk.getAddress(), pk.getPort());
                    sk.send(packet3);
                }
                if (info.equals("好的收到！")) {
                    byte[] data3 = "第二次".getBytes();
                    DatagramPacket packet3 = new DatagramPacket(data3, data3.length, pk.getAddress(), pk.getPort());
                    sk.send(packet3);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
