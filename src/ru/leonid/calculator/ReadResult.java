package ru.leonid.calculator;

public class ReadResult {
    private final int firstArgument;
    private final int secondArgument;
    private final String operator;

    ReadResult(int firstArgument, int secondArgument, String operator) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
        this.operator = operator;
    }

    int getFirstArgument() {
        return firstArgument;
    }

    int getSecondArgument() {
        return secondArgument;
    }

    String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return "ReadResult{" +
                "firstArgument=" + firstArgument +
                ", secondArgument=" + secondArgument +
                ", operator='" + operator + '\'' +
                '}';
    }
}
