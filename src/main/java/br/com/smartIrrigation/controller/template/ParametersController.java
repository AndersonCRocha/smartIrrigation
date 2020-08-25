package br.com.smartIrrigation.controller.template;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.smartIrrigation.bean.Parameters;
import br.com.smartIrrigation.service.ParametersService;

@Controller
@RequestMapping("/parameters")
public class ParametersController {
	
	@Autowired
	private ParametersService parametersService;
	
	@PostMapping("save")
	public void saveParameters(HttpServletResponse response, Parameters parameters) throws IOException {
		parametersService.saveOrUpdate(parameters);
		response.sendRedirect("/readings");
		return;
	}
	
}