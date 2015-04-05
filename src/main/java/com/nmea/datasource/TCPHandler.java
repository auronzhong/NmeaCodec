package com.nmea.datasource;

import com.nmea.codec.AbstractNmeaCodec;
import com.nmea.codec.GllNmeaCodec;
import com.nmea.util.CodeManager;
import com.nmea.util.Factory;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
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

            doDecode(inFromClient);

            socket.shutdownInput();
            socket.close();

            TCPDataSource.productQueue.take();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void doDecode(BufferedReader inFromClient) throws IOException {

        String s;

        while ((s = inFromClient.readLine()) != null) {
            ((CodeManager) Factory.getBean("CodeManager")).decode(s);
        }

    }

}