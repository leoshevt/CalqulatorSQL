package ru.leonid.calculator;

class CalculatorBusinessLogic {
    private final Reader reader;
    private final Calculator calculator;
    private final DatabaseTemplate databaseTemplate;

    CalculatorBusinessLogic(Reader reader, Calculator calculator, DatabaseTemplate databaseTemplate) {
        this.reader = reader;
        this.calculator = calculator;
        this.databaseTemplate = databaseTemplate;
    }

    void work() {
        sayHelloToTheClient();

        while(true) {
            final ReadResult readResult = reader.read();
            final CalculationResult calculationResult = calculator.calculate(readResult);

            printToConsole(calculationResult);
            databaseTemplate.persist(readResult, calculationResult);
        }
    }

    private void printToConsole(CalculationResult calculationResult) {
        System.out.println(calculationResult);
    }

    private void sayHelloToTheClient() {
        System.out.println("Welcome to calculator");
        System.out.println("To start working, press enter and write: number, number, operator");
        System.out.println("If you want exit, write: exit");
    }
}
