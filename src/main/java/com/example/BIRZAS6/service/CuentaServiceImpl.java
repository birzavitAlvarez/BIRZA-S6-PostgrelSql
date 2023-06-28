package com.example.BIRZAS6.service;
import com.example.BIRZAS6.entity.Cuenta;
import com.example.BIRZAS6.repository.CuentaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService {
    
    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    @Override
    public Optional<Cuenta> findById(Integer id) {
        return cuentaRepository.findById(id);
    }

    @Override
    public void save(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    @Override
    public void deleteById(Integer id) {
        cuentaRepository.deleteById(id);
    }

}
