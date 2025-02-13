package backend.taskwave.api.services;


import backend.taskwave.api.models.UsuarioModel;
import backend.taskwave.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<UsuarioModel> findUserByEmail(String email){
        return repository.findByEmail(email);
    }


    // metodo para autenticar um usuario com base no email e senha
    public boolean autenticateUser(String email, String senha){
        Optional<UsuarioModel> usuarioModelOptional = repository.findByEmail(email);

        if (usuarioModelOptional.isPresent()){
            UsuarioModel usuario = usuarioModelOptional.get(); // se existir, verifica senha
            //System.out.println("Usuario encontrado" + usuario.getEmail()); // log de teste
            boolean senhaCorreta = passwordEncoder.matches(senha, usuario.getSenha());
            //System.out.println("Senha correta?" + senhaCorreta); // log de teste senha
            return senhaCorreta;
        } else {
            return false;
        }
    }
}
