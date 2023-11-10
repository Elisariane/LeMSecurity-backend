package com.example.lemsecurity.repository;

import com.example.lemsecurity.local.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<Local, Long> {
}
