package br.com.httpsduart.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "categorias")
@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "informacoes", nullable = false)
	private String informacoes;	
	
	@JsonManagedReference
	@OneToMany
	@JoinColumn(name = "tarefas_id")
	private List<Tarefa> tarefas;
}
