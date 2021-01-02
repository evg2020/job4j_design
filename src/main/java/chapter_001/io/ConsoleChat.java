package chapter_001.io;
//программу 'Консольный чат'. описание:

//- пользователь вводит слово-фразу, программа берет случайную фразу из текстового файла и выводит в ответ.
//- программа замолкает если пользователь вводит слово «стоп», при этом он может продолжать отправлять сообщения в чат.
//- если пользователь вводит слово «продолжить», программа снова начинает отвечать.
//- при вводе слова «закончить» программа прекращает работу.
//- запись диалога, включая слова-команды стоп/продолжить/закончить должны быть записаны в текстовый лог.

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        StringBuilder dialog = new StringBuilder();
        String userMessage = CONTINUE;
        int com = 1;
        while (!userMessage.equals(OUT)) {
            if (!userMessage.equals(STOP) && com != 2) {
                String botMessage = "bot:  " + botAnswer();
                System.out.println(botMessage);
                dialog.append(botMessage).append(System.lineSeparator());
                System.out.print("user: ");
                userMessage = sc.nextLine();
                dialog.append("user: ").append(userMessage).append(System.lineSeparator());

            } else if (userMessage.equals(STOP) || com == 2) {
                if ((userMessage.equals(CONTINUE))) {
                    com = 1;
                } else {
                    System.out.print("user: ");
                    userMessage = sc.nextLine();
                    dialog.append("user: ").append(userMessage).append(System.lineSeparator());
                    com = 2;
                }
            }
        }

        writeFile(dialog.toString(), path);
    }

    private String botAnswer() {
        List<String> answer = readLine(botAnswers);
        int pozition = (int) (Math.random() * answer.size());
        return answer.get(pozition);
    }

    private List<String> readLine(String path) {
        List<String> res = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8))) {
            in.lines().forEach(res::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private void writeFile(String data, String path) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8))) {
            br.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("logfile.txt", "bot.txt");
        cc.run();
    }
}
