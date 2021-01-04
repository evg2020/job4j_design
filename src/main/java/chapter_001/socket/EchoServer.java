package chapter_001.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(8000)) { //создать сервер.
            boolean check = true;

            while (check) {
                Socket socket = server.accept(); //server.acсept - ожидает, когда к нему обратиться клиент. Программа переходит в режим ожидания.
                try (OutputStream out = socket.getOutputStream(); // Когда клиент обратился к серверу программа получает входной поток и может отправить данные в выходной поток.
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    int num = 0;
                    String mess = "";

                    while (!(str = in.readLine()).isEmpty()) { //В программе читается весь входной поток.
                        System.out.println(str);
                        if (str.contains("GET /?msg=")) {
                            String[] arr = str.split("[= ]");
                            mess = arr[2];
                        }
                        if (str.contains("Bye")) {
                            check = false;
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes()); //В программе читается весь входной поток.
                    out.write(mess.getBytes());
                }
            }
        }
    }
}
