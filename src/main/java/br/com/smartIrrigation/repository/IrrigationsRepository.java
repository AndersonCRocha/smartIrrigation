package br.com.smartIrrigation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.smartIrrigation.bean.Irrigations;

public interface IrrigationsRepository extends JpaRepository<Irrigations, Long>{

	public List<Irrigations> findTop5ByOrderByIdDesc();

}