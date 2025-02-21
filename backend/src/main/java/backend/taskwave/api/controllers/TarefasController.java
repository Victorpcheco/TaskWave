package backend.taskwave.api.controllers;


import backend.taskwave.api.dto.TarefaDTO;
import backend.taskwave.api.models.TarefasModel;
import backend.taskwave.api.services.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
