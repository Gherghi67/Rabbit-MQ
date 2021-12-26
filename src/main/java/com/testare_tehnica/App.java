package com.testare_tehnica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.testare_tehnica.handlers.Database;
import com.testare_tehnica.produs.ProdusRepository;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        Database database = Database.getInstance();

        Reader reader = new BufferedReader(new FileReader("initialize-database.sql"));

        database.initializeData(reader);

        ProdusRepository produsRepository = ProdusRepository.getInstance();

        produsRepository.updateStoc(1, 50);
        produsRepository.updateStoc(10, 100);

        database.closeConnection();
    }
}