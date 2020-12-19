package org.qtrj.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSocketClient {

    public static void main(String[] args) throws IOException {
        // 创建socket对象

        DatagramSocket client = new DatagramSocket();

        // 数据打包
        String message = "hello udp";
        InetAddress ia = InetAddress.getLocalHost();
        int port = 12222;
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, ia, port);

        // 发送数据
        client.send(packet);

        // 关闭
        client.close();

    }

}
