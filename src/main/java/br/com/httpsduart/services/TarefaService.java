package br.com.httpsduart.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.httpsduart.entities.Tarefa;
import br.com.httpsduart.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	public Optional<Tarefa> getById(UUID id) {
		return tarefaRepository.findById(id); 
	}
	public List<Tarefa> getAll() {
        return tarefaRepository.findAll();
    }
	
	public String excluir(UUID id) {
		tarefaRepository.deleteById(id);
		return "Tarefa excluída com sucesso";
	}
	
	public String inserir(Tarefa tarefa) {
		tarefaRepository.save(tarefa);
		return "Tarefa inserida com sucesso";
	}
	
	public String editar(UUID id, Tarefa tarefa) {
		tarefaRepository.findById(id);
		
		return null;
	}
}
