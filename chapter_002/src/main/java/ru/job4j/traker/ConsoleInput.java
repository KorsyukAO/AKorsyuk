package ru.job4j.traker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question){
        System.out.println(question);
        return scanner.nextLine();
    }
}
