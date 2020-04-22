package br.com.smartIrrigation.controller.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.smartIrrigation.bean.ReceivedByArduino;
import br.com.smartIrrigation.service.ReceivedByArduinoService;

@Controller
@RequestMapping("")
public class ReceivedByArduinoTemplateController {
	
	@Autowired
	private ReceivedByArduinoService receivedByArduinoService;
	
	@GetMapping({"/ReadingPanel", ""})
	public ModelAndView openReadingPanel(@RequestParam(name="deleteAll", required = false) boolean deleteAll) {
		
		if(deleteAll == true) {
			receivedByArduinoService.deleteAll();
		}
		List<ReceivedByArduino> listReadings = receivedByArduinoService.findTop5ByOrderByIdDesc();
		
		return new ModelAndView("readingPanel", "listReadings", listReadings);
	}
	
}
