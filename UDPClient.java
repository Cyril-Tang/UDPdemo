import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            try {
                CC();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();











//        //定义服务器的地址，端口号，数据
//        InetAddress address = InetAddress.getByName("localhost");
//        int port = 8800;
//        byte[] data = "用户名：admin;密码：123".getBytes();//将字符串转换为字节数组
//        //创建数据报
//        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
//        //创建DatagramSocket，实现数据发送和接收
//        DatagramSocket socket = new DatagramSocket();
//        //向服务器端发送数据报
//        socket.send(packet);
//
//        //接收服务器响应数据
//        byte[] data2 = new byte[1024];
//        DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
////        while(true) {
////            socket.receive(packet2);
////
//            String info = new String(data2, 0, packet2.getLength());
////            System.out.println("我是客户端，服务器说：" + info);
////            if (info.equals("我在响应你！")) {
////                byte[] data3 = "好了停吧".getBytes();
////                DatagramPacket packet3 = new DatagramPacket(data3, data3.length, packet2.getAddress(), packet2.getPort());
////                socket.send(packet3);
////            }
//
//            Thread tt = new Thread(new process(packet2, socket, info));
//            tt.start();
//        }
        //socket.close();
    }

    public static void CC () throws Exception {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8800;
        byte[] data = "用户名：admin;密码：123".getBytes();//将字符串转换为字节数组
        //创建数据报
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        //创建DatagramSocket，实现数据发送和接收
        DatagramSocket socket = new DatagramSocket();
        //向服务器端发送数据报
        socket.send(packet);

        //接收服务器响应数据
        byte[] data2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
//        while(true) {
//            socket.receive(packet2);
//
        String info = new String(data2, 0, packet2.getLength());
//            System.out.println("我是客户端，服务器说：" + info);
//            if (info.equals("我在响应你！")) {
//                byte[] data3 = "好了停吧".getBytes();
//                DatagramPacket packet3 = new DatagramPacket(data3, data3.length, packet2.getAddress(), packet2.getPort());
//                socket.send(packet3);
//            }

        Thread tt = new Thread(new process(packet2, socket, info));
        tt.start();
    }

}