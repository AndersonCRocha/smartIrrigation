package br.com.smartIrrigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.smartIrrigation.bean.Parameters;

public interface ParametersRepository extends JpaRepository<Parameters, Integer>{

}
