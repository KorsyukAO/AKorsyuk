package ru.job4j.profession;

public class Engineer extends Profession {
    public Engineer(String name, int age, String birthData, String diploma) {
        super(name, age, birthData, diploma);
    }
    public String constructModel(Profession that) {
        return String.format("Инженер %s сконструировал для %sа модель по чертежу.", getName(), that.getName());
    }
}