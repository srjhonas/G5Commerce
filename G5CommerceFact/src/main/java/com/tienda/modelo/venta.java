package com.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="ventas")
public class venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_venta; 
	private Integer cedula_cliente;  
	private Integer cedula_usuario; 
	private Double ivaventa;  
	private Double total_venta; 
	private Double valor_venta;
	
	public venta(Integer codigo_venta, Integer cedula_cliente, Integer cedula_usuario, Double ivaventa,
			Double total_venta, Double valor_venta) {
		super();
		this.codigo_venta = codigo_venta;
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.ivaventa = ivaventa;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}

	public venta() {
		super();
	}

	public Integer getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Integer codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public Integer getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(Integer cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public Integer getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(Integer cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public Double getIvaventa() {
		return ivaventa;
	}

	public void setIvaventa(Double ivaventa) {
		this.ivaventa = ivaventa;
	}

	public Double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}

	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	} 
	
	
	
}


