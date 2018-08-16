package ru.leonid.calculator;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    private  static String EXIT_COMMAND;
    private  static String URL;
    private  static String USERNAME;
    private  static String PASSWORD;

    public static void main(String[] args) throws IOException {
        SQLconfig();
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
    private static void SQLconfig() throws IOException {
        Properties config = initSQLconfig().loading();
        EXIT_COMMAND= config.getProperty("EXIT_COMMAND");
        URL = config.getProperty("URL");
        USERNAME = config.getProperty("USERNAME");
        PASSWORD = config.getProperty("PASSWORD");
    }
    private static LoadSQLConfig initSQLconfig(){
        return new LoadSQLConfig();
    }
}
