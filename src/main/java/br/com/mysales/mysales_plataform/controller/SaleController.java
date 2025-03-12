package br.com.mysales.mysales_plataform.controller;

import br.com.mysales.mysales_plataform.dto.SaleDTO;
import br.com.mysales.mysales_plataform.model.Sale;
import br.com.mysales.mysales_plataform.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    SaleService service;

    @GetMapping
    public ResponseEntity<List<SaleDTO>> list(){
       return ResponseEntity.ok(service.list());
    }

    @PostMapping
    public ResponseEntity<SaleDTO> create(@RequestBody Sale sale, UriComponentsBuilder uriBuilder){
        var saleDTO = service.create(sale);
        var uri = uriBuilder.path("/sale/{id}").buildAndExpand(saleDTO.client_id()).toUri();
        return ResponseEntity.created(uri).body(saleDTO);
    }

    @PutMapping
    public ResponseEntity<SaleDTO> update(@RequestBody Sale sale){
        return ResponseEntity.ok(service.update(sale));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
