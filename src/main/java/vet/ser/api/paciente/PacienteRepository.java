package vet.ser.api.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    boolean existsByTutorEmail(String email);

    boolean existsByTutorCpf(String cpf);
}
