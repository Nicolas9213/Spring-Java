package br.senai.sc.demo.controller;

import br.senai.sc.demo.model.Usuario;
import br.senai.sc.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Notação que determina o estereótipo dessa classe

@RequestMapping("/usuario")

public class UsuarioController {

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Integer id) {
        return usuarioService.buscarUsuario(id);
    } //São as interfaces de comunicação com o ambiente externo
    //O Retorno do Get pode ser um objeto único(Recebe o id e busca um elemento no Banco de Dados) ou reber um
    //status e retornar uma lista
    //Injeta a dependência automaticamente
    private final UsuarioService usuarioService;

    @GetMapping
    private List<Usuario> buscarUsuarios(){
        return usuarioService.buscarUsuarios();
    }

    @PostMapping
    public String createUser(@RequestBody Usuario usuario) { //Body é a informação bruta que está sendo passada
        // (Get e Delete não usam)
        usuarioService.salvarUsuario(usuario);
        return "Olá " + usuario.getNome() + ".\n" + usuario;
        //Post recebe as informações e salva em algum lugar
    }

    @PutMapping("/id")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) { // Faz a alteração ou ajuste de uma quantidade maior de informações
        return usuarioService.atualizarUsuario(id, usuario);
    }

    @PutMapping
    public Usuario atualizarUsuario(@RequestBody Usuario usuario) { // Faz a alteração ou ajuste de uma quantidade maior de informações
        return usuarioService.atualizarUsuario(usuario);
    }

    @PatchMapping("/id")
    public Usuario atualizarSenha(@PathVariable Integer id, @RequestBody String senha) { //Alteração ou atualização de um ou dois atrtibutos
        return usuarioService.atualizarSenha(id, senha);
    }

    @DeleteMapping
    public void deletarUsuario(@RequestParam Integer id) { //Pode deletar ou desabilitar alguma informação do banco
        usuarioService.deletarUsuario(id);
    }
    //Get, Put, Patch, Post, Delete são métodos HTTP
}
