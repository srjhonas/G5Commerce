package com.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.modelo.cliente;

@Repository
public interface ClienteRepository extends JpaRepository<cliente, Integer> {
	


}
