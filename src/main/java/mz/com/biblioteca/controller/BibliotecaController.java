package mz.com.biblioteca.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {
	@RequestMapping("/ola")
	public String showMessage() {
		return "Olá Mundo Spring Boot!!!";
	}
}
