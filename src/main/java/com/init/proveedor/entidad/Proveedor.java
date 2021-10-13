package com.init.proveedor.entidad;

import javax.persistence.*;


import com.fasterxml.jackson.core.sym.Name;

@Entity
@Table(name = "datodeuda")
public class Proveedor {
	
	@Id
	@Column(name = "iddatodeuda")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddatodeuda;

	@Column(name = "monto", nullable = false, length = 100)
	private String monto;
	
	@Column(name = "status", nullable = false, length = 200)
	private String status;
	
	@Column(name = "usuario", nullable = false, length = 200)
	private String usuario;

	public Long getIddatodeuda() {
		return iddatodeuda;
	}

	public void setIddatodeuda(Long iddatodeuda) {
		this.iddatodeuda = iddatodeuda;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
