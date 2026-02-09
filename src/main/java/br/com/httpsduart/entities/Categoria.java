package br.com.httpsduart.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Categoria {
	
	private UUID id;
	private String nome;
	private String informacoes;
	
}
