package com.beije.spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beije.spring.demo.dao.StudenteRepository;
import com.beije.spring.demo.model.Studente;

@Service
public class StudenteService {
	
	@Autowired
	private StudenteRepository studenteRepository;

	public void save(Studente studente) {
		studenteRepository.save(studente);
	}
	
	public void update(Studente studente) {
		studenteRepository.update(studente);
	}
	
	public void delete(Integer id) {
		studenteRepository.delete(id);
	}
	
	public List<Studente> list(){
		return studenteRepository.list();
	}
	
	public Studente findOne(String nome) {
		return studenteRepository.findOne(nome);
	}

	public Studente findById(Integer id) {
		return studenteRepository.findById(id);
		
	}
	
}
