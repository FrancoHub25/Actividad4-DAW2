package com.empresa.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {

	@Query("select m from Medicamento m where m.nombre Like :param_nombre")
	public List<Medicamento> consultarNombreLike(@Param("param_nombre") String nombre);
	
	public abstract List<Medicamento> findByStock(int stk);
}
