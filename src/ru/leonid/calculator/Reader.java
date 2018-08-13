package ru.leonid.calculator;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import static java.util.Objects.requireNonNull;

class Reader {
    private final String exitCommand;
    private final Scanner scanner;

    Reader(Scanner scanner, String exitCommand) {
        this.scanner = scanner;
        this.exitCommand = exitCommand;
    }

    ReadResult read() {
        final int firstArgument = parseInt(requireNonNull(readInput()));
        final int secondArgument = parseInt(requireNonNull(readInput()));
        final String operator = requireNonNull(readInput());
        return new ReadResult(firstArgument, secondArgument, operator);
    }

    private String readInput() {
        final String input = scanner.nextLine();

        if (input.equals(exitCommand)) {
            exit(1);
            throw new IllegalStateException("We should exit before this line will be executed");
        } else {
            return input;
        }
    }
}
