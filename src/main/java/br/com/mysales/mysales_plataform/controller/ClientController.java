package br.com.mysales.mysales_plataform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/teste")
    public String Teste(){
        return "Testando Api no servidor!";
    }
    @GetMapping("/")
    public String Home(){
        return "Aqui será a homepage inicial!";
    }
}
