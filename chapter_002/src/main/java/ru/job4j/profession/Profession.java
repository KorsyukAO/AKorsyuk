package ru.job4j.profession;

/**
 *Задание: 1. Реализация профессий в коде [#6837].
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com).
 *@since 28.01.2018
 *@version 0.1
 */
public class Profession {
    private String name;
    private int age;
    private String birthData;
    private String diploma;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getBirthData() {
        return birthData;
    }
    public String getDiploma() {
        return diploma;
    }

    public Profession(String name, int age, String birthData, String diploma) {
        this.name = name;
        this.age = age;
        this.birthData = birthData;
        this.diploma = diploma;
    }
}
