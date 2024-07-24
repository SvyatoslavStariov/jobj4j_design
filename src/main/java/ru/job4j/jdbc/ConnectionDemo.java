package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

    private final static String URL = "hibernate.connection.url";

    private final static String LOGIN = "hibernate.connection.username";

    private final static String PASSWORD = "hibernate.connection.password";

    private final static String DRIVER = "hibernate.connection.driver_class";

    private final static String PATH_PROPERTY = "data/app.properties";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Config config = new Config(PATH_PROPERTY);
        config.load();
        Class.forName(config.value(DRIVER));
        try (Connection connection = DriverManager.getConnection(config.value(URL), config.value(LOGIN), config.value(PASSWORD))) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}