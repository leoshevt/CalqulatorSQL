package ru.leonid.calculator;

class DatabaseConfiguration {
    private final String url;
    private final String username;
    private final String password;

    DatabaseConfiguration(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    String getUrl() {
        return url;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}
