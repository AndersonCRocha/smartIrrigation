package br.com.smartIrrigation.controller.template;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.smartIrrigation.bean.Parameters;
import br.com.smartIrrigation.bean.Readings;
import br.com.smartIrrigation.service.ParametersService;
import br.com.smartIrrigation.service.ReadingsService;

@Controller
public class ReadingsController {

	@Autowired
	private ReadingsService readingsService;
	@Autowired
	private ParametersService parametersService;

	@GetMapping({ "/readings", "" })
	public ModelAndView openReadingPanel(HttpServletRequest request,
			@RequestParam(name = "deleteAll", required = false) boolean deleteAll) {

		if (deleteAll == true) {
			readingsService.deleteAll();
		}
		Parameters parameters = parametersService.getParameters();

		request.setAttribute("parameters", parameters);
		List<Readings> listReadings = readingsService.findTop5ByOrderByIdDesc();

		return new ModelAndView("readingPanel", "listReadings", listReadings);
	}

}
