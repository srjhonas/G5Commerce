package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.modelo.usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<usuario, Integer>{

}
