package org.example.dao;

import org.example.model.Fornecedor;
import org.example.model.Material;
import org.example.model.NotaEntradaItem;
import org.example.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<Material> ListarMaterial()throws SQLException{
        List <Material> materials = new ArrayList<>();

        String query = "SELECT" +
                " id," +
                "nome," +
                "unidade," +
                "estoque" +
                " FROM Material " +
                "";
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String unidade = rs.getString("unidade");
                double estoque = rs.getDouble("estoque");
                var material = new Material(id,nome,unidade,estoque);
                materials.add(material);
            }
        }
        return materials;
    }
    public void atualizarQuantidade(double quantidade) throws SQLException{
      String  query = """
            UPDATE Material
            SET estoque = estoque + ?
            WHERE id = ?
            """;
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setDouble(1, notaEntradaItem.getQuantidade());
            stmt.setInt(2, material.getId());
            stmt.executeUpdate();
        }
    }


}
