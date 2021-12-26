package com.testare_tehnica.handlers;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;

// class to handle the connection to the database
public class Database {
    private static Database database = null;

    private Connection connection;

    private static final String CONNECTION_STRING = "jdbc:sqlite:database";

    private Database() {
        try {
            Class.forName("org.sqlite.JDBC");
    
            this.connection = DriverManager.getConnection(CONNECTION_STRING);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    
        System.out.println("Opened database successfully");
    }

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }

        return database;
    }

    public void initializeData(Reader reader) {
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setEscapeProcessing(false);
        scriptRunner.runScript(reader);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
