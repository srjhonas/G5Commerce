package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.modelo.proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<proveedor, Integer> {

}
