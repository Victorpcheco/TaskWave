package backend.taskwave.api.services;

import backend.taskwave.api.models.TarefasModel;
import backend.taskwave.api.repository.TarefasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarefasService {

    private static final Logger logger = LoggerFactory.getLogger(TarefasService.class);

    @Autowired
    private TarefasRepository repository;

    public List<TarefasModel> listarTarefasPorUsuario(Long usuarioId)   {
        logger.info("Buscando tarefas para o usuário ID: {}", usuarioId);
        List<TarefasModel> tarefas = repository.findByUsuarioId(usuarioId);
        logger.info("Tarefas encontradas: {}", tarefas);
        return tarefas;

    }






}
