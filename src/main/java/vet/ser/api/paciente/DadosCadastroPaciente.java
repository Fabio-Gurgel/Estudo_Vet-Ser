package vet.ser.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import vet.ser.api.endereco.DadosEndereco;
import vet.ser.api.endereco.Endereco;
import vet.ser.api.tutor.DadosTutor;
import vet.ser.api.tutor.Tutor;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,

        @NotBlank
        String animal,

        @NotBlank
        String raca,
        String pelagem,
        String observacao,

        @NotNull
        @Valid
        DadosTutor tutor
) {
}
