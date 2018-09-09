package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Webserver2 {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("Ready Server");

        while(true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println(socket.getInetAddress());
                OutputStream out = socket.getOutputStream();

                File file = new File("C:\\zzz\\aaa.mp3");

                out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                out.write(new String("Cache-Control: private\r\n").getBytes());
                out.write(new String("Content-Length: "+file.length()+"\r\n").getBytes());
                out.write(new String("Content-Type: audio/mpeg;\r\n\r\n").getBytes());

                FileInputStream fin = new FileInputStream(file);
                byte[] buffer = new byte[1024*8];

                while(true){
                    try {
                        int count = fin.read(buffer);
                        if (count == -1) {
                            break;
                        }
                        out.write(buffer, 0, count);
                        out.flush();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                socket.close();
            }//end catch
        }//end while
    }//end main
}//end class
