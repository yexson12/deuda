package com.init.proveedor.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.proveedor.entidad.Proveedor;

public interface ProveedorDAO extends JpaRepository<Proveedor, Long> {
	
}
