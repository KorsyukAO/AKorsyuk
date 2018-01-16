package ru.job4j.calculator;

/**
 * class Calculator решение задачи 2.3. Элементарный калькулятор.
 * @autor Alexandr Korsyuk (Korsyuk@gmail.com)
 * @since 16.01.2018
 * @version 0.1
 */
public class Calculator {
    private double result;

    /**
     * Method add.
     * @param ferst -  value.
     * @param second -  value.
     */
    public void add(double ferst, double second) {
        this.result = ferst + second;
    }

    /**
     * Method subtract.
     * @param ferst -  value.
     * @param second -  value.
     */
    public void subtract(double ferst, double second) {
        this.result = ferst - second;
    }

    /**
     * Method div.
     * @param ferst -  value.
     * @param second -  value.
     *
     */
    public void div(double ferst, double second) {
        this.result = ferst / second;
    }

    /**
     * Method multiple.
     * @param ferst -  value.
     * @param second -  value.
     */
    public void multiple(double ferst, double second) {
        this.result = ferst * second;
    }

    /**
     * Method getResult.
     * @return result.
     */
    public double getResult() {
        return this.result;
    }
}
