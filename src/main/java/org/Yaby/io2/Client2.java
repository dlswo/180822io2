package org.Yaby.io2;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args)throws Exception {

        Scanner keyScanner = new Scanner(System.in);

        System.out.println("Input Your Message");

        String msg = keyScanner.next() + "\n";

        Socket socket = new Socket("10.10.10.90",7777);

        OutputStream out = socket.getOutputStream();


        out.write(msg.getBytes());
        out.flush();

        Scanner inScanner = new Scanner(socket.getInputStream());
        String receiveMsg = inScanner.nextLine();
        System.out.println("RECEIVE: " + receiveMsg);


        out.close();
        socket.close();




    }
}
