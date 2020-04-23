package br.com.smartIrrigation.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smartIrrigation.bean.Parameters;
import br.com.smartIrrigation.service.ParametersService;

@RestController
@RequestMapping("/rest")
public class ParametersRestController {
	
	@Autowired
	private ParametersService parametersService;
	
	@GetMapping("/parameters")
	public String getParameters() {
		String myReturn = "";
		
		Parameters parameters = parametersService.findById(1);
		myReturn += parameters.getIrrigate()+",";
		myReturn += parameters.getCriticalHumidity()+",";
		myReturn += parameters.getMilliseconds()+"";
		
		return myReturn;
	}
}
