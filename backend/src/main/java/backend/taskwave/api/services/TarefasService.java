package backend.taskwave.api.services;

import backend.taskwave.api.dto.TarefaDTO;
import backend.taskwave.api.dto.TarefaUpdateDTO;
import backend.taskwave.api.models.TarefasModel;
import backend.taskwave.api.repository.TarefasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TarefasService {

    private static final Logger logger = LoggerFactory.getLogger(TarefasService.class);

    @Autowired
    private TarefasRepository repository;

    public List<TarefasModel> listarTasks(TarefasModel tarefas){
       return repository.findAll();
    }

    public TarefasModel createTask(TarefaDTO tarefaDTO){
        // converter DTO para a entidade
        TarefasModel tarefa = new TarefasModel();
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setStatus(tarefaDTO.getStatus());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setUsuario_id(tarefaDTO.getUsuario_id());
        tarefa.setData_criacao(LocalDateTime.now());
       return repository.save(tarefa);
    }

    public TarefasModel updateTask(Long id, TarefaUpdateDTO tarefaUpdateDTO) {
        TarefasModel tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setTitulo(tarefaUpdateDTO.getTitulo());
        tarefa.setDescricao(tarefaUpdateDTO.getDescricao());
        tarefa.setStatus(tarefaUpdateDTO.getStatus());

        return repository.save(tarefa);
    }

    public void deleteTask(Long id) {
        Optional<TarefasModel> task = repository.findById(id);
        if (task.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Tarefa não encontrada!");
        }
    }

    public void updateStatusTask (Long id, String newStatus) {
        Optional<TarefasModel> task = repository.findById(id);
        if (task.isPresent()){
            TarefasModel existingTask = task.get();
            existingTask.setStatus(newStatus);
            repository.save(existingTask);

        } else {
            throw new RuntimeException("Tarefa não encontrada");
        }
    }






}
