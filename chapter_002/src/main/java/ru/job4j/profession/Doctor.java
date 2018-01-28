package ru.job4j.profession;

public class Doctor extends Profession {
    public Doctor(String name, int age, String birthData, String diploma) {
        super(name, age, birthData, diploma);
    }

    public String diagnoseHeal(Profession that) {
       return "Доктор " + getName() + " лечит " + that.getName() + "а.";
    }
}
