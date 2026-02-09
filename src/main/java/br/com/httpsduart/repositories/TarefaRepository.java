package br.com.httpsduart.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.httpsduart.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {

}
