package com.pucpralunos.abrigo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pucpralunos.abrigo.dao.CachorroDAO;
import com.pucpralunos.abrigo.models.Cachorro;

@RestController
@RequestMapping("/cachorros")
public class CachorroController {
    private CachorroDAO cachorroDAO = new CachorroDAO();
    
    public CachorroController() {}

    @GetMapping("/cadastrar")
    public void CadastrarCachorro(@RequestParam String nome, @RequestParam String raca) {
        cachorroDAO.addCachorro(nome,raca);
    }

    @GetMapping("/listar")
    public List<Cachorro> listarCachorros() {
        List<Cachorro> cachorros = cachorroDAO.listarCachorros(); 
        return cachorros;
    }
}
