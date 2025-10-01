package org.example.model;

public class NotaEntradaItem {
    private int idNotaEntrada;
    private int idMaterial;
    private double quantidade;

    public NotaEntradaItem(int idNotaEntrada, int idMaterial, double quantidade) {
        this.idNotaEntrada = idNotaEntrada;
        this.idMaterial = idMaterial;
        this.quantidade = quantidade;
    }

    public NotaEntradaItem(int idMaterial, double quantidade) {
        this.idMaterial = idMaterial;
        this.quantidade = quantidade;
    }

    public int getidNotaEntrada() {
        return idNotaEntrada;
    }

    public void setId(int idNotaEntrada) {
        this.idNotaEntrada = idNotaEntrada;
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
