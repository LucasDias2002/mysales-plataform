package br.com.mysalles.mysalles_plataform.repository;

import br.com.mysalles.mysalles_plataform.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryClient extends JpaRepository<Client, Long> {

}
