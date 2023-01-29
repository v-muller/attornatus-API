package com.restapi.attornatus.controllers;

import com.restapi.attornatus.services.PessoaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }
}
