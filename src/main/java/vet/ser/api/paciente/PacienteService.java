package vet.ser.api.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.ser.api.veterinario.DadosCadastroVeterinario;
import vet.ser.api.veterinario.Veterinario;
import vet.ser.api.veterinario.VeterinarioRepository;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository repository;

    public Paciente cadastrar(DadosCadastroPaciente dadosParaCadastro) {
        return repository.save(new Paciente(dadosParaCadastro));
    };
}
