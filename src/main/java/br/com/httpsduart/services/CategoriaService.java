package br.com.httpsduart.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.httpsduart.entities.Categoria;
import br.com.httpsduart.repositories.CategoriaRepository;

public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public String inserir(Categoria categoria) {
		categoriaRepository.save(categoria);
		return "Categoria salva com sucesso "+ categoria;
	}

	public String editar(UUID id, Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Categoria> getById(UUID id) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(id);
	}

	public List<Categoria> getAll() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	public String excluir(UUID id) {
		categoriaRepository.deleteById(id);
		return "Categoria com id: " + id + " excluída com sucesso";
	}

}
