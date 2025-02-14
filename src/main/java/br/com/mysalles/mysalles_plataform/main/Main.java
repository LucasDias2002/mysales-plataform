package br.com.mysalles.mysalles_plataform.main;

import br.com.mysalles.mysalles_plataform.model.Client;
import br.com.mysalles.mysalles_plataform.repository.RepositoryClient;

import java.util.Scanner;

public class Main {
    private final Scanner read = new Scanner(System.in);
    RepositoryClient repositoryClient;

    public Main(RepositoryClient repositoryClient) {
        this.repositoryClient = repositoryClient;
    }

    public void showMenu(){

        System.out.println("""
                \n********** MENU ***********
                
                1- Adicionar venda
                2- Adicionar cliente
                3- Adicionar fornecedor
                4- Adicionar produto
                
                ********** MENU ***********
                
                Escolha uma das opções acima:
                """);
        int option = read.nextInt();

        switch (option){
            case 1:

                break;
        }
    }
}
