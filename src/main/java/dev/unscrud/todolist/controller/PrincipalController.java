package dev.unscrud.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("principal")
public class PrincipalController {
   /**
    * Métodos de acesso HTTP
    * GET - buscar informação
    * POST - Adicionar informação
    * PUT - Alterar informação
    * DELETE - remover
    * PATCH - Alterar informação parcialmente 
    */
    @GetMapping("/")
    public String mensagem() {
        return "Controller testado";
    }
}
