package vet.ser.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.ser.api.endereco.Endereco;
import vet.ser.api.tutor.Tutor;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String animal;
    private Integer idade;
    private String raca;
    private String pelagem;
    private String observacao;

    @Embedded
    private Tutor tutor;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.animal = dados.animal();
        this.idade = dados.idade();
        this.raca = dados.raca();
        this.pelagem = dados.pelagem();
        this.observacao = dados.observacao();
        this.tutor = new Tutor(dados.tutor());
    }
}
