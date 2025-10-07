package org.example.dao;

import org.example.model.Material;
import org.example.model.Requisicao;
import org.example.util.Conexao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RequisicaoDAO {
    public void CriarRequisicao(Requisicao requisicao)throws SQLException {
        String query = "INSERT INTO Requisicao (" +
                "   setor, " +
                "   dataSolicitacao, " +
                "   status" +
                ") VALUES (?,?,?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, requisicao.getSetor());
            stmt.setTimestamp(2, Timestamp.valueOf(requisicao.getDataSolicitacao()));
            stmt.setString(3, requisicao.getStatus());

            stmt.executeUpdate();
        }
    }
    public List<Requisicao> listarRequisicoes()throws SQLException{
        List<Requisicao> requisicaos = new ArrayList<>();
        String query = "SELECT id , setor , dataSolicitacao " +
                "FROM Requisicao" +
                " WHERE status = 'PENDENTE'";
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String setor = rs.getString("setor");
                LocalDateTime dataSolicitacao = rs.getTimestamp("dataSolicitacao").toLocalDateTime();
            }
        }


        return requisicaos;
    }
    public int Ultimoid()throws SQLException {
        String query = "SELECT id FROM Requisicao ORDER BY id DESC LIMIT 1";
        int ultimoID = -1;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ultimoID = rs.getInt("id");

            }
        }
        return ultimoID;
    }
    public void AtualizarPendente(int id)throws SQLException{
        String query = """
                UPDATE Requisicao
                SET status = 'ATENDIDA'
                WHERE id = ?
                
                """;
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }


}
