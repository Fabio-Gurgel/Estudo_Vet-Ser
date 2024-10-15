package vet.ser.api.veterinario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    boolean existsByEmail(String email);

    boolean existsByCrm(String crm);
}
