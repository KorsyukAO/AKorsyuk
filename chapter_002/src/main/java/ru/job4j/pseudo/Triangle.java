package ru.job4j.pseudo;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append('\n').append("   +   ");
        pic.append('\n').append("  +++   ");
        pic.append('\n').append(" +++++  ");
        pic.append('\n').append("+++++++");
        return pic.toString();
    }
}
