package br.com.smartIrrigation.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.smartIrrigation.bean.Parameters;
import br.com.smartIrrigation.bean.ReceivedByArduino;
import br.com.smartIrrigation.service.ParametersService;
import br.com.smartIrrigation.service.ReceivedByArduinoService;
import br.com.smartIrrigation.util.Utilities;

@RestController
@RequestMapping("/rest")
public class ReceivedByArduinoRestController {
	
	@Autowired
	private ReceivedByArduinoService receivedByArduinoService;
	@Autowired
	private ParametersService parametersService;
	
	@GetMapping("/saveReading")
	public ResponseEntity<ReceivedByArduino> saveReading(
					@RequestParam(name = "humidity", required = true) Integer humidity,
					@RequestParam(name = "signalStrength", required = true) Integer signalStrength){
		
		ReceivedByArduino receivedByArduino;
		try {
			receivedByArduino = new ReceivedByArduino(Utilities.today(), humidity, signalStrength);
			receivedByArduino = receivedByArduinoService.saveOrUpdate(receivedByArduino);
		}catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao tentar salvar os dados");
		}
	
		return new ResponseEntity<ReceivedByArduino>(receivedByArduino ,HttpStatus.OK);
	}
	
	@GetMapping("/save")
	public ResponseEntity<String> save(
					@RequestParam(name = "humidity", required = true) Integer humidity,
					@RequestParam(name = "signalStrength", required = true) Integer signalStrength){
		
		ReceivedByArduino receivedByArduino;
		try {
			receivedByArduino = new ReceivedByArduino(Utilities.today(), humidity, signalStrength);
			receivedByArduino = receivedByArduinoService.saveOrUpdate(receivedByArduino);
		}catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao tentar salvar os dados");
		}
		String myReturn = "";
		
		Parameters parameters = parametersService.findById(1);
		if(parameters != null) {
			myReturn += parameters.getIrrigate() != null ? parameters.getIrrigate()+",," : ",,";
			myReturn += parameters.getCriticalHumidity() != null ? parameters.getCriticalHumidity()+",," : ",,";
			myReturn += parameters.getMilliseconds() != null ? parameters.getMilliseconds()+"" : "";
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-length", myReturn.length()+"");
		
		return new ResponseEntity<String>(myReturn, headers, HttpStatus.OK);
	}
	
	@GetMapping("/listReadings")
	public ResponseEntity<List<ReceivedByArduino>> listReadings(){
		
		List<ReceivedByArduino> listReadings;
		try {
			listReadings = receivedByArduinoService.findAll();
		}catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao tentar listar as leituras salvas.");
		}
		
		return new ResponseEntity<List<ReceivedByArduino>>(listReadings, HttpStatus.OK);
	}
}
