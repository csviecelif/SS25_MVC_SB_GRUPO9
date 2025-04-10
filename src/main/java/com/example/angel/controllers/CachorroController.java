package com.example.angel.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.angel.dao.CachorroDAO;
import com.example.angel.models.Cachorro;


@RestController
@RequestMapping("/cachorros")
public class CachorroController {
    private CachorroDAO cachorroDAO = new CachorroDAO();
    
    public CachorroController() {}

    @GetMapping("/cadastrar")
    public Cachorro CadastrarCachorro(@RequestParam String nome, @RequestParam String raca) {
        cachorroDAO.addCachorro(nome,raca);
        return new Cachorro(nome, raca);
    }

    @GetMapping("/listar")
    public List<Cachorro> listarCachorros() {
        return cachorro.DAO.istarCachorros();
    }
}
