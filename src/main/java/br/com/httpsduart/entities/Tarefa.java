package br.com.httpsduart.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.httpsduart.enums.NivelPrioridade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.BooleanFlag;
import lombok.Data;

@Entity
@Table(name = "tarefas")
@Data
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private UUID id;
	
	@Column(name = "nome", nullable = false, length = 25)
	private String nome;
	
	@Column(name = "dataInicio", nullable = false)
	private LocalDateTime dataInicio;
	
	
	@Column(name = "dataEntrega")
	private LocalDateTime dataEntrega;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "prioridade", nullable = false)
	private NivelPrioridade prioridade;
	
	@Column(name = "observacoes")
	private String observacoes;
	
	@Column(name = "concluida" )
	@BooleanFlag
	private Boolean concluida;
	
	
	private List<Categoria> categorias;

}
