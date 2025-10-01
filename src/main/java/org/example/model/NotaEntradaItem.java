package org.example.model;

public class NotaEntradaItem {
    private int id;
    private int idMaterial;
    private double quantidade;

    public NotaEntradaItem(int id, int idMaterial, double quantidade) {
        this.id = id;
        this.idMaterial = idMaterial;
        this.quantidade = quantidade;
    }

    public NotaEntradaItem(int idMaterial, double quantidade) {
        this.idMaterial = idMaterial;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
