package br.com.mysales.mysales_plataform;

import br.com.mysales.mysales_plataform.main.Main;
import br.com.mysales.mysales_plataform.repository.RepositoryClient;
import br.com.mysales.mysales_plataform.repository.RepositoryProduct;
import br.com.mysales.mysales_plataform.repository.RepositorySupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//public class MysallesPlataformApplicationSemWeb implements CommandLineRunner {
//
//	@Autowired
//	RepositoryClient repositoryClient;
//	@Autowired
//	RepositorySupplier repositorySupplier;
//	@Autowired
//	RepositoryProduct repositoryProduct;
//
//	public static void main(String[] args) {
//		SpringApplication.run(MysallesPlataformApplicationSemWeb.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		Main main = new Main(repositoryClient, repositorySupplier, repositoryProduct);
//		main.showMenu();
//	}
//}
