package br.com.mysales.mysales_plataform;

import br.com.mysales.mysales_plataform.main.Main;
import br.com.mysales.mysales_plataform.repository.RepositoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysallesPlataformApplication implements CommandLineRunner {

	@Autowired
	RepositoryClient repositoryClient;

	public static void main(String[] args) {
		SpringApplication.run(MysallesPlataformApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repositoryClient);
		main.showMenu();
	}
}
