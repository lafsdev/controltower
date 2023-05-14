package io.controltower.repository;

import io.controltower.entity.Rota;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RotasRepository extends JpaRepository<Rota,Long> {
    List<Rota> findAll(Sort sort);
}
