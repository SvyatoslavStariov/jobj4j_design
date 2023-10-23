package ru.job4j.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Analysis {
    public void unavailable(String source, String target) {
        String rsl = readFile(source);
        if (!rsl.isBlank()) {
            writeFile(rsl, target);
        }
    }

    private String readFile(String source) {
        StringBuilder rls = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            String read;
            boolean isWork = true;
            while ((read = bufferedReader.readLine()) != null) {
                String[] split = read.split(" ");
                if (split.length < 2 || !split[0].matches("[0-9]+") || split[1].isBlank()) {
                    continue;
                }
                String status = split[0];
                String time = split[1];
                int codeStatus = Integer.parseInt(status);
                if (codeStatus >= 400 && codeStatus <= 500) {
                    if (isWork) {
                        rls.append(time).append(";");
                    }
                    isWork = false;
                } else {
                    if (!isWork) {
                        rls.append(time).append(";").append("\n");
                    }
                    isWork = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(rls);
    }


    private void writeFile(String rls, String target) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(target))) {
            bufferedWriter.write(rls);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}