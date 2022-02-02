package br.com.alura.microservice.fornecedor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    
    @GetMapping
    public String message() {
        return FornecedorController.class.getSimpleName();
    }
}
