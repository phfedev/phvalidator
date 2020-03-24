package br.com.phfedev.phvalidator.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.phfedev.phvalidator.models.User;
import br.com.phfedev.phvalidator.util.CnpjValidator;
import br.com.phfedev.phvalidator.util.CpfValidator;
import br.com.phfedev.phvalidator.util.RequestCounter;

@RestController
public class MainController {
	
//	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
//	public String authenticate(@RequestBody String login,@RequestBody String password) {
//		return "";
//	}
	
	@PostMapping(path= "/cpf", produces = MediaType.APPLICATION_JSON_VALUE)
	public String valdiaCpf(@RequestBody User user) {
		RequestCounter.add();
		System.out.println(RequestCounter.getQuantity());
		return CpfValidator.isCPF(user.getCpf());
	}
	@PostMapping(path = "/cnpj", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validaCnpj(@RequestBody User user) {
		RequestCounter.add();
		System.out.println(RequestCounter.getQuantity());
		return CnpjValidator.isCNPJ(user.getCnpj());
	}
	@GetMapping(path = "/request", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getRequestCounter() {
		return RequestCounter.getPrice();
	}
	
	
}
