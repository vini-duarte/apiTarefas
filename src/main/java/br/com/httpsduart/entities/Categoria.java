package br.com.httpsduart.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "categorias")
@Entity
public class Categoria {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "informacoes", nullable = false)
	private String informacoes;	
	
	@OneToMany
	private List<Tarefa> tarefas;
}
