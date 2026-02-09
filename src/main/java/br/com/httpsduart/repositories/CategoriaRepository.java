package br.com.httpsduart.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.httpsduart.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

}
