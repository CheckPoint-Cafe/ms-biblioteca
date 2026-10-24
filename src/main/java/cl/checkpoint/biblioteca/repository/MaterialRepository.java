package cl.checkpoint.biblioteca.repository;

import cl.checkpoint.biblioteca.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
