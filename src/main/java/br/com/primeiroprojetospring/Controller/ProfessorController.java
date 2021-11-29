package br.com.primeiroprojetospring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.primeiroprojetospring.domain.Professor;
import br.com.primeiroprojetospring.service.ProfessorService;
@Controller
@RequestMapping("professor")

public class ProfessorController {
	@Autowired
	private ProfessorService proService;
	
	@GetMapping("/listaProfessores")
	public ModelAndView listaTodosProfessor() {
		ModelAndView mView = new ModelAndView ("professor/paginaListaProfessores");
		mView.addObject("professores", proService.buscarTodosProfessor());
		return mView;	
	}
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarProfessor() {
		ModelAndView mView = new ModelAndView("professor/cadastraProfessor");
		mView.addObject("professor", new Professor());
		return mView;
	}
	@PostMapping("/salvar")
	public ModelAndView salvarProfessor (Professor pro) {
		proService.salvar(pro);
		return listaTodosProfessor();
	}
	
}
