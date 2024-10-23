package vet.ser.api.veterinario;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService {
    @Autowired
    VeterinarioRepository repository;

    public Veterinario cadastrar(DadosCadastroVeterinario dadosParaCadastro) {
        this.validarDadosAntesDeCadastrar(dadosParaCadastro);
        return repository.save(new Veterinario(dadosParaCadastro));
    };

    public List<DadosListagemVeterinario> listar() {
        return repository.findAll().stream().map(DadosListagemVeterinario::new).toList();
    }

    public void validarDadosAntesDeCadastrar(DadosCadastroVeterinario dadosParaCadastro) {
        String mensagemDeDadosNulos = "Envie os dados do veterinário para concluir o cadastro";
        if (dadosParaCadastro != null) {
            this.validarEmail(dadosParaCadastro.email());
            this.validarCrm(dadosParaCadastro.crm());
        } else {
            throw new ValidationException(mensagemDeDadosNulos);
        }
    }

    private void validarEmail(String email) {
        String mensagemDeEmailInvalido = "Email já cadastrado em outro veterinário";
        if (repository.existsByEmail(email)) {
            throw new ValidationException(mensagemDeEmailInvalido);
        }
    }

    private void validarCrm(String crm) {
        String mensagemDeCrmInvalido = "Crm já cadastrado em outro veterinário";
        if (repository.existsByCrm(crm)) {
            throw new ValidationException(mensagemDeCrmInvalido);
        }
    }
}
