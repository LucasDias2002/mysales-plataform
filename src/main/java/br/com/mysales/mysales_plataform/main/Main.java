package br.com.mysales.mysales_plataform.main;

import br.com.mysales.mysales_plataform.model.Client;
import br.com.mysales.mysales_plataform.model.Product;
import br.com.mysales.mysales_plataform.model.Supplier;
import br.com.mysales.mysales_plataform.repository.RepositoryClient;
import br.com.mysales.mysales_plataform.repository.RepositoryProduct;
import br.com.mysales.mysales_plataform.repository.RepositorySupplier;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private final Scanner read = new Scanner(System.in);
    private final Scanner read2 = new Scanner(System.in);
    RepositoryClient repositoryClient;
    RepositorySupplier repositorySupplier;
    RepositoryProduct repositoryProduct;

    public Main(RepositoryClient repositoryClient, RepositorySupplier repositorySupplier, RepositoryProduct repositoryProduct) {
        this.repositoryClient = repositoryClient;
        this.repositorySupplier = repositorySupplier;
        this.repositoryProduct = repositoryProduct;
    }

    public void showMenu(){

        System.out.println("""
                \n********** MENU ***********
                
                1- Adicionar venda (EM ANDAMENTO)
                2- Adicionar cliente
                3- Adicionar fornecedor
                4- Adicionar produto
                
                5 - Listar vendas (EM ANDAMENTO)
                6 - Listar clientes
                7 - Listar fornecedores
                8 - Listar produtos por fornecedor
                
                ********** MENU ***********
                
                Escolha uma das opções acima:
                """);

        int option = read.nextInt();

        switch (option){
            case 1:
                AdicionarVenda();
                break;
            case 2:
                AdicionarCliente();
                break;
            case 3:
                AdicionarFornecedor();
                break;
            case 4:
                AdicionarProduto();
                break;
            case 6:
                ListarClientes();
                break;
            case 7:
                ListarFornecedores();
                break;
            case 8:
                ListarProdutosPorFornecedor();
                break;
        }
    }
    private void AdicionarVenda(){
        System.out.println("*******ESCOLHA O FORNECEDOR*******");
        ListarFornecedores();
        System.out.println("**********************************");
    }

    private void ListarClientes() {
        List<Client> clients = repositoryClient.findAll();
        System.out.println("**********CLIENTES*********\n");
        if(clients.isEmpty())
            System.out.println("Sem clientes cadastrados!");
        else
            clients.forEach(System.out::println);
        System.out.println("\n*************************");
    }

    private void AdicionarCliente(){
        System.out.println("Digite o nome do cliente: ");
        var name = read.next();

        System.out.println("Digite o contato: ");
        var contact = read.next();

        repositoryClient.save(new Client(name, contact));
        System.out.println("Cliente cadastrado!");
    }

    private void AdicionarFornecedor(){
        System.out.println("Digite o nome do fornecedor: ");
        var name = read.next();
        System.out.println("Digite o contato: ");
        var contact = read.next();
        System.out.println("Digite o email: ");
        var email = read.next();

        repositorySupplier.save(new Supplier(name, contact, email));
        System.out.println("Fornecedor cadastrado!");
    }

    private void AdicionarProduto(){
        System.out.println("Digite o nome do produto: ");
        var name = read.next();
        System.out.println("Digite o preço: ");
        var price = read2.nextDouble();
        System.out.println("Digite uma descrição: ");
        var description = read.next();

        ListarFornecedores();

        System.out.println("Digite o nome de um fornecedor: ");
        String nameSupplier = read2.next();
        var Supplier = repositorySupplier.findByNameIgnoreCaseContaining(nameSupplier);

        if(Supplier.isPresent()){
            repositoryProduct.save(new Product(name, price, description, Supplier.get()));
            System.out.println("Fornecedor cadastrado!");
        }
        else{
            System.out.println("Fornecedor não encontrado!");
        }
    }

    private void ListarFornecedores(){
        List<Supplier>fornecedoreEncontrados = repositorySupplier.findAll();
        if (fornecedoreEncontrados.isEmpty())
            System.out.println("Sem fornecedores cadastrados");
        else{
            fornecedoreEncontrados.forEach(f -> System.out.println("Nome: " + f.getName()));
        }
    }

    private void ListarProdutosPorFornecedor(){
        ListarFornecedores();
        System.out.println("Digite o nome do fornecedor: ");
        var name = read.next();
        Optional<List<Product>> produtosEncontrados = repositoryProduct.findBySupplier(repositorySupplier.findByNameIgnoreCaseContaining(name).get());
        if(produtosEncontrados.isPresent())
            produtosEncontrados.get().forEach(System.out::println);
        else{
            System.out.println("Nenhum produto encontrado!");
        }
    }
}
