package vet.ser.api.veterinario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    VeterinarioRepository repository;

    @PostMapping
    public void cadastrar(DadosCadastroVeterinario dados) {
        repository.save(new Veterinario(dados));
    }
}
