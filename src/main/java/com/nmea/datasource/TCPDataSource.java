package com.nmea.datasource;

import com.nmea.util.ProductQueue;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kfzx-zhongw on 2015/4/3.
 */
public class TCPDataSource {

    private ServerSocket serverSocket;

    public static ProductQueue productQueue = new ProductQueue(5);


    public TCPDataSource() {
        try {
            this.serverSocket = new ServerSocket(6789);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        while (true) {
            Socket connectionSocket = this.serverSocket.accept();

            if (connectionSocket.isConnected()) {
                try {
                    TCPDataSource.productQueue.put(1);
                    new Thread(new TCPHandler(connectionSocket)).start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


