package ru.job4j.pseudo;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append(System.lineSeparator()).append("++++++++");
        pic.append(System.lineSeparator()).append("++++++++");
        pic.append(System.lineSeparator()).append("++++++++");
        pic.append(System.lineSeparator()).append("++++++++");
        return pic.toString();
    }
}
