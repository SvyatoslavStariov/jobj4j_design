package ru.job4j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        if (connection != null) {
            return;
        }
        Class.forName(properties.getProperty("driver_class"));
        this.connection = DriverManager.getConnection(
            properties.getProperty("url"),
            properties.getProperty("username"),
            properties.getProperty("password")
        );
    }

    public void createTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("CREATE TABLE IF NOT EXISTS %s(%s);", tableName, "id SERIAL PRIMARY KEY");
            statement.executeUpdate(sql);
        }
    }

    public void dropTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("DROP TABLE IF EXISTS %s", tableName);
            statement.executeUpdate(sql);
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE IF EXISTS %s ADD %s %s;", tableName, columnName, type);
            statement.executeUpdate(sql);
        }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE %s DROP COLUMN %s;", tableName, columnName);
            statement.executeUpdate(sql);
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE %s RENAME COLUMN %s to %s;", tableName, columnName, newColumnName);
            statement.executeUpdate(sql);
        }
    }

    public String getTableScheme(String tableName) throws SQLException {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            if (connection.getMetaData().getTables(null, null, tableName, null).next()) {
                var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
                ));
                var metaData = selection.getMetaData();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                    );
                }
                return buffer.toString();
            }
        }
        return String.format("The table %s does not exist", tableName);
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
