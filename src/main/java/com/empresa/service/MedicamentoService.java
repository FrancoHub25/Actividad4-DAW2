package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {

	public abstract Medicamento insertaActualizaMedicamento(Medicamento obj);
	public abstract List<Medicamento> listaMedicamento();
	public abstract Optional<Medicamento> buscarPorId(int idMedicamento);
	public abstract List<Medicamento> consultaNombre(String nombre);
	public abstract List<Medicamento> buscarPorStock(int stk);
	
	
}
