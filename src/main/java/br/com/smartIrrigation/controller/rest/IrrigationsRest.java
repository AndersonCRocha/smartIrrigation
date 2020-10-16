package br.com.smartIrrigation.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smartIrrigation.bean.Irrigations;
import br.com.smartIrrigation.bean.Parameters;
import br.com.smartIrrigation.service.IrrigationsService;

@RestController
@RequestMapping("/rest/irrigations")
public class IrrigationsRest {
	
	@Autowired
	private IrrigationsService irrigationsService;

	@GetMapping
	public ResponseEntity<List<Irrigations>> listIrrigations() {
		return ResponseEntity.ok(irrigationsService.findTop5ByOrderByIdDesc());
	}
	
	@PostMapping
	public ResponseEntity<Long> save(@RequestBody Irrigations irrigation) {
		return new ResponseEntity<Long>(irrigationsService.saveOrUpdate(irrigation).getId(), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Parameters> update(@RequestBody Irrigations irrigation) {
		return ResponseEntity.ok(irrigationsService.updateReading(irrigation));
	}
	
}