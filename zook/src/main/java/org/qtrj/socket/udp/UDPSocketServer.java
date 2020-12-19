package org.qtrj.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSocketServer {

    public static void main(String[] args) throws IOException {
        // 创建服务端socket对象
        int port = 12222;
        DatagramSocket server = new DatagramSocket(port);

        // 创建数据接收容器
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);

        // 接收数据
        server.receive(packet);

        // 数据解析
        String host = packet.getAddress().getHostAddress();
        byte[] bys = packet.getData();
        System.out.println("接收来自" + host + "的信息：" + new String(bys));

        // 释放资源
        server.close();

    }

}
