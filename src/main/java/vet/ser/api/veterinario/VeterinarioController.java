package vet.ser.api.veterinario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    VeterinarioService service;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroVeterinario dadosParaCadastro) {
        service.cadastrar(dadosParaCadastro);
    }

    @GetMapping
    public List<DadosListagemVeterinario> listar() {
        return service.listar();
    }
}
