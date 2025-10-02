package org.example.dao;

import org.example.model.RequisicaoItem;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequisicaoItemDAO {
    public void CadastrarRequisicaoItem(RequisicaoItem requisicaoItem)throws SQLException {
        String query = "INSERT INTO RequisicaoItem(" +
                "                                  idRequisicao ," +
                "                                  idMaterial ," +
                "                                  quantidade )" +
                "VALUES" +
                "(?,?,?)  ";
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,requisicaoItem.getIdrequisicao());
            stmt.setInt(2,requisicaoItem.getIdMaterial());
            stmt.setDouble(3,requisicaoItem.getQuantidade());
        stmt.executeUpdate();

        }



    }






}
