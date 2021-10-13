package com.init.proveedor.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.proveedor.DAO.ProveedorDAO;
import com.init.proveedor.entidad.Proveedor;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/")
public class ProveedorREST {
	
	@Autowired
	private ProveedorDAO proveedorDAO;
	
	@GetMapping
	@RequestMapping(value = "mostrar" , method = RequestMethod.GET)
	public String mostrar() {
		String res;
		res = "Publicando servicio Basico";
		return res;
	}
	
	@RequestMapping(value = "proveedor" , method = RequestMethod.GET)
	public ResponseEntity<Proveedor> getProveedor(){
		
		Proveedor proveedor = new Proveedor();
		proveedor.setIddatodeuda(1L);
		proveedor.setMonto("12");
		proveedor.setStatus("admin");
		proveedor.setUsuario("software y hadware");
		
		return ResponseEntity.ok(proveedor);
	} 
	
	@RequestMapping(value = "deudas" , method = RequestMethod.GET)
	public ResponseEntity<List<Proveedor>> getProveedores() {
		
		List<Proveedor> proveedores = proveedorDAO.findAll();
		return ResponseEntity.ok(proveedores);
	}
	
	@RequestMapping(value = "proveedores/{proveedorId}" , method = RequestMethod.GET)
	public ResponseEntity<Proveedor> getProveedorById(@PathVariable("proveedorId") Long proveedorId) {
		
		Optional<Proveedor> optionalProveedor = proveedorDAO.findById(proveedorId);
		
		if (optionalProveedor.isPresent()) {
			return ResponseEntity.ok(optionalProveedor.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	@RequestMapping(value = "deuddas" , method = RequestMethod.POST)
	public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor){
		Proveedor nuevoProveedor = proveedorDAO.save(proveedor);
		return ResponseEntity.ok(nuevoProveedor);
	}
	
	@PostMapping
	@RequestMapping(value = "eliminar/{proveedorId}" , method = RequestMethod.DELETE)
	public ResponseEntity<Proveedor> crearProveedor(@PathVariable("proveedorId") Long proveedorId){
		proveedorDAO.deleteById(proveedorId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	@RequestMapping(value = "actualizar" , method = RequestMethod.PUT)
	public ResponseEntity<Proveedor> actualizarProveedor(@RequestBody Proveedor proveedor) {
		
		Optional<Proveedor> optionalProveedor = proveedorDAO.findById(proveedor.getIddatodeuda());
		
		if (optionalProveedor.isPresent()) {
			Proveedor actualizarProveedor = optionalProveedor.get();
			actualizarProveedor.setMonto(proveedor.getMonto());
			actualizarProveedor.setStatus(proveedor.getStatus());
			actualizarProveedor.setUsuario(proveedor.getUsuario());
			
			proveedorDAO.save(actualizarProveedor);
			return ResponseEntity.ok(actualizarProveedor);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
}



