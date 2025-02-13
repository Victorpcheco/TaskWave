package backend.taskwave.api.controllers;


import backend.taskwave.api.Jwt.JwtUtil;
import backend.taskwave.api.dto.LoginRequest;
import backend.taskwave.api.dto.LoginResponse;
import backend.taskwave.api.models.UsuarioModel;
import backend.taskwave.api.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioService service;

    @PostMapping("/register")
    public ResponseEntity<UsuarioModel> registerNewUser(@Valid @RequestBody UsuarioModel usuarioModel){
        System.out.println("Recebida requisição para registrar usuário: " + usuarioModel.getEmail());
        UsuarioModel usuarioRegistrado = service.registerUser(usuarioModel);
        return ResponseEntity.ok(usuarioRegistrado); // retorno 200 (ok) usuario registrado.
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        boolean autenticado = service.autenticateUser(request.getEmail(), request.getSenha());

        if(autenticado) { // se autenticado >>
            String token = jwtUtil.generateToken(request.getEmail());
            return ResponseEntity.ok(new LoginResponse(token)); // retorna o token com stts 200
        }
        else {
            return ResponseEntity.status(401).build();
        }
    }


}
