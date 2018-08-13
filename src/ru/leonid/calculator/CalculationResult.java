package ru.leonid.calculator;

public class CalculationResult {
    private final int result;

    CalculationResult(int result) {
        this.result = result;
    }

    int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "CalculationResult{" +
                "result=" + result +
                '}';
    }
}
