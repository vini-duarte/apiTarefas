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

import br.com.httpsduart.entities.Tarefa;
import br.com.httpsduart.services.TarefaService;

@RestController
@RequestMapping("api/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaservice;

	@PostMapping
	public String post(@RequestBody Tarefa tarefa) {
		return tarefaservice.inserir(tarefa);
	}

	@PutMapping("/{id}")
	public Tarefa put(@PathVariable UUID id, @RequestBody Tarefa tarefa) {
		return tarefaservice.editar(id, tarefa);
	}

	@GetMapping("/{id}")
	public Tarefa getById(@PathVariable UUID id) {
		return tarefaservice.buscarPorId(id);
	}

	@GetMapping
	public List<Tarefa> getAll() {
		return tarefaservice.listarTodas();
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable UUID id) {
		return tarefaservice.excluir(id);
	}
}
