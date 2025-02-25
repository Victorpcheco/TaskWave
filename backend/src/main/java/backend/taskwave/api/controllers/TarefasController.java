package backend.taskwave.api.controllers;


import backend.taskwave.api.dto.TarefaDTO;
import backend.taskwave.api.dto.TarefaUpdateDTO;
import backend.taskwave.api.dto.UpdateStatusTaskDTO;
import backend.taskwave.api.models.TarefasModel;
import backend.taskwave.api.services.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired
    private TarefasService service;

    @GetMapping
    public List<TarefasModel> allTasks(TarefasModel tarefasModel){
        return service.listarTasks(tarefasModel);
    }

    @PostMapping("/create")
    public ResponseEntity<TarefasModel> createTask(@RequestBody TarefaDTO tarefaDTO)   {
        TarefasModel createdTask = service.createTask(tarefaDTO);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TarefasModel> updateTask(@PathVariable Long id, @RequestBody TarefaUpdateDTO tarefaUpdateDTO){
        TarefasModel updateTask = service.updateTask(id, tarefaUpdateDTO);
        return ResponseEntity.ok(updateTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        try {
            service.deleteTask(id);
            return ResponseEntity.ok("Tarefa excluída com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tarefa não encontrada");
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<String> updateStatusTask(@PathVariable Long id, @RequestBody UpdateStatusTaskDTO updateStatusTaskDTO){
        try {
            service.updateStatusTask(id, updateStatusTaskDTO.getStatus());
            return ResponseEntity.ok("Status da tarefa atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tarefa não encontrada.");
        }

    }
}
