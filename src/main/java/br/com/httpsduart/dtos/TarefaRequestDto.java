package br.com.httpsduart.dtos;

import br.com.httpsduart.entities.Categoria;
import lombok.Data;

@Data
public class TarefaRequestDto {
	
	private String nome;
	private String prioridade;
	private String observações;
	private Boolean concluida;
	private Categoria categoria;
}
