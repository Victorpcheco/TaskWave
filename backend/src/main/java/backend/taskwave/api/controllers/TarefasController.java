package backend.taskwave.api.controllers;


import backend.taskwave.api.models.TarefasModel;
import backend.taskwave.api.services.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired
    private TarefasService service;

    @GetMapping("/usuarios/{usuarioId}")
    public List<TarefasModel> listarTarefasPorUsuario(@PathVariable Long usuarioId){
        return service.listarTarefasPorUsuario(usuarioId);
    }


}
