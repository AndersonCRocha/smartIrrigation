package br.com.smartIrrigation.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> getParameters() {
		String myReturn = "data:";
		
		Parameters parameters = parametersService.findById(1);
		if(parameters != null) {
			myReturn += parameters.getIrrigate() != null ? parameters.getIrrigate()+"," : ",";
			myReturn += parameters.getCriticalHumidity() != null ? parameters.getCriticalHumidity()+"," : ",";
			myReturn += parameters.getMilliseconds() != null ? parameters.getMilliseconds()+"" : "";
		}
		
		return new ResponseEntity<String>(myReturn, HttpStatus.OK);
	}
}
