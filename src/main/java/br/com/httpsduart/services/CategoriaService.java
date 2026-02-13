package br.com.httpsduart.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.httpsduart.entities.Categoria;
import br.com.httpsduart.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public String inserir(Categoria categoria) {
		categoria.setId(UUID.randomUUID());
		categoriaRepository.save(categoria);
		return "Categoria salva com sucesso "+ categoria;
	}

	public Categoria editar(UUID id, Categoria categoriaAtualizada) {
		
		Categoria categoria = new Categoria();
		categoria.setId(id);
		categoria.setNome(categoriaAtualizada.getNome());
		categoria.setInformacoes(categoriaAtualizada.getInformacoes());
		
		return categoriaRepository.save(categoria);
	}

	public Optional<Categoria> getById(UUID id) {
		return categoriaRepository.findById(id);
	}

	public List<Categoria> getAll() {
		return categoriaRepository.findAll();
	}

	public String excluir(UUID id) {
		categoriaRepository.deleteById(id);
		return "Categoria com id: " + id + " excluída com sucesso";
	}

}
