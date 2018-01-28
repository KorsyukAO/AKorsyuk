package ru.job4j.profession;

public class Engineer extends Profession {
    public Engineer(String name, int age, String birthData, String diploma) {
        super(name, age, birthData, diploma);
    }
    public String constructModel(Profession that) {
        return "Инженер " + getName() + " сконструировал для " + that.getName() + "а модель по чертежу.";
    }
}