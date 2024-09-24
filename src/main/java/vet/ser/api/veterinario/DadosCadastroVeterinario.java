package vet.ser.api.veterinario;

import vet.ser.api.endereco.DadosEndereco;

public record DadosCadastroVeterinario(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
