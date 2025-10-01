package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NotaEntrada {

    private int id;
    private int idFornecedor;
    private LocalDateTime dataEntrada;


    public NotaEntrada(int id, int idFornecedor, LocalDateTime dataEntrada) {
        this.id = id;
        this.idFornecedor = idFornecedor;
        this.dataEntrada = dataEntrada;
    }

    public NotaEntrada(int idFornecedor, LocalDateTime dataEntrada) {
        this.idFornecedor = idFornecedor;
        this.dataEntrada = dataEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}
