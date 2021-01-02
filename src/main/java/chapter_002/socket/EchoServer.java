package chapter_002.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(900)) {
            boolean check = true;

            while (check) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
//                    String str = in.readLine();
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Bye")) {
                            check = false;
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());

                }
            }
        }
    }
}
