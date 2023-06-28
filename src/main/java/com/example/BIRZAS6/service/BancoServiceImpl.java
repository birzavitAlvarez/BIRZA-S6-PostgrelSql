package com.example.BIRZAS6.service;
import com.example.BIRZAS6.entity.Banco;
import com.example.BIRZAS6.repository.BancoRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BancoServiceImpl implements BancoService{

    @Autowired
    private BancoRepository bancoRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Banco> findAll() {
        return bancoRepository.findAll();
    }

    @Override
    public Optional<Banco> findById(Integer id) {
        return bancoRepository.findById(id);
    }

    @Override
    public void save(Banco banco) {
        bancoRepository.save(banco);
    }

    @Override
    public void deleteById(Integer id) {
        bancoRepository.deleteById(id);
    }
    
}