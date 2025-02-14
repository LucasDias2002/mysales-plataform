package br.com.mysalles.mysalles_plataform.repository;

import br.com.mysalles.mysalles_plataform.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySale extends JpaRepository<Sale, Long> {
}
