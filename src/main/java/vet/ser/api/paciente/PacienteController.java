package vet.ser.api.paciente;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vet.ser.api.veterinario.DadosCadastroVeterinario;
import vet.ser.api.veterinario.Veterinario;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService service;

    @PostMapping
    @Transactional
    public Paciente cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosParaCadastro) {
        return service.cadastrar(dadosParaCadastro);
    };
}
