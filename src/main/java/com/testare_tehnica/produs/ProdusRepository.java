package com.testare_tehnica.produs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.testare_tehnica.handlers.Database;

public class ProdusRepository {
    private static ProdusRepository produsRepository = null;

    private Connection connection;

    private ProdusRepository() {
        Database database = Database.getInstance();

        this.connection = database.getConnection();
    }

    public static ProdusRepository getInstance() {
        if (produsRepository == null) {
            produsRepository = new ProdusRepository();
        }

        return produsRepository;
    }

    public Produs findOne(int id_produs) {
        String sql = "SELECT * FROM produs WHERE id_produs = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setInt(1, id_produs);

            ResultSet resultSet = preparedStatement.executeQuery();

            Produs produs = new Produs();

            while(resultSet.next()) {
               produs.setIdProdus(resultSet.getInt("id_produs"));
               produs.setStoc(resultSet.getInt("stoc"));
               produs.setNumeProdus(resultSet.getString("nume_produs"));
            }

            if (produs.getIdProdus() == 0) {
                System.out.println("Produsul cu id-ul " + id_produs + " nu a fost gasit");

                return null;
            }

            return produs;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    public Produs updateStoc(int id_produs, int stoc) {
        String sql = "UPDATE produs SET stoc = ? WHERE id_produs = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setInt(1, stoc);
            preparedStatement.setInt(2, id_produs);

            int rowCount = preparedStatement.executeUpdate();

            if (rowCount == 0) {
                System.out.println("Produsul cu id-ul " + id_produs + " nu a fost gasit");

                return null;
            }

            this.connection.commit();

            return this.findOne(id_produs);
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }
}
