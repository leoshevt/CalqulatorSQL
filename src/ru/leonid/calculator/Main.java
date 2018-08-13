package ru.leonid.calculator;

import java.util.Scanner;

public class Main {
    private final static String EXIT_COMMAND = "exit";
    private final static String URL = "jdbc:mysql://localhost:3306/calc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";

    public static void main(String[] args) {
        final Reader reader = initReader();
        final Calculator calculator = initCalculator();
        final DatabaseTemplate databaseTemplate = initDatabase(new DatabaseConfiguration(URL, USERNAME, PASSWORD));

        new CalculatorBusinessLogic(reader, calculator, databaseTemplate).work();
    }

    private static Reader initReader() {
        return new Reader(new Scanner(System.in), EXIT_COMMAND);
    }

    private static Calculator initCalculator() {
        return new Calculator();
    }

    private static DatabaseTemplate initDatabase(DatabaseConfiguration databaseConfiguration) {
        return new DatabaseTemplate(databaseConfiguration);
    }
}
