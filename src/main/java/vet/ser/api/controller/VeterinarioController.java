package vet.ser.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vet.ser.api.veterinario.DadosCadastroVeterinario;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @PostMapping
    public void cadastrar(DadosCadastroVeterinario dados) {

    }
}
