package br.com.phfedev.phvalidator.controllers;

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
	

	@PostMapping("/cpf")
	public String valdiaCpf(@RequestBody User user) {
		RequestCounter.add();
		System.out.println(RequestCounter.getQuantity());
		if(ValidaCPF.isCPF(user.getCpf())) {
			return "CPF Válido";			
		}else {
			return "CPF Inválido";
		}
	}
	@PostMapping("/cnpj")
	public String validaCnpj(@RequestBody User user) {
		RequestCounter.add();
		System.out.println(RequestCounter.getQuantity());
		if(ValidaCNPJ.isCNPJ(user.getCnpj())) {
			return "CNPJ Válido";			
		}else {
			return "CNPJ Inválido";
		}
	}
	@GetMapping("/request")
	public String getRequestCounter() {
		return "Quantidade:"+(int) RequestCounter.getQuantity()
			+"\n"+RequestCounter.getPrice();
	}
}
