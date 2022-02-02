package br.com.alura.microservice.loja.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loja")
public class LojaController {
    
    @GetMapping
    public String message() {
        return LojaController.class.getSimpleName();
    }
}
