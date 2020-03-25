package br.com.phfedev.phvalidator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.phfedev.phvalidator.models.User;
import br.com.phfedev.phvalidator.repositories.UserRepository;
import br.com.phfedev.phvalidator.util.CnpjValidator;
import br.com.phfedev.phvalidator.util.CpfValidator;
import br.com.phfedev.phvalidator.util.RequestCounter;

@RestController
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/adduser", produces = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
	public User addNewUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}

	@PostMapping(path = "/cpf", produces = MediaType.APPLICATION_JSON_VALUE)
	public String valdiaCpf(@RequestBody CpfValidator cpfValidator, Authentication auth) {
		User user = userRepository.findByUsername(auth.getName());
		user.addCounter();
		userRepository.save(user);
		return CpfValidator.isCPF(cpfValidator.getCpf());
	}

	@PostMapping(path = "/cnpj", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validaCnpj(@RequestBody CnpjValidator cnpjValidator, Authentication auth) {
		User user = userRepository.findByUsername(auth.getName());
		user.addCounter();
		userRepository.save(user);
		return CnpjValidator.isCNPJ(cnpjValidator.getCnpj());
	}

	@GetMapping(path = "/request", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getRequestCounter(Authentication auth) {
		User user = userRepository.findByUsername(auth.getName());
		return RequestCounter.getPrice(user.getRequestCounter());
	}

}
