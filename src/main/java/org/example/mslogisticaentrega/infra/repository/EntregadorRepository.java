package org.example.mslogisticaentrega.infra.repository;

import org.example.mslogisticaentrega.domain.entity.EntregadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadorRepository extends JpaRepository<EntregadorEntity, Integer> {
}
