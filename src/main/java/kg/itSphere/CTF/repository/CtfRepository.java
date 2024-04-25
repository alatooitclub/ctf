package kg.itSphere.CTF.repository;

import kg.itSphere.CTF.dto.CtfRequest;
import kg.itSphere.CTF.entities.Ctf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CtfRepository extends JpaRepository<Ctf, Long>{
    Optional<Ctf> findByName(String name);
}
