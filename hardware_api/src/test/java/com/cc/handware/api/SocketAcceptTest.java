package com.cc.handware.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.*;

public class SocketAcceptTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(6002);
        Socket socket = serverSocket.accept();

        socket.getOutputStream().write(1);

        Thread.sleep(100);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());
        System.out.println("&&&&&&&&&&&&&");

        StringBuffer sb = new StringBuffer();
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = socket.getInputStream().read(bytes))!=-1){
//            System.out.println("*******"+len);
//            for (int i = 0;i < len; i++){
//                System.out.println(bytes[i]);
//            }
//        }
        System.out.println(sb.toString());
    }

}