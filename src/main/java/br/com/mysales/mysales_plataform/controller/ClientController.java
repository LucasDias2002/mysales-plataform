package br.com.mysales.mysales_plataform.controller;

import br.com.mysales.mysales_plataform.dto.ClientDTO;
import br.com.mysales.mysales_plataform.model.Client;
import br.com.mysales.mysales_plataform.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping
    public List<ClientDTO> list(){
        return service.list();
    }

    @PostMapping
    public ClientDTO create(@RequestBody Client client){
        return service.create(client);
    }

    @PutMapping
    public ClientDTO update(@RequestBody Client client){
        return service.update(client);
    }

    @DeleteMapping("{id}")
    public ClientDTO delete(@PathVariable Long id){
        return service.delete(id);
    }
}
