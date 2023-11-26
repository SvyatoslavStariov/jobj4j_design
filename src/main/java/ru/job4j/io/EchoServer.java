package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (!str.startsWith("GET")) {
                            continue;
                        }
                        String[] params = str.split(" ");
                        if (params.length < 1 || !params[1].matches(".*=.*")) {
                            continue;
                        }
                        String[] requestParams = params[1].split("=");
                        if (requestParams.length < 1 || !"Bye".equals(requestParams[1])) {
                            continue;
                        }
                        server.close();
                    }
                    out.flush();
                }
            }
        }
    }
}