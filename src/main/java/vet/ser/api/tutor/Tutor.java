package vet.ser.api.tutor;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.ser.api.endereco.Endereco;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {

    private String tutorNome;
    private String tutorCpf;
    private String tutorEmail;
    private String tutorTelefone;
    private Endereco tutorEndereco;

    public Tutor(DadosTutor dados) {
        this.tutorNome = dados.tutorNome();
        this.tutorCpf = dados.tutorCpf();
        this.tutorEmail = dados.tutorEmail();
        this.tutorTelefone = dados.tutorTelefone();
        this.tutorEndereco = new Endereco(dados.tutorEndereco());
    }
}

