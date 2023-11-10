package com.example.lemsecurity.repository;

import com.example.lemsecurity.domain.colaborador.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
