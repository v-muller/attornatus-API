package com.restapi.attornatus.controllers;

import com.restapi.attornatus.services.EnderecoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }
}
