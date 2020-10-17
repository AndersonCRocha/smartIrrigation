package br.com.smartIrrigation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.smartIrrigation.bean.Irrigations;
import br.com.smartIrrigation.bean.Parameters;
import br.com.smartIrrigation.repository.IrrigationsRepository;
import br.com.smartIrrigation.util.GenericService;

@Service
public class IrrigationsService implements GenericService<Irrigations, Long> {

	@Autowired
	private IrrigationsRepository irrigationsRepository;
	@Autowired
	private ParametersService parametersService;

	@Override
	public Irrigations saveOrUpdate(Irrigations bean) {
		return irrigationsRepository.saveAndFlush(bean);
	}

	@Override
	public List<Irrigations> findAll() {
		return irrigationsRepository.findAll();
	}

	@Override
	public Irrigations findById(Long id) {
		return irrigationsRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Irrigations bean) {
		irrigationsRepository.delete(bean);
	}

	@Override
	public void deleteById(Long id) {
		irrigationsRepository.deleteById(id);
	}

	public List<Irrigations> findTop5ByOrderByIdDesc() {
		return irrigationsRepository.findTop5ByOrderByIdDesc();
	}

	public void deleteAll() {
		irrigationsRepository.deleteAll();
	}

	public ModelAndView openReadingPanel(HttpServletRequest request, boolean deleteAll) {
		if (deleteAll == true) {
			this.deleteAll();
		}

		Parameters parameters = parametersService.getParameters();
		request.setAttribute("parameters", parameters);

		List<Irrigations> readings = this.findTop5ByOrderByIdDesc();
		return new ModelAndView("readingPanel", "readings", readings);
	}

	public Parameters updateReading(Irrigations reading) {
		return parametersService.getParameters();
	}

}