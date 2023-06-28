package com.example.BIRZAS6.service;
import com.example.BIRZAS6.entity.Banco;

import java.util.*;

public interface BancoService {
    public List<Banco> findAll();
    public Optional<Banco> findById(Integer id);
	public void save(Banco banco);
	public void deleteById(Integer id);
}