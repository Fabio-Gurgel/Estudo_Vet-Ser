package vet.ser.api.paciente;

import jakarta.validation.ValidationException;
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
        this.validarDadosAntesDeCadastrar(dadosParaCadastro);
        return repository.save(new Paciente(dadosParaCadastro));
    };

    public void validarDadosAntesDeCadastrar(DadosCadastroPaciente dadosParaCadastro) {
        String mensagemDeDadosNulos = "Envie os dados do paciente para concluir o cadastro";
        if (dadosParaCadastro != null) {
            this.validarEmail(dadosParaCadastro.tutor().tutorEmail());
            this.validarCpf(dadosParaCadastro.tutor().tutorCpf());
        } else {
            throw new ValidationException(mensagemDeDadosNulos);
        }
    }

    private void validarEmail(String email) {
        String mensagemDeEmailInvalido = "Email já cadastrado em outro paciente";
        if (repository.existsByTutorEmail(email)) {
            throw new ValidationException(mensagemDeEmailInvalido);
        }
    }

    private void validarCpf(String cpf) {
        String mensagemDeCpfInvalido = "Cpf já cadastrado em outro paciente";
        if (repository.existsByTutorCpf(cpf)) {
            throw new ValidationException(mensagemDeCpfInvalido);
        }
    }
}
