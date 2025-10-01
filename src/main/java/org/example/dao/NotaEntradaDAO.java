package org.example.dao;

import org.example.model.NotaEntrada;
import org.example.util.Conexao;

import java.sql.*;
import java.time.LocalDateTime;

public class NotaEntradaDAO {
    public void cadastarrEntrada(NotaEntrada notaEntrada)throws SQLException{
        String query = "INSERT INTO NotaEntrada (" +
                "                                idFornecedor, " +
                "                                dataEntrada ) " +
                "               VALUES " +
                "               (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, notaEntrada.getIdFornecedor());
            stmt.setTimestamp(2, Timestamp.valueOf(notaEntrada.getDataEntrada()));


            stmt.executeUpdate();
        }
    }





}
