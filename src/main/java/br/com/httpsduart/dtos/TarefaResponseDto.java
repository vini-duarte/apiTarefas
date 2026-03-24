package br.com.httpsduart.dtos;

import java.sql.Date;
import java.util.UUID;

import br.com.httpsduart.entities.Categoria;
import lombok.Data;

@Data
public class TarefaResponseDto {
	
	private UUID id;
	private String nome;
	private Date dataInicio;
	private Date dataEntrega;
	private String prioridade;
	private String observacoes;
	private Boolean concluida;
	private Categoria categoria;
	
}
