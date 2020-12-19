package org.qtrj.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSocketClient {

    public static void main(String[] args) throws UnknownHostException, IOException {
        // 创建客户端socket对象
        // 在socket中指定传输数据的目的ip和端口
        Socket client = new Socket("127.0.0.1", 12345);

        // 通过socket建立的通道输出数据
        OutputStream outputStream = client.getOutputStream();
        outputStream.write("This's TCP!".getBytes());

        // 释放资源
        client.close();
    }

}
