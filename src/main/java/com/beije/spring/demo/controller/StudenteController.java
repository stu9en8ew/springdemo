package com.beije.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.beije.spring.demo.model.Studente;
import com.beije.spring.demo.service.StudenteService;

@Controller
public class StudenteController {

	@Autowired
	private StudenteService studenteService;
	
	@GetMapping("/studente/cadastrar")
	public String create(Model model) {
		
		model.addAttribute("studente", new Studente());
		return "studente/cadastrar";
	}
	
	@PostMapping("/studente/salvar")
	public String save(@ModelAttribute Studente studente) {
		
		studenteService.save(studente);
		return "studente/listar";
	}
	
	@GetMapping("/studente/listar")
	public String list(Model model) {
		
		List<Studente> studenti = studenteService.list();
		model.addAttribute("studenti", studenti);
		return "studente/listar";
	}
	
	
}
