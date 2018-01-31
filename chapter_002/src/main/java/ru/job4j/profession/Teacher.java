package ru.job4j.profession;

public class Teacher extends Profession {
    public Teacher(String name, int age, String birthData, String diploma) {
        super(name, age, birthData, diploma);
    }
    public String teachStudents(Profession that) {
        return String.format("Учитель %s учит %sа.", getName(), that.getName());
    }
}
