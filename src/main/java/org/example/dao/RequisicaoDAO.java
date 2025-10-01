package org.example.dao;

import org.example.model.Requisicao;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequisicaoDAO {
    public void CriarRequisicao(Requisicao requisicao)throws SQLException {
        String query = "INSERT INTO Requisao(" +
                "                               setor, " +
                "                               dataSolicitacao ," +
                "                               status" +
                "           )" +
                "VALUES" +
                "(?,?,?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, requisicao.getSetor());
            stmt.setDate(2, Date.valueOf(requisicao.getDataSolicitacao()));
            stmt.setString(3, requisicao.getStatus());

            stmt.executeUpdate();
        }
    }

}
