package org.example.service;

import org.example.dao.FornecedorDAO;
import org.example.dao.MaterialDAO;
import org.example.dao.NotaEntradaDAO;
import org.example.dao.NotaEntradaItemDAO;
import org.example.model.*;

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
        System.out.println("Digite o nome do fornecedor:");
        String nome = input.nextLine();

        System.out.println("Digite o cnpj:");
        String cnpj = input.nextLine();

        if (!nome.trim().isEmpty() && !cnpj.trim().isEmpty()) {

            var fornecedorDAO = new FornecedorDAO();

            if (fornecedorDAO.verificarCnpj(cnpj)) {
                System.out.println("\n Erro: Este CNPJ já está cadastrado no sistema.");
            } else {

                var fornecedor = new Fornecedor(nome, cnpj);
                fornecedorDAO.cadastrarfornecedor(fornecedor);
                System.out.println("\nFornecedor cadastrado com sucesso!");
            }

        } else {
            System.out.println("Atenção: O nome e o CNPJ não podem ser vazios.");
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
                System.out.printf("\n Material cadastrado com sucesso");
            }else{
                System.out.println("A quantidade no estoque deve ser no minimo maior que zero");
            }
        }else {
            System.out.println("O nome de digitado não pode ficar vazio");
        }


    }
    public void RegistrarNotaEntrega()throws SQLException {
        boolean sair = false;
        var forecedorDAO = new FornecedorDAO();
        List<Fornecedor> listarFornecedores = forecedorDAO.ListarFornecedores();
        var materialDAO = new MaterialDAO();
        List<Integer> Verificação = new ArrayList<>();
        List<Material> listarMAterial = materialDAO.ListarMaterial();

        listarFornecedores.forEach(fornecedor -> {
            System.out.println("Id: " + fornecedor.getId());
            System.out.println("___________");
            System.out.println("Nome: " + fornecedor.getNome());
            System.out.println("___________");
            System.out.println("CNPJ :" + fornecedor.getCnpj());
            System.out.println("___________");
        });


        System.out.println("\nDigite o id do Fornecedor");
        int id = input.nextInt();
        input.nextLine();


        LocalDateTime data = LocalDateTime.now();


        NotaEntrada notaEntrada = new NotaEntrada(id, data);
        var NotaEntradaDAO = new NotaEntradaDAO();
        NotaEntradaDAO.cadastarrEntrada(notaEntrada);
        System.out.println("Sucesso ao cadastrar");

        while (!sair) {
            listarMAterial.forEach(material -> {
                System.out.println("ID: " + material.getId());
                System.out.println("___________");
                System.out.println("NOME: " + material.getNome());
                System.out.println("___________");
                System.out.println("UNIDADE: " + material.getUnidade());
                System.out.println("___________");
                System.out.println("QUANTIDADE: " + material.getQuantidade());
            });

            System.out.println("\nDigite o id do material que deseja associar");
            int idMaterial = input.nextInt();
            input.nextLine();


            Material materialEscolhido = null;


            for (Material material : listarMAterial) {

                if (material.getId() == idMaterial) {

                    materialEscolhido = material;

                    break;
                }
            }


            if (materialEscolhido != null) {

                System.out.println("Digite a quantidade que está entrando no estoque:");
                double estoque = input.nextDouble();
                input.nextLine();


                if (estoque >= 0) {
                    var notaentradaitemDAO = new NotaEntradaItemDAO();
                    var notaentrdaitem = new NotaEntradaItem(id, idMaterial, estoque);
                    notaentradaitemDAO.CadastrarNotaEntradaItem(notaentrdaitem);
                    System.out.println("Material " + materialEscolhido.getNome() + " associado com sucesso.");
                    System.out.println("Deseja cadastar mais um 1-sim 2-não");
                    int escolha = input.nextInt();
                    if (escolha == 1){
                        sair = false;
                    }else {
                        sair = true;

                    }
                } else {
                    System.out.println("Quantidade no estoque deve ser maior que 0");

                }

            } else {
                System.out.println("ERRO: Material com ID " + idMaterial + " não foi encontrado!");
            }
        }
    }
    public void CriarRequisiçãodeMaterial()throws SQLException{
        var materialDAO = new MaterialDAO();
        List<Material> listarMAterial = materialDAO.ListarMaterial();

        System.out.println("Digite o setor da requisição");
        String setor;
        listarMAterial.forEach(material -> {
            System.out.println("ID: " + material.getId());
            System.out.println("___________");
            System.out.println("NOME: " + material.getNome());
            System.out.println("___________");
            System.out.println("UNIDADE: " + material.getUnidade());
            System.out.println("___________");
            System.out.println("QUANTIDADE: " + material.getQuantidade());
        });
        System.out.println("Selecione um id");
        int escolha = input.nextInt();
        input.nextLine();






    }


}
