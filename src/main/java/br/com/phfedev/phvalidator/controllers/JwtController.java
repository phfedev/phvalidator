package br.com.phfedev.phvalidator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.phfedev.phvalidator.config.JwtTokenUtil;
import br.com.phfedev.phvalidator.models.JwtRequest;
import br.com.phfedev.phvalidator.models.JwtResponse;
import br.com.phfedev.phvalidator.models.User;
import br.com.phfedev.phvalidator.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		if (authenticationRequest.getUsername() == null || authenticationRequest.getPassword() == null) {
			return ResponseEntity.status(400)
					.body("{" + "error: \"username and password key expected\"," + "username: \""
							+ authenticationRequest.getUsername() + "\"," + "password: \""
							+ authenticationRequest.getPassword() + "\"" + "}");
		} else {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
		if (user.getUsername() == null || user.getPassword() == null) {
			return ResponseEntity.status(400).body("{" + "error: \"username and password key expected\","
					+ "username: \"" + user.getUsername() + "\"," + "password: \"" + user.getPassword() + "\"" + "}");
		} else {
			return ResponseEntity.ok(userDetailsService.save(user));
		}
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
