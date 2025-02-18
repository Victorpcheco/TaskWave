package backend.taskwave.api.repository;

import backend.taskwave.api.models.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {

    List<TarefasModel> findByUsuarioId(Long usuario_id);

}
