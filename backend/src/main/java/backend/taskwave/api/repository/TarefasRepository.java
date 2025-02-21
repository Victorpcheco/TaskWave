package backend.taskwave.api.repository;

import backend.taskwave.api.models.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {
}
