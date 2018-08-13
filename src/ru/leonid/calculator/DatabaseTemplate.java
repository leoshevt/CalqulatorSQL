package ru.leonid.calculator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

class DatabaseTemplate {
    private static final String SQL_INSERT = "INSERT INTO calc VALUES(?, ?, ?, ?)";
    private final DatabaseConfiguration configuration;
    private final PreparedStatement insertStatement;

    DatabaseTemplate(DatabaseConfiguration configuration) {
        this.configuration = configuration;
        final Connection connection = connect();
        try {
            this.insertStatement = connection.prepareStatement(SQL_INSERT);
        } catch (SQLException e) {
            throw new RuntimeException("Error while creating insert statement");
        }
    }

    void persist(ReadResult readResult, CalculationResult calculationResult) {
        try {
            insertStatement.setInt(1, readResult.getFirstArgument());
            insertStatement.setInt(2, readResult.getSecondArgument());
            insertStatement.setString(3, readResult.getOperator());
            insertStatement.setInt(4, calculationResult.getResult());
            insertStatement.executeUpdate();
            System.out.println("Data persisted to database");
        } catch (SQLException e) {
            throw new RuntimeException("Error while persisting calculation result to database");
        }
    }

    private Connection connect() {
        loadDriver();
        try {
            return getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException("Error while trying connect to database");
        }
    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error while loading driver");
        }
    }
}
