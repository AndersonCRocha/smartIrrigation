package br.com.smartIrrigation.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smartIrrigation.bean.Parameters;
import br.com.smartIrrigation.service.ParametersService;

@RestController
@RequestMapping("/rest/parameters")
public class ParametersRest {
	
	@Autowired
	private ParametersService parametersService;
	
	@GetMapping
	public ResponseEntity<Parameters> getParameters() {
		return ResponseEntity.ok(parametersService.getParameters());
	}
	
	@PostMapping
	public ResponseEntity<Parameters> save(Parameters parameters) {
		return new ResponseEntity<Parameters>(parametersService.saveOrUpdate(parameters), HttpStatus.CREATED);
	}
	
}