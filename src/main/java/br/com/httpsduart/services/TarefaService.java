package br.com.httpsduart.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.httpsduart.entities.Categoria;
import br.com.httpsduart.entities.Tarefa;
import br.com.httpsduart.repositories.CategoriaRepository;
import br.com.httpsduart.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Tarefa buscarPorId(UUID id) {
		return tarefaRepository.findById(id)
				.orElseThrow(()
						-> new RuntimeException("Tarefa não Encontrada"));
	}

	public List<Tarefa> listarTodas() {
		return tarefaRepository.findAll();
	}

	public String excluir(UUID id) {
		buscarPorId(id);
		
		tarefaRepository.deleteById(id);
		return "Tarefa excluída com sucesso";
	}

	public String inserir(Tarefa tarefa) {
		Categoria categoria = categoriaRepository.findById(tarefa.getCategoria().getId())
		.orElseThrow(() -> new RuntimeException("Categoria não Encontrada"));
		
		categoria.getTarefas().add(tarefa);

		tarefaRepository.save(tarefa);
		return "Tarefa inserida com sucesso" + tarefa;
	}

	public Tarefa editar(UUID id, Tarefa tarefaAtualizada) {
		buscarPorId(id);

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
