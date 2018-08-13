package ru.leonid.calculator;

class Calculator {
    CalculationResult calculate(ReadResult readResult) {
        switch (readResult.getOperator()) {
            case "+":
                return new CalculationResult(sum(readResult.getFirstArgument(), readResult.getSecondArgument()));
            case "-":
                return new CalculationResult(deduct(readResult.getFirstArgument(), readResult.getSecondArgument()));
            case "*":
                return new CalculationResult(multiply(readResult.getFirstArgument(), readResult.getSecondArgument()));
            case "/":
                return new CalculationResult(divide(readResult.getFirstArgument(), readResult.getSecondArgument()));
            default:
                throw new IllegalArgumentException("Operator should be one of \" + , - , *, / \"");
        }
    }

    private int sum(int a, int b) {
        return a + b;
    }

    private int deduct(int a, int b) {
        return a + b;
    }

    private int multiply(int a, int b) {
        return a + b;
    }

    private int divide(int a, int b) {
        return a + b;
    }
}
