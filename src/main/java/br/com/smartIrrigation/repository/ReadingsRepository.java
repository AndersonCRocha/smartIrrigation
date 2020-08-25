package br.com.smartIrrigation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.smartIrrigation.bean.Readings;

public interface ReadingsRepository extends JpaRepository<Readings, Long>{

	public List<Readings> findTop5ByOrderByIdDesc();
}
