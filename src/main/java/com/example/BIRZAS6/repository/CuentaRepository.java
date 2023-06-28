package com.example.BIRZAS6.repository;
import com.example.BIRZAS6.entity.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository <Cuenta, Integer> {
}
