package com.example.BIRZAS6.repository;

import com.example.BIRZAS6.entity.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository <Banco, Integer> {
}
