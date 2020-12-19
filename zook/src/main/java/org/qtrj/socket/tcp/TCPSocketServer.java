package org.qtrj.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServer {

    public static void main(String[] args) throws IOException {
        // 创建socket对象
        // 绑定端口
        ServerSocket server = new ServerSocket(12345);

        // 监听链接，阻塞方法
        Socket s = server.accept();

        // 获取输入流，读取数据
        InputStream inputStream = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);

        System.out.println(new String(bytes, 0, len));

        // 释放资源
        s.close();
        server.close();
    }

}
