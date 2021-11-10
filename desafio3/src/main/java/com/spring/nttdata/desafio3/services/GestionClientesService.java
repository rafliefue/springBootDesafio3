package com.spring.nttdata.desafio3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.nttdata.desafio3.entities.Cliente;
import com.spring.nttdata.desafio3.repository.ClienteRepository;
import com.spring.nttdata.desafio3.repository.GestionClientesRepository;

@Service
public class GestionClientesService{

    private final GestionClientesRepository gestionClienteRepository;

    @Autowired
    public GestionClientesService(final GestionClientesRepository gestionClienteRepository) {
        this.gestionClienteRepository = gestionClienteRepository;
    }
    
    @Transactional
    public void save( Cliente cliente) {
        this.gestionClienteRepository.save(cliente);
    }
    
    @Transactional
    public  void delete( Cliente cliente) {
        this.gestionClienteRepository.delete(cliente);
    }
    
    @Transactional
    public void update( Cliente cliente) {
         this.gestionClienteRepository.save(cliente);
    }

    


}
