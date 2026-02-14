package br.com.httpsduart.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.httpsduart.entities.Categoria;
import br.com.httpsduart.services.CategoriaService;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaservice;

	@PostMapping
	public String post(@RequestBody Categoria categoria) {
		return categoriaservice.inserir(categoria);
	}

	@PutMapping("/{id}")
	public Categoria put(@PathVariable UUID id, @RequestBody Categoria categoria) {
		return categoriaservice.editar(id, categoria);
	}

	@GetMapping("/{id}")
	public Categoria getById(@PathVariable UUID id) {
		return categoriaservice.buscarPorId(id);
	}

	@GetMapping
	public List<Categoria> getAll() {
		return categoriaservice.listarTodas();
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable UUID id) {
		return categoriaservice.excluir(id);
	}
}
