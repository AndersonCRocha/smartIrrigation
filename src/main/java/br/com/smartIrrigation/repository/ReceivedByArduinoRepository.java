package br.com.smartIrrigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.smartIrrigation.bean.ReceivedByArduino;

public interface ReceivedByArduinoRepository extends JpaRepository<ReceivedByArduino, Long>{

}
