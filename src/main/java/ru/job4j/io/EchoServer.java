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
                    String str = in.readLine();
                    System.out.println(str);
                    out.flush();
                    if (isFinish(str)) {
                        server.close();
                    }
                }
            }
        }
    }

    private static boolean isFinish(String str) {
        String[] params = getParams(str);
        boolean isFinish = false;
        if (params.length != 0) {
            String[] requestParams = params[1].split("=", 2);
            String key = requestParams[0].replaceAll("[/?]", "");
            String value = requestParams[1];
            isFinish = "msg".equals(key) && "Bye".equals(value);
        }
        return isFinish;
    }

    private static String[] getParams(String str) {
        String[] arr = new String[]{};
        if (str.startsWith("GET")) {
            String[] params = str.split(" ");
            if (params.length > 1 && params[1].contains("=")) {
                arr = params;
            }
        }
        return arr;
    }
}