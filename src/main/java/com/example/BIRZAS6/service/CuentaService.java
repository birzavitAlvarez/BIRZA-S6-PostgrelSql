package com.example.BIRZAS6.service;
import com.example.BIRZAS6.entity.Cuenta;

import java.util.*;

public interface CuentaService {
    public List<Cuenta> findAll();
	public Optional<Cuenta> findById(Integer id);
	public void save(Cuenta cuenta);
	public void deleteById(Integer Id); 
}
