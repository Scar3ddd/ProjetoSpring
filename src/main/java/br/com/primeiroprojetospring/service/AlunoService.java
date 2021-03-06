package br.com.primeiroprojetospring.service;

import java.util.List;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.primeiroprojetospring.domain.Aluno;

import br.com.primeiroprojetospring.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> buscarTodosAlunos(){
		return alunoRepository.findAll();	
	}
	public Aluno salvar (Aluno aluno) {
		return alunoRepository.save(aluno);
		}
	
public Aluno salvarAlteracao(Aluno alunoAlterado)throws ObjectNotFoundException{
		Aluno aluno = buscarPorID(alunoAlterado.getId());
		aluno.setId(alunoAlterado.getId());
		aluno.setNome(alunoAlterado.getNome());
		return salvar(aluno);
	}
public Aluno buscarPorID(Integer id) throws ObjectNotFoundException {
	Optional<Aluno> aluno = alunoRepository.findById(id);
	return aluno.orElseThrow(() -> 
	new ObjectNotFoundException(new Aluno(), "Aluno não encontrado. id: " + id));
}
public void excluir(Integer id) {
	alunoRepository.deleteById(id);
}
}
