package ru.leonid.calculator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadSQLCongig {
    public Properties loading() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Пантелей\\IdeaProjects\\CalqulatorSQL\\src\\ru\\leonid\\calculator\\prop.properties");
        properties.load(fileInputStream);
        return properties;

    }
}
