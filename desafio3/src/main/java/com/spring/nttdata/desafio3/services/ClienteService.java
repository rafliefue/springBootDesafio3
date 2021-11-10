package com.spring.nttdata.desafio3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.nttdata.desafio3.entities.Cliente;
import com.spring.nttdata.desafio3.repository.ClienteRepository;

@Service
public class ClienteService{

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(final ClienteRepository anuncioRepository) {
        this.clienteRepository = anuncioRepository;
    }

    
    @Transactional
    public Cliente findByName(String name) {
    	return this.clienteRepository.findByName(name);
    }
    
    @Transactional
    public Cliente findByLastName(String lastName) {
    	return this.clienteRepository.findByLastName(lastName);
    }
    
 
    @Transactional
    public  Cliente findByNameAndLastName(String name, String lastName) {
    	return this.clienteRepository.findByNameAndLastName(name, lastName);
    }

}
