package br.com.smartIrrigation.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smartIrrigation.bean.Readings;
import br.com.smartIrrigation.service.ReadingsService;

@RestController
@RequestMapping("/rest/readings")
public class ReadingsRest {
	
	@Autowired
	private ReadingsService readingsService;

	@GetMapping
	public ResponseEntity<List<Readings>> listReadings() {
		return ResponseEntity.ok(readingsService.findTop5ByOrderByIdDesc());
	}
	
	@PostMapping
	public ResponseEntity<Readings> save(@RequestBody Readings reading) {
		return new ResponseEntity<Readings>(readingsService.saveOrUpdate(reading), HttpStatus.CREATED);
	}
	
}