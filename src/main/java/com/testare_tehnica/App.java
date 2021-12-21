package com.testare_tehnica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        Database database = Database.getInstance("jdbc:sqlite:database");

        Reader reader = new BufferedReader(new FileReader("initialize-database.sql"));

        database.initializeData(reader);
    }
}