package br.com.phfedev.phvalidator.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.phfedev.phvalidator.models.User;
import br.com.phfedev.phvalidator.util.RequestCounter;
import br.com.phfedev.phvalidator.util.ValidaCNPJ;
import br.com.phfedev.phvalidator.util.ValidaCPF;

@RestController
public class UserController {
	

	@PostMapping(path= "/cpf", produces = MediaType.APPLICATION_JSON_VALUE)
	public String valdiaCpf(@RequestBody User user) {
		RequestCounter.add();
		System.out.println(RequestCounter.getQuantity());
		return ValidaCPF.isCPF(user.getCpf());
	}
	@PostMapping(path = "/cnpj", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validaCnpj(@RequestBody User user) {
		RequestCounter.add();
		System.out.println(RequestCounter.getQuantity());
		return ValidaCNPJ.isCNPJ(user.getCnpj());
	}
	@GetMapping(path = "/request", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getRequestCounter() {
		return RequestCounter.getPrice();
	}
}