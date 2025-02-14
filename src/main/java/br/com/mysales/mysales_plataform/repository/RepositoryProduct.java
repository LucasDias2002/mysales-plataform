package br.com.mysales.mysales_plataform.repository;

import br.com.mysales.mysales_plataform.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduct extends JpaRepository<Product, Long> {
}
