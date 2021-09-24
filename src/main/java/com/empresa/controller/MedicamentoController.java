package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;
import com.empresa.util.Constantes1;

@RestController
@RequestMapping("/rest/medicamento")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentoController {

	@Autowired
	private MedicamentoService servcie;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listarMedicamento() {
		List<Medicamento> lista = servcie.listaMedicamento();
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamento> buscarPorId(@PathVariable("paramId") int idMedicamento) {
		Optional<Medicamento> optMedicamento = servcie.buscarPorId(idMedicamento);
		if(optMedicamento.isPresent()) {
			return ResponseEntity.ok(optMedicamento.get());
		} else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@GetMapping("/stk/{paramStk}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> buscarPorStock(@PathVariable("paramStk") int stk) {
		List<Medicamento> lista = servcie.buscarPorStock(stk);
		if(CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/nombre/{paramNombre}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> consultaNombre(@PathVariable("paramNombre") String nombre) {
		List<Medicamento> lista = servcie.consultaNombre(nombre);
		if(CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok(lista);
		}
		
	}
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaMedicamento(@RequestBody Medicamento obj){
		
		Map<String, Object> salida = new HashMap<>();
		try {
			
			Medicamento objSalida = servcie.insertaActualizaMedicamento(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes1.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes1.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes1.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
}
