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
    public List<ClientDTO> listClients(){
        return service.listClients();
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client newClient = service.saveClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
    }
}
