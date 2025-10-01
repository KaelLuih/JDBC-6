package org.example.service;

import org.example.dao.FornecedorDAO;
import org.example.dao.MaterialDAO;
import org.example.dao.NotaEntradaDAO;
import org.example.model.Fornecedor;
import org.example.model.Material;
import org.example.model.NotaEntrada;
import org.example.model.Requisicao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Gerenciamento {

 static Scanner input = new Scanner(System.in);

    public void cadastrarFornecedor() throws SQLException {
        System.out.println("Digite o nome do fornecedor");
        String nome = input.nextLine();

        System.out.println("Digite o cnpj ");
        String cnpj = input.nextLine();


        var fornecedor = new Fornecedor(nome,cnpj);
        var fornecedorDAO = new FornecedorDAO();

        if(!nome.isEmpty() ||  !cnpj.isEmpty()){
            fornecedorDAO.cadastrarfornecedor(fornecedor);
        }else {
            System.out.println("Não pode deixar vazio");
        }

    }
    public void CadastarMaterial()throws SQLException{
        System.out.println("Digite o nome do material");
        String nome = input.nextLine();
        System.out.println("Digite a unidade de medida Ex.: kg, m, peça ");
        String unidade = input.nextLine();
        System.out.println("digite a quantidade de material no estoque");
        double quantidade = input.nextDouble();


        Material material = new Material(nome,unidade,quantidade);
        var materialDAO = new MaterialDAO();

        if (!nome.isEmpty()){
            if(quantidade >= 0){
                materialDAO.cadastrarMaterial(material);
            }else{
                System.out.println("A quantidade no estoque deve ser no minimo maior que zero");
            }
        }else {
            System.out.println("O nome de digitado não pode ficar vazio");
        }


    }
    public void RegistrarNotaEntrega()throws SQLException{
        var forecedorDAO = new FornecedorDAO();
        List<Fornecedor> listarFornecedores = forecedorDAO.ListarFornecedores();
        List<Integer> Verificacao = new ArrayList<>();

        listarFornecedores.forEach(fornecedor -> {
            System.out.println("Id" + fornecedor.getId());
            System.out.println("Nome" + fornecedor.getNome());
            System.out.println("CNPJ" + fornecedor.getCnpj());
        });


        System.out.println("Digite o id do Fornecedor");
        int id = input.nextInt();
        input.nextLine();

        int indiceFornecedor =Verificacao.indexOf(id);

        Fornecedor fornecedorEscolhido = listarFornecedores.get(indiceFornecedor);

        if(fornecedorEscolhido.getId() > 0){
            LocalDateTime data = LocalDateTime.now();


            NotaEntrada notaEntrada = new NotaEntrada(id,data);
            var NotaEntradaDAO = new NotaEntradaDAO();
            NotaEntradaDAO.cadastarrEntrada(notaEntrada);
            System.out.println("Sucesso ao cadastrar");
        }else{
            System.out.println("Não foi ´possivel realizar nao existe esse fornecedor");
        }

    }


}
