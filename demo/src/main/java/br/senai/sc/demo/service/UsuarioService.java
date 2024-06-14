package br.senai.sc.demo.service;

import br.senai.sc.demo.model.Usuario;
import br.senai.sc.demo.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuario (Integer id) throws Exception {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Usuário não encontrado!");
        }
    }

    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    private void validarUsuario(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        validarUsuario(usuario.getId());
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuario) {
        validarUsuario(id);
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarSenha (Integer id, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setSenha(senha);
            return usuarioRepository.save(usuario);
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    public void deletarUsuario (Integer id) {
        validarUsuario(id);
        usuarioRepository.deleteById(id);
        if (usuarioRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível deletar o usuário de id " + id);
        }
    }
}