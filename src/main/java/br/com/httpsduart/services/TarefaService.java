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
		tarefa.setId(UUID.randomUUID());
		
		tarefaRepository.save(tarefa);
		return "Tarefa inserida com sucesso";
	}
	
	public Tarefa editar(UUID id, Tarefa tarefaAtualizada) {
		tarefaRepository.findById(id);
		
		Tarefa tarefa = new Tarefa();
		tarefa.setId(id);
		tarefa.setNome(tarefaAtualizada.getNome());
		tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
		tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
		tarefa.setObservacoes(tarefaAtualizada.getObservacoes());
		tarefa.setPrioridade(tarefaAtualizada.getPrioridade());
		tarefa.setConcluida(tarefaAtualizada.getConcluida());
		tarefa.setCategoria(tarefaAtualizada.getCategoria());
		
		return tarefaRepository.save(tarefa);
	}
}
