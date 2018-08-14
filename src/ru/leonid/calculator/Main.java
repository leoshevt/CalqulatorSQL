package ru.leonid.calculator;

import java.io.IOException;

import java.util.Scanner;

public class Main {
    private  static String EXIT_COMMAND;
    private  static String URL;
    private  static String USERNAME;
    private  static String PASSWORD;

    public static void main(String[] args) throws IOException {
        EXIT_COMMAND= initSQLconfig().loading().getProperty("EXIT_COMMAND");
        URL = initSQLconfig().loading().getProperty("URL");
        USERNAME = initSQLconfig().loading().getProperty("USERNAME");
        PASSWORD = initSQLconfig().loading().getProperty("PASSWORD");
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
    private static LoadSQLCongig initSQLconfig(){
        return new LoadSQLCongig();
    }
}
