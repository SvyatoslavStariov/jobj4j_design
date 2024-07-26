package ru.job4j.jdbc;

import java.io.InputStream;
import java.util.Properties;

public class StatementDemo {

    private final static String TABLE = "idea_db";

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (InputStream in = StatementDemo.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
        }
        try (TableEditor tableEditor = new TableEditor(properties)) {
            tableEditor.createTable(TABLE);
            System.out.printf("Create table:\n%s", tableEditor.getTableScheme(TABLE));
            tableEditor.addColumn(TABLE, "name", "varchar(255)");
            System.out.printf("Add column:\n%s", tableEditor.getTableScheme(TABLE));
            tableEditor.renameColumn(TABLE, "name", "first_name");
            System.out.printf("Rename column:\n%s", tableEditor.getTableScheme(TABLE));
            tableEditor.dropColumn(TABLE, "first_name");
            System.out.printf("Drop column:\n%s", tableEditor.getTableScheme(TABLE));
            tableEditor.dropTable(TABLE);
            System.out.printf("Drop table:\n%s", tableEditor.getTableScheme(TABLE));
        }
    }
}
