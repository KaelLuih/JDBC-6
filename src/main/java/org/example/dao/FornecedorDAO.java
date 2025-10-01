package org.example.dao;

import org.example.model.Fornecedor;
import org.example.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public void cadastrarfornecedor(Fornecedor fornecedor)throws SQLException{
        String  query = "INSERT INTO Fornecedor(" +
                "                               nome," +
                "                               cnpj " +
                "           )" +
                "VALUES" +
                "(?,?)";
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1,fornecedor.getNome());
            stmt.setString(2,fornecedor.getCnpj());
            stmt.executeUpdate();

        }


    }

    public boolean verificarCnpj(String cnpj) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Fornecedor WHERE cnpj = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            return rs.getInt(1) > 0;


        }
    }



    public List<Fornecedor> ListarFornecedores()throws SQLException{
        List <Fornecedor> fornecedores = new ArrayList<>();

        String query = "SELECT" +
                " id," +
                "nome," +
                "cnpj" +
                " FROM Fornecedor " +
                "";
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
             int id = rs.getInt("id");
             String nome = rs.getString("nome");
             String cnpj = rs.getString("cnpj");
                var Fornecedores = new Fornecedor(id,nome,cnpj);
                fornecedores.add(Fornecedores);
            }
        }
        return fornecedores;
    }


}
