package backend.taskwave.api.controllers;


import backend.taskwave.api.models.UsuarioModel;
import backend.taskwave.api.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/register")
    public ResponseEntity<UsuarioModel> registerNewUser(@Valid @RequestBody UsuarioModel usuarioModel){
        UsuarioModel usuarioRegistrado = service.registerUser(usuarioModel);
        return ResponseEntity.ok(usuarioRegistrado); // retorno 200 (ok) usuario registrado.
    }
}
