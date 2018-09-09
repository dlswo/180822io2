package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Webserver1 {

    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("Ready Server");

        while(true) {

            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress());



             Scanner inScanner = new Scanner(socket.getInputStream());

            OutputStream out = socket.getOutputStream();

            File file = new File("c:\\zzz\\img\\face12.jpg");

            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: "+file.length()+"\r\n").getBytes());
            out.write(new String("Content-Type: image/jpeg; charset=UTF-8\r\n\r\n").getBytes());

            FileInputStream fin = new FileInputStream(file);
            byte[] buffer = new byte[1024*8];

            while(true) {
                int count = fin.read(buffer);
                if(count == -1){ break;}
                out.write(buffer,0,count);
            }

            out.flush();
//            out.close();
//            socket.close();


        }


    }
}
