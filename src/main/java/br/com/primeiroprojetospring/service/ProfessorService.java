package br.com.primeiroprojetospring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.primeiroprojetospring.repository.ProfessorRepository;
import br.com.primeiroprojetospring.domain.Professor;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository proRepository;

	public List<Professor> buscarTodosProfessor() {
		return proRepository.findAll();
	}

	public Professor salvarProfessor(Professor pro) {
		return proRepository.save(pro);
	}

}
