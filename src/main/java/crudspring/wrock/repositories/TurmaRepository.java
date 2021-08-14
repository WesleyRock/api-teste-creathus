package crudspring.wrock.repositories;

import crudspring.wrock.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}