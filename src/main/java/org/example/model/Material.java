package org.example.model;

public class Material {

    private int id ;
    private String nome;
    private String unidade;
    private double quantidade;

    public Material(int id, String nome, String unidade, double quantidade) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.quantidade = quantidade;
    }

    public Material(String nome, String unidade, double quantidade) {
        this.nome = nome;
        this.unidade = unidade;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
