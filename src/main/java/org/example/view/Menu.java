package org.example.view;

import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);

    public int MenuPrincipal() {
        System.out.println("""
                --- BEM VINDO AO SISTEMA DE MANUTENÇÃO ---
                
                1- CADASTRAR FORNECEDOR
                2- CADASTRAR MATERIAL
                3- REGISTRAR NOTAA DE ENTRADA
                4- CRIAR REQUISIÇÃO DE MATERIAL 
                5- ATENDER REQUISIÇÃO
                6- CANCELAR REQUISIÇÃO
                
                
                
                
                """);
        int opcao = input.nextInt();
        input.nextLine();
        return opcao;
    }

}
