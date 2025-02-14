package br.com.mysalles.mysalles_plataform.main;

import java.util.Scanner;

public class Main {
    private final Scanner read = new Scanner(System.in);

    public void showMenu(){
        System.out.println("""
                1- Adicionar venda
                2- Adicionar cliente
                3- Adicionar fornecedor
                4- Adicionar produto
                
                Escolha uma das opções acima:
                """);
        int option = read.nextInt();

//        switch (option){
//            case 1:
//
//                break;
//        }
    }
}
