package br.com.mysales.mysales_plataform.controller;

import br.com.mysales.mysales_plataform.dto.SaleDTO;
import br.com.mysales.mysales_plataform.dto.SupplierDTO;
import br.com.mysales.mysales_plataform.model.Supplier;
import br.com.mysales.mysales_plataform.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService service;

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> list(){
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("{id}")
    public ResponseEntity<SupplierDTO> listId(@PathVariable Long id){
        return ResponseEntity.ok(service.listId(id));
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> create(@Valid @RequestBody Supplier supplier, UriComponentsBuilder uriBuilder) {
        var supplierDTO = service.create(supplier);
        var uri = uriBuilder.path("/supplier/{id}").buildAndExpand(supplierDTO.id()).toUri();
        return ResponseEntity.created(uri).body(supplierDTO);
    }

    @PutMapping
    public ResponseEntity<SupplierDTO> update(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(service.update(supplier));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
