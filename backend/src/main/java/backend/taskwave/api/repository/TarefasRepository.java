package backend.taskwave.api.repository;

import backend.taskwave.api.models.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {

}
