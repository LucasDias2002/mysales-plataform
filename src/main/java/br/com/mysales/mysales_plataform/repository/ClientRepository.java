package br.com.mysales.mysales_plataform.repository;

import br.com.mysales.mysales_plataform.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByActiveTrue();
}
