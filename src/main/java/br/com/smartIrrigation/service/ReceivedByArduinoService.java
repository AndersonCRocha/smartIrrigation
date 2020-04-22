package br.com.smartIrrigation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smartIrrigation.bean.ReceivedByArduino;
import br.com.smartIrrigation.repository.ReceivedByArduinoRepository;
import br.com.smartIrrigation.util.GenericService;

@Service
public class ReceivedByArduinoService implements GenericService<ReceivedByArduino, Long>{

	@Autowired
	private ReceivedByArduinoRepository receivedByArduinoRepository;
	
	@Override
	public ReceivedByArduino saveOrUpdate(ReceivedByArduino bean) {
		return receivedByArduinoRepository.saveAndFlush(bean);
	}

	@Override
	public List<ReceivedByArduino> findAll() {
		return receivedByArduinoRepository.findAll();
	}

	@Override
	public ReceivedByArduino findById(Long id) {
		return receivedByArduinoRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(ReceivedByArduino bean) {
		receivedByArduinoRepository.delete(bean);
	}

	@Override
	public void deleteById(Long id) {
		receivedByArduinoRepository.deleteById(id);
	}
	
	public List<ReceivedByArduino> findTop5ByOrderByIdDesc(){
		return receivedByArduinoRepository.findTop5ByOrderByIdDesc();
	}
	
	public void deleteAll(){
		receivedByArduinoRepository.deleteAll();
	}
}
