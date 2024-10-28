package vet.ser.api.veterinario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    // paginação:
    // ?page=0
    // ?size=10
    // ?sort=nome,desc
    @GetMapping
    public Page<DadosListagemVeterinario> listar(Pageable paginacao) {
        return service.listar(paginacao);
    }
}
