package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.modelo.producto;

@Repository
public interface ProductoRepository extends JpaRepository<producto, Integer>{

}
