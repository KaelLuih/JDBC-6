package org.example.dao;

import org.example.model.Fornecedor;
import org.example.model.Material;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class MaterialDAO {

    public void cadastrarMaterial(Material material)throws SQLException {
        String  query = "INSERT INTO Material(" +
                "                               nome," +
                "                               unidade," +
                "                               estoque " +
                "           )" +
                "VALUES" +
                "(?,?,?)";
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1,material.getNome());
            stmt.setString(2,material.getUnidade());
            stmt.setDouble(3,material.getQuantidade());
            stmt.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException duplicacao){
            System.out.println("NãO pode repetir materials");
            duplicacao.getMessage();
        }


    }


}
