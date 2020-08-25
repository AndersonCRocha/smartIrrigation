package br.com.smartIrrigation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smartIrrigation.bean.Parameters;
import br.com.smartIrrigation.repository.ParametersRepository;
import br.com.smartIrrigation.util.GenericService;

@Service
public class ParametersService implements GenericService<Parameters, Integer> {

	@Autowired
	private ParametersRepository parametersRepository;

	@Override
	public Parameters saveOrUpdate(Parameters bean) {
		bean.setId(1);
		return parametersRepository.saveAndFlush(bean);
	}

	@Override
	public List<Parameters> findAll() {
		return parametersRepository.findAll();
	}

	@Override
	public Parameters findById(Integer id) {
		return parametersRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Parameters bean) {
		parametersRepository.delete(bean);
	}

	@Override
	public void deleteById(Integer id) {
		parametersRepository.deleteById(id);
	}

	public Parameters getParameters() {
		return findById(1);
	}

}