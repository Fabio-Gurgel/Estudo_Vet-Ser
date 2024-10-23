package vet.ser.api.veterinario;

public record DadosListagemVeterinario(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemVeterinario(Veterinario veterinario) {
        this(veterinario.getNome(), veterinario.getEmail(), veterinario.getCrm(), veterinario.getEspecialidade());
    }
}
