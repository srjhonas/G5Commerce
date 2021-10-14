package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.modelo.venta;

public interface VentaRepository extends JpaRepository<venta, Integer> {

}
