package com.nmea.datasource;

import akka.actor.ActorRef;
import com.nmea.util.Factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhongwei on 15/4/18.
 */
public class TCPDataSourceAkka {

    private ServerSocket serverSocket;
    private ActorRef remoteActor;

    public TCPDataSourceAkka() {
        try {
            this.serverSocket = new ServerSocket(6789);
            TCPHandlerAkkaSystem system = (TCPHandlerAkkaSystem) Factory.getBean("TCPHandlerAkkaSystem");
            remoteActor = system.getActor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        while (true) {
            Socket connectionSocket = this.serverSocket.accept();

            if (connectionSocket.isConnected()) {
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                String s;

                while ((s = inFromClient.readLine()) != null) {
                    remoteActor.tell(s, null);
                }


            }
        }
    }

}
