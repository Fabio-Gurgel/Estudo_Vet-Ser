package vet.ser.api.tutor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import vet.ser.api.endereco.DadosEndereco;

public record DadosTutor(
        @NotBlank
        String tutorNome,

        @NotBlank
        @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
        String tutorCpf,

        @NotBlank
        @Email
        String tutorEmail,

        @NotBlank
        String tutorTelefone,

        @NotNull
        @Valid
        DadosEndereco tutorEndereco
) {
}

