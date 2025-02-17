package backend.taskwave.api.controllers;


import backend.taskwave.api.models.TarefasModel;
import backend.taskwave.api.services.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired
    private TarefasService service;

    @GetMapping("/listarTarefas")
    public List<TarefasModel> listarTarefas(){
        return service.listTasks(null);
    }


}
