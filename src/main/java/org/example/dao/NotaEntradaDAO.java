package org.example.dao;

import org.example.model.NotaEntrada;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class NotaEntradaDAO {
    public void cadastarrEntrada(NotaEntrada notaEntrada)throws SQLException{
        String query = """
                INSERT INTO Fornecedor( " 
                                        idFornecedor,"
                                        dataEntrada 
                                            )
                                VALUES" 
                                (?,?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, notaEntrada.getIdFornecedor());
            stmt.setDate(2, Date.valueOf(String.valueOf(notaEntrada.getDataEntrada())));


            stmt.executeUpdate();
        }
    }





}
