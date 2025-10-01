package org.example.dao;

import org.example.model.NotaEntradaItem;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotaEntradaItemDAO {
    public void CadastrarNotaEntradaItem(NotaEntradaItem notaEntradaItem)throws SQLException{
        String query = "INSERT INTO NotaEntradaItem (idNotaEntrada, idMaterial, quantidade) VALUES (?, ?, ?)";
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,notaEntradaItem.getidNotaEntrada());
            stmt.setInt(2,notaEntradaItem.getIdMaterial());
            stmt.setDouble(3,notaEntradaItem.getQuantidade());
            stmt.executeUpdate();

        }


    }




    }


