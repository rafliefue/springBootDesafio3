package com.spring.nttdata.desafio3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.nttdata.desafio3.entities.Cliente;


@Repository
public interface GestionClientesRepository extends JpaRepository<Cliente, Integer> {

}
