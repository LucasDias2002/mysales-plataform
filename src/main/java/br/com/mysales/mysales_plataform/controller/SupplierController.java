package br.com.mysales.mysales_plataform.controller;

import br.com.mysales.mysales_plataform.model.Supplier;
import br.com.mysales.mysales_plataform.repository.RepositorySupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    RepositorySupplier repository;

    @GetMapping
    public List<Supplier> ListSupplier(){
        return repository.findAll();
    }
}
