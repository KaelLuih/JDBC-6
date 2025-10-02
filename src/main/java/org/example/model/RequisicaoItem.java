package org.example.model;

public class RequisicaoItem {
    private int idrequisicao;
    private int idMaterial;
    private double quantidade;


    public RequisicaoItem(int idrequisicao, int idMaterial, double quantidade) {
        this.idrequisicao = idrequisicao;
        this.idMaterial = idMaterial;
        this.quantidade = quantidade;
    }

    public int getIdrequisicao() {
        return idrequisicao;
    }

    public void setIdrequisicao(int idrequisicao) {
        this.idrequisicao = idrequisicao;
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
