package com.example.BIRZAS6.service;
import com.example.BIRZAS6.entity.Moneda;
import com.example.BIRZAS6.repository.MonedaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MonedaServiceImpl implements MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Moneda> findAll() {
        return monedaRepository.findAll();
    }

    @Override
    public Optional<Moneda> findById(Integer id) {
        return monedaRepository.findById(id);
    }

    @Override
    public void save(Moneda moneda) {
        monedaRepository.save(moneda);
    }

    @Override
    public void deleteById(Integer id) {
        monedaRepository.deleteById(id);
    }
    
}
