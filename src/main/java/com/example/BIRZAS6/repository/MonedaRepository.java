package com.example.BIRZAS6.repository;
import com.example.BIRZAS6.entity.Moneda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository extends JpaRepository <Moneda, Integer> {
}
