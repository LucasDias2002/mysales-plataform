package br.com.mysales.mysales_plataform.controller;

import br.com.mysales.mysales_plataform.dto.SaleDTO;
import br.com.mysales.mysales_plataform.model.Sale;
import br.com.mysales.mysales_plataform.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    SaleService service;

    @GetMapping
    public List<SaleDTO> list(){
       return service.list();
    }

    @PostMapping
    public List<SaleDTO> create(@RequestBody Sale sale){
        service.create(sale);
        return service.list();
    }

    @PutMapping
    public List<SaleDTO> update(@RequestBody Sale sale){
        service.update(sale);
        return service.list();
    }

    @DeleteMapping("{id}")
    public List<SaleDTO> update(@PathVariable Long id){
        service.delete(id);
        return service.list();
    }
}
