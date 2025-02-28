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
    public SaleDTO create(@RequestBody Sale sale){
        return service.create(sale);
    }

    @PutMapping
    public SaleDTO update(@RequestBody Sale sale){
        return service.update(sale);
    }

    @DeleteMapping("{id}")
    public SaleDTO update(@PathVariable Long id){
        return service.delete(id);
    }
}
