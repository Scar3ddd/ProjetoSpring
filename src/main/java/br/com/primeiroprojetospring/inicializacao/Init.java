package br.com.primeiroprojetospring.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationListener;

import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.stereotype.Component;

import br.com.primeiroprojetospring.domain.Aluno;

import br.com.primeiroprojetospring.domain.Professor;

import br.com.primeiroprojetospring.repository.ProfessorRepository;
import br.com.primeiroprojetospring.service.AlunoService;

@Component

public class Init implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private ProfessorRepository proRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

			Aluno aluno1 = new Aluno();
			aluno1.setNome("Julia");
			aluno1.setNome("Julia");
			alunoService.salvar(aluno1);
	
			Aluno aluno2 = new Aluno();
			aluno2.setNome("Raquel");
			alunoService.salvar(aluno2);
	
			Aluno aluno3 = new Aluno();
			aluno3.setNome("Amanda");
			alunoService.salvar(aluno3);
	
			List<Aluno> listaAluno = alunoService.buscarTodosAlunos();
	
			for (Aluno aluno : listaAluno) {
				System.out.println(aluno.getNome());
			}

						Professor pro1 = new Professor();
						pro1.setNome("Danilo Mc Sapão");
						proRepository.save(pro1);
				
								Professor pro2 = new Professor();
								pro2.setNome("André dos Cavalos");
								proRepository.save(pro2);
				
									Professor pro3 = new Professor();
									pro3.setNome("Raquel Risadinha");
									proRepository.save(pro3);
				
						List<Professor> listaProfessor = proRepository.findAll();
				
						for (Professor pro : listaProfessor) {
							System.out.println(pro.getNome());
		}

	}
}
