package com.nmea.datasource;

import com.nmea.util.CodeManager;
import com.nmea.util.Factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kfzx-zhongw on 2015/4/3.
 */
public class TCPHandler implements Runnable {
    private Socket socket;

    public TCPHandler(Socket connectionSocket) {
        this.socket = connectionSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader inFromClient;
            inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner s = new Scanner(inFromClient);
            s.useDelimiter("\n");
            while (s.hasNext()) {
                ((CodeManager)Factory.getBean("CodeManager")).decode(s.toString());
                s.next();
            }


            socket.shutdownInput();
            socket.close();

            TCPDataSource.productQueue.take();

        } catch (IOException|InterruptedException e) {
            e.printStackTrace();
        }


    }
}