package backend.taskwave.api.services;


import backend.taskwave.api.models.UsuarioModel;
import backend.taskwave.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UsuarioModel registerUser(UsuarioModel usuarioModel) {

        usuarioModel.setSenha(passwordEncoder.encode(usuarioModel.getSenha()));
        return repository.save(usuarioModel);
    }
}
