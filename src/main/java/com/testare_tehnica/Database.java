package com.testare_tehnica;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.ibatis.jdbc.ScriptRunner;

// class to manage the connection to the database
public class Database {
    private static Database database = null;

    private static Connection connection;

    private Database(String connectionString) {
        try {
            Class.forName("org.sqlite.JDBC");
    
            connection = DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    
        System.out.println("Opened database successfully");
    }

    public static Database getInstance(String connectionString) {
        if (database == null) {
            database= new Database(connectionString);
        }

        return database;
    }

    public void initializeData(Reader reader) {
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setEscapeProcessing(false);
        scriptRunner.runScript(reader);
    }

    public static Connection getConnection() {
        return connection;
    }
}
