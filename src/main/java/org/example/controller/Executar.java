package org.example.controller;

import org.example.service.Gerenciamento;
import org.example.view.Menu;

import java.sql.SQLException;

public class Executar {

    Menu menu = new Menu();
    Gerenciamento executar = new Gerenciamento();
    public void executarSistema()throws SQLException{
        boolean sair = false;
        while(!sair){
        int menuPrincipal = menu.MenuPrincipal();

        switch (menuPrincipal){
            case 1: {
                executar.cadastrarFornecedor();
                break;
            }
            case 2:{
             executar.CadastarMaterial();
             break;
            }
            case 3:{
                executar.RegistrarNotaEntrega();
                break;
            }
            case 4:{
                executar.CriarRequisiçãodeMaterial();
                break;
            }
            case 5:{
                executar.AtenderRequisicao();
            }


        }





        }

    }

}
