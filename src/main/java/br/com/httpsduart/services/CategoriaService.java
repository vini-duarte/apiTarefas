package br.com.httpsduart.services;

import java.util.List;
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
		
		categoriaRepository.save(categoria);
		return "Categoria salva com sucesso "+ categoria;
	}

	public Categoria editar(UUID id, Categoria categoriaAtualizada) {
		buscarPorId(id);
		
		
		Categoria categoria = new Categoria();
		categoria.setId(id);
		categoria.setNome(categoriaAtualizada.getNome());
		categoria.setInformacoes(categoriaAtualizada.getInformacoes());
		
		return categoriaRepository.save(categoria);
	}

	public Categoria buscarPorId(UUID id) {
		return categoriaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
	}

	public List<Categoria> listarTodas() {
		return categoriaRepository.findAll();
	}

	public String excluir(UUID id) {
		buscarPorId(id);
		
		categoriaRepository.deleteById(id);
		return "Categoria com id: " + id + " excluída com sucesso";
	}

}
