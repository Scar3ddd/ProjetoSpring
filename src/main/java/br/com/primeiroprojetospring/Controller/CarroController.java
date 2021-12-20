package br.com.primeiroprojetospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.primeiroprojetospring.domain.Carro;
import br.com.primeiroprojetospring.service.CarroService;
import br.com.primeiroprojetospring.service.ChaveService;
import br.com.primeiroprojetospring.service.DocumentoService;


@Controller
@RequestMapping("carro")  // localhost:8080/carro
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	private ChaveService chaveService;
	
	@Autowired
	private DocumentoService documentoService;
	
	// @Autowired
	// private AcessorioService acessorioService;
	
	@GetMapping("/listaCarros")      //AQUI ESTA A URL
	public ModelAndView  listaTodosCarro() {
		ModelAndView mView = new ModelAndView("carro/paginaListaCarros");    // AQUI REFERENCIA A PAGINA HTML
		mView.addObject("carro", carroService.buscarTodosCarros());
		return mView;
	}
	
	@GetMapping("/cadastrar")  //AQUI ESTA A URL
	public ModelAndView cadastrarCarro() {
		ModelAndView mView = new ModelAndView("carro/cadastrarCarro");  // AQUI REFERENCIA A PAGINA HTML
		mView.addObject("carro", new Carro());
		mView.addObject("chaves", chaveService.buscarTodasChaves());
		mView.addObject("documentos", documentoService.buscarTodosDocumentos());
		return mView;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarCarro(Carro carro) {
		carroService.salvar(carro);
		return listaTodosCarro();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alteraCarro(@PathVariable("id") Integer idCarro) {
		ModelAndView mView = new ModelAndView("carro/alteraCarro");
		mView.addObject("carro", carroService.buscarCarroID(idCarro));	
		mView.addObject("chaves", chaveService.buscarTodasChaves());
		mView.addObject("documentos", documentoService.buscarTodosDocumentos());
		return mView;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Carro carroAlterado) {
		carroService.salvarAlteracao(carroAlterado);
		return listaTodosCarro();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Integer id) {
		carroService.excluir(id);
		return listaTodosCarro();
	}

}
