package backend.taskwave.api.services;

import backend.taskwave.api.models.TarefasModel;
import backend.taskwave.api.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository repository;

    public List<TarefasModel> listTasks(Long usuario_id)   {
        return repository.findByUsuarioId(usuario_id);
    }






}
