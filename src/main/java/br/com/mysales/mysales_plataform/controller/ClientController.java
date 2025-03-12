package br.com.mysales.mysales_plataform.controller;

import br.com.mysales.mysales_plataform.dto.ClientDTO;
import br.com.mysales.mysales_plataform.model.Client;
import br.com.mysales.mysales_plataform.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> list(){
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientDTO> listId(@PathVariable Long id){
        return ResponseEntity.ok(service.listId(id));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@RequestBody Client client, UriComponentsBuilder uriBuilder){
        var clientDTO = service.create(client);
        var uri = uriBuilder.path("/client/{id}").buildAndExpand(clientDTO.id()).toUri();
        return ResponseEntity.created(uri).body(clientDTO);
    }

    @PutMapping
    public ResponseEntity<ClientDTO> update(@RequestBody Client client){
        return ResponseEntity.ok(service.update(client));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
