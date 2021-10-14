package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.modelo.detalleVenta;

public interface DetalleVentaRepository extends JpaRepository<detalleVenta, Integer> {

}
