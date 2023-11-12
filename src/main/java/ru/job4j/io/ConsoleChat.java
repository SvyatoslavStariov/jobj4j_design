package ru.job4j.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        var scanner = new Scanner(System.in);
        Random random = new Random();
        List<String> logs = new ArrayList<>();
        boolean isContinue = true;
        boolean isPause = false;
        List<String> phrases = readPhrases();
        while (scanner.hasNextLine() && isContinue) {
            String word = scanner.next();
            logs.add(word);
            if (CONTINUE.equals(word)) {
                isPause = false;
            } else if (STOP.equals(word)) {
                isPause = true;
            } else if (OUT.equals(word)) {
                saveLog(logs);
                isContinue = false;
            } else if (!isPause) {
                int indexRandom = random.nextInt(phrases.size());
                String phrase = phrases.get(indexRandom);
                logs.add(phrase);
                System.out.println(phrase);
            }
        }
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            phrases.addAll(br.lines().toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> logs) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(logs.stream().map(log -> log + System.lineSeparator()).collect(Collectors.joining()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(
                "data/logs.txt",
                "data/bot_answer.txt"
        );
        cc.run();
    }
}