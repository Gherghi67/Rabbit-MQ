package com.testare_tehnica.produs;

public class Produs {
    private int id_produs;
    private int stoc;

    private String nume_produs;

    public Produs() {
        this.id_produs = 0;
        this.stoc = 0;
        this.nume_produs = null;
    }

    public Produs(int id_produs, int stoc, String nume_produs) {
        this.id_produs = id_produs;
        this.stoc = stoc;
        this.nume_produs = nume_produs;
    }

    public int getIdProdus() {
        return this.id_produs;
    }

    public void setIdProdus(int id_produs) {
        this.id_produs = id_produs;
    }

    public int getStoc() {
        return this.stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public String getNumeProdus() {
        return this.nume_produs;
    }

    public void setNumeProdus(String nume_produs) {
        this.nume_produs = nume_produs;
    }
}
