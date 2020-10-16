package br.com.smartIrrigation.controller.template;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.smartIrrigation.service.IrrigationsService;

@Controller
public class ReadingsController {

	@Autowired
	private IrrigationsService readingsService;

	@GetMapping({ "/readings", "" })
	public ModelAndView openReadingPanel(HttpServletRequest request,
			@RequestParam(name = "deleteAll", required = false) boolean deleteAll) {
		return readingsService.openReadingPanel(request, deleteAll);
	}

}