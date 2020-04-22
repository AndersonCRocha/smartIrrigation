package br.com.smartIrrigation.controller.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.smartIrrigation.bean.ReceivedByArduino;
import br.com.smartIrrigation.service.ReceivedByArduinoService;

@Controller
@RequestMapping("")
public class ReceivedByArduinoTemplateController {
	
	@Autowired
	private ReceivedByArduinoService receivedByArduinoService;
	
	@GetMapping({"/ReadingPanel", ""})
	public ModelAndView openReadingPanel() {
		
		List<ReceivedByArduino> listReadings = receivedByArduinoService.findTop5ByOrderByIdDesc();
		
		return new ModelAndView("readingPanel", "listReadings", listReadings);
	}
	
}
