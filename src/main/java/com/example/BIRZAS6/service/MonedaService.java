package com.example.BIRZAS6.service;
import com.example.BIRZAS6.entity.Moneda;

import java.util.*;

public interface MonedaService {
    public List<Moneda> findAll();
    public Optional<Moneda> findById(Integer id);
	public void save(Moneda moneda);
	public void deleteById(Integer id); 
}