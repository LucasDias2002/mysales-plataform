package br.com.mysales.mysales_plataform.controller;

import br.com.mysales.mysales_plataform.dto.SupplierDTO;
import br.com.mysales.mysales_plataform.model.Supplier;
import br.com.mysales.mysales_plataform.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService service;

    @GetMapping
    public List<SupplierDTO> list(){
        return service.list();
    }

    @PostMapping
    public List<SupplierDTO> create(@RequestBody Supplier supplier) {
        return service.create(supplier);
    }

    @PutMapping
    public List<SupplierDTO> update(@RequestBody Supplier supplier) {
        return service.update(supplier);
    }

    @DeleteMapping("{id}")
    public List<SupplierDTO> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
