package br.com.smartIrrigation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smartIrrigation.bean.Readings;
import br.com.smartIrrigation.repository.ReadingsRepository;
import br.com.smartIrrigation.util.GenericService;
import br.com.smartIrrigation.util.Utilities;

@Service
public class ReadingsService implements GenericService<Readings, Long>{

	@Autowired
	private ReadingsRepository readingsRepository;
	
	@Override
	public Readings saveOrUpdate(Readings bean) {
		bean.setVerificationTime(Utilities.now());
		return readingsRepository.saveAndFlush(bean);
	}

	@Override
	public List<Readings> findAll() {
		return readingsRepository.findAll();
	}

	@Override
	public Readings findById(Long id) {
		return readingsRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Readings bean) {
		readingsRepository.delete(bean);
	}

	@Override
	public void deleteById(Long id) {
		readingsRepository.deleteById(id);
	}
	
	public List<Readings> findTop5ByOrderByIdDesc(){
		return readingsRepository.findTop5ByOrderByIdDesc();
	}
	
	public void deleteAll(){
		readingsRepository.deleteAll();
	}
	
}
